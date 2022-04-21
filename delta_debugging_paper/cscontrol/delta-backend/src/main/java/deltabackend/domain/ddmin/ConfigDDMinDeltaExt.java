package deltabackend.domain.ddmin;

import com.baeldung.algorithms.ddmin.ParallelDDMinDelta;
import deltabackend.domain.api.request.DeltaCMResourceRequest;
import deltabackend.domain.api.response.DeltaCMResourceResponse;
import deltabackend.domain.bean.SingleDeltaCMResourceRequest;
import deltabackend.domain.configDelta.CM;
import deltabackend.domain.configDelta.CMConfig;
import deltabackend.domain.configDelta.ConfigDeltaResponse;
import deltabackend.domain.configDelta.NewSingleDeltaCMResourceRequest;
import deltabackend.domain.test.DeltaTestRequest;
import deltabackend.domain.test.DeltaTestResponse;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessageType;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.client.RestTemplate;
import java.util.*;

public class ConfigDDMinDeltaExt extends ParallelDDMinDelta {
    private RestTemplate res_Temp = new RestTemplate();
    private SimpMessagingTemplate temp ;
    private String s_Id;
    private Map<String, String> ul_map = new HashMap<String, String>();
    private List<SingleDeltaCMResourceRequest> env_org;
    private List<SingleDeltaCMResourceRequest> env_ul;
    private Map<String, SingleDeltaCMResourceRequest> d_map = new HashMap<String, SingleDeltaCMResourceRequest>();
    private String exp = "exception";

    public ConfigDDMinDeltaExt(List<String> tests, List<SingleDeltaCMResourceRequest> env, String id, SimpMessagingTemplate t, List<String> cs) {
        super();
        clusters = cs;
        ul_map.put("memory", "1000Mi");
        ul_map.put("cpu", "500m");
        env_ul = new ArrayList<SingleDeltaCMResourceRequest>();
        for(SingleDeltaCMResourceRequest s : env){
            SingleDeltaCMResourceRequest a = new SingleDeltaCMResourceRequest();
            a.setServiceName(s.getServiceName());
            a.setType(s.getType());
            a.setKey(s.getKey());
            a.setValue(ul_map.get(s.getKey()));
            env_ul.add(a);
        }

        testcases = tests;
        env_org = env;
        s_Id = id;
        deltas_all = new ArrayList<String>();
        temp = t;
        for(SingleDeltaCMResourceRequest p: env){
            SingleDeltaCMResourceRequest q = new SingleDeltaCMResourceRequest();
            q.setServiceName(p.getServiceName());
            q.setType(p.getType());
            q.setKey(p.getKey());
            q.setValue(p.getValue());
            d_map.put(q.getServiceName() + ":" + q.getType()+ ":" + q.getKey()+ ":" + q.getValue(), q);
            deltas_all.add(q.getServiceName() + ":" + q.getType()+ ":" + q.getKey()+ ":" + q.getValue());
        }
        expectError = "fail";
        expectPass = "pass";
    }


    public boolean recoverEnv(){
        for(String s : clusters){
            DeltaCMResourceResponse r1 = modifyConfigsOfServices(transformToNewConfigDS(env_org), s);
            if(! r1.isStatus()){
                return false;
            }
        }
        return true;
    }


    public boolean applyDelta(List<String> deltas, String cluster) {
        List<SingleDeltaCMResourceRequest> env = new ArrayList<SingleDeltaCMResourceRequest>();
        for(String s: deltas){
            SingleDeltaCMResourceRequest e = d_map.get(s);
            env.add(e);
        }
        for(SingleDeltaCMResourceRequest sdcr1: env_ul ){
            boolean toAdjust = false;
            for(SingleDeltaCMResourceRequest sdcr2: env){
                if(sdcr1.getServiceName().equals(sdcr2.getServiceName()) && sdcr1.getType().equals(sdcr2.getType()) && sdcr1.getKey().equals(sdcr2.getKey()) ){
                    toAdjust = true;
                }
            }
            if(toAdjust == false){
                env.add(sdcr1);
            }
        }
        DeltaCMResourceResponse r2 = modifyConfigsOfServices(transformToNewConfigDS(env), cluster);
        if( ! r2.isStatus()){
            return false;
        }
        return true;
    }

    private List<NewSingleDeltaCMResourceRequest> transformToNewConfigDS(List<SingleDeltaCMResourceRequest> list){
        System.out.println("^^^^ transformToNewConfigDS original ^^^^^^ " + list);

        List<NewSingleDeltaCMResourceRequest> list_n = new ArrayList<NewSingleDeltaCMResourceRequest>();
        Set<String> eServ = new HashSet<String>();
        for(SingleDeltaCMResourceRequest l: list){
            if(eServ.contains(l.getServiceName())){
                for(NewSingleDeltaCMResourceRequest d: list_n){
                    if(d.getServiceName().equals(l.getServiceName())){
                        int hasSameType = 0;
                        if( d.getConfigs().size() > 0){
                            for(CMConfig cm : d.getConfigs()){
                                if(cm.getType().equals(l.getType())){
                                    hasSameType = 1;
                                    cm.addValues(new CM(l.getKey(), l.getValue()));
                                    break;
                                }
                            }
                        }
                        if(hasSameType == 0){
                            CMConfig e = new CMConfig();
                            e.setType(l.getType());
                            e.addValues(new CM(l.getKey(), l.getValue()));
                            d.getConfigs().add(e);
                        }
                    }
                }
            } else {
                eServ.add(l.getServiceName());
                NewSingleDeltaCMResourceRequest newL = new NewSingleDeltaCMResourceRequest();
                newL.setServiceName(l.getServiceName());
                List<CMConfig> newConfig = new ArrayList<CMConfig>();
                CMConfig cmc = new CMConfig();
                cmc.setType(l.getType());
                cmc.addValues(new CM(l.getKey(), l.getValue()));
                newConfig.add(cmc);
                newL.setConfigs(newConfig);
                list_n.add(newL);
            }
        }
        System.out.println("++++++++++ transformToNewConfigDS ++++++++++++ " + list_n);
        return list_n;
    }


    public String processAndGetResult(List<String> deltas, List<String> testcases, String cluster) {
        // execute testcases
        DeltaTestResponse res = deltaTests(testcases, cluster);
        List<SingleDeltaCMResourceRequest> env = new ArrayList<SingleDeltaCMResourceRequest>();
        System.out.println();
        System.out.println("***** processAndGetResult *****   " + deltas);
        System.out.println();
        for(String s: deltas){
            SingleDeltaCMResourceRequest e = d_map.get(s);
            env.add(e);
        }
        responseToUser(env, res);

        String returnResult = "";
        if(res.getStatus() == 1){
            returnResult = expectPass;
        } else if(res.getStatus() == 0){
            returnResult = expectError;
        } else {
            returnResult = exp;
        }
        System.out.println("******** returnResult *******" + returnResult);
        return returnResult;
    }


    private DeltaTestResponse deltaTests(List<String> testNames, String cluster){
        DeltaTestRequest dtr = new DeltaTestRequest();
        dtr.setTestNames(testNames);
        dtr.setCluster(cluster);
        DeltaTestResponse res = res_Temp.postForObject(
                "http://test-backend:5001/testBackend/deltaTest",dtr,
                DeltaTestResponse.class);
        return res;
    }


    private DeltaCMResourceResponse modifyConfigsOfServices(List<NewSingleDeltaCMResourceRequest> env, String cluster) {
        DeltaCMResourceRequest dcr = new DeltaCMResourceRequest();
        dcr.setDeltaRequests(env);
        dcr.setClusterName(cluster);
        System.out.println();
        for(NewSingleDeltaCMResourceRequest e: env){
            System.out.println("--modifyConfigsOfServices--" + cluster + ": " + e.getServiceName() + ": " + e.getConfigs() );
        }
        DeltaCMResourceResponse r = res_Temp.postForObject(
                "http://api-server:18898/api/deltaCMResource",dcr,
                DeltaCMResourceResponse.class);
        System.out.println("--modifyConfigsOfServices--" + r.isStatus() + ": " + r.getMessage());
        System.out.println();
        return r;
    }

    //////////////////////////////////// send res to user ////////////////////////////////////////////////////
    private void responseToUser(List<SingleDeltaCMResourceRequest> env, DeltaTestResponse res){
        ConfigDeltaResponse dr = new ConfigDeltaResponse();
        if(res.getStatus() == -1){ //the backend throw an exception, stop the delta test, maybe the testcase not exist
            dr.setStatus(false);
            dr.setMessage(res.getMessage());
            temp.convertAndSendToUser(s_Id,"/topic/configDeltaResponse" ,dr, createHeaders(s_Id));
        }
        dr.setStatus(true);//just mean the test case has been executed
        dr.setEnv(env);
        dr.setMessage(res.getMessage());
        dr.setResult(res);
        temp.convertAndSendToUser(s_Id,"/topic/configDeltaResponse" ,dr, createHeaders(s_Id));
    }

    private MessageHeaders createHeaders(String s_Id) {
        SimpMessageHeaderAccessor headerAccessor = SimpMessageHeaderAccessor.create(SimpMessageType.MESSAGE);
        headerAccessor.setSessionId(s_Id);
        headerAccessor.setLeaveMutable(true);
        return headerAccessor.getMessageHeaders();
    }


}
