package deltabackend.domain.ddmin;

import com.baeldung.algorithms.ddmin.ParallelDDMinDelta;
import deltabackend.domain.api.request.SetServiceReplicasRequest;
import deltabackend.domain.api.response.SetServiceReplicasResponse;
import deltabackend.domain.bean.ServiceWithReplicas;
import deltabackend.domain.test.DeltaTestRequest;
import deltabackend.domain.test.DeltaTestResponse;
import deltabackend.domain.bean.ServiceReplicasSetting;
import deltabackend.domain.instanceDelta.DeltaResponse;
import deltabackend.util.MyConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessageType;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.client.RestTemplate;
import java.util.*;


public class InstanceDDMinDeltaExt extends ParallelDDMinDelta {
    private RestTemplate res_temp = new RestTemplate();
    private SimpMessagingTemplate temp ;
    private String s_Id;
    private int ins_DN = 2;
    private List<ServiceWithReplicas> env_org;
    private Map<String, ServiceWithReplicas> d_map = new HashMap<String, ServiceWithReplicas>();
    private String exp = "exception";

    public InstanceDDMinDeltaExt(List<String> tests, List<ServiceWithReplicas> env, String id, SimpMessagingTemplate t, List<String> cs) {
        super();
        clusters = cs;
        testcases = tests;
        env_org = env;
        s_Id = id;
        deltas_all = new ArrayList<String>();
        temp = t;
        for(ServiceWithReplicas p: env){
            ServiceWithReplicas q = new ServiceWithReplicas();
            q.setServiceName(p.getServiceName());
            q.setNumOfReplicas(ins_DN);
            d_map.put(p.getServiceName(), q);
            deltas_all.add(p.getServiceName());
        }
        expectError = "fail";
        expectPass = "pass";
    }


    public boolean applyDelta(List<String> deltas, String clus) {
        List<ServiceWithReplicas> env = new ArrayList<ServiceWithReplicas>();
        for(String s: deltas){
            ServiceWithReplicas e = d_map.get(s);
            env.add(e);
        }
        for(ServiceWithReplicas swr1: env_org){
            boolean toAdjust = false;
            for(ServiceWithReplicas swr2: env){
                if(swr1.getServiceName().equals(swr2.getServiceName())){
                    toAdjust = true;
                }
            }
            if(toAdjust == false){
                env.add(swr1);
            }
        }
        System.out.println("&&&& instance deltas to apply: &&&&& " + env);
        SetServiceReplicasResponse ssrr2 = setInstanceNumOfServices(env, clus);
        if( ! ssrr2.isStatus()){
            return false;
        }
        return true;
    }

    public boolean recoverEnv(){
        for(String s : clusters){
            SetServiceReplicasResponse ssrr1 = setInstanceNumOfServices(env_org, s);
            if(! ssrr1.isStatus()){
                return false;
            }
        }
        return true;
    }

    public String processAndGetResult(List<String> deltas, List<String> testcases, String clus) {
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println();
        }

        DeltaTestResponse res = deltaTests(testcases, clus);
        List<ServiceWithReplicas> env = new ArrayList<ServiceWithReplicas>();
        System.out.println();
        System.out.println("***** processAndGetResult *****   " + deltas);
        System.out.println();
        for(String s: deltas){
            ServiceWithReplicas e = d_map.get(s);
            env.add(e);
        }
        responseToUser(env, res);

        String res_return = "";
        if(res.getStatus() == 1){
            res_return = expectPass;
        } else if(res.getStatus() == 0){
            res_return = expectError;
        } else {
            res_return = exp;
        }
        System.out.println("******** res_return *******" + res_return);
        return res_return;
    }

    private DeltaTestResponse deltaTests(List<String> testn, String clus){
        DeltaTestRequest dtr = new DeltaTestRequest();
        dtr.setTestNames(testn);
        dtr.setCluster(clus);
        DeltaTestResponse res = res_temp.postForObject(
                "http://test-backend:5001/testBackend/deltaTest",dtr,
                DeltaTestResponse.class);
        return res;
    }

    private SetServiceReplicasResponse setInstanceNumOfServices(List<ServiceWithReplicas> env, String clus) {
        SetServiceReplicasRequest ssrr = new SetServiceReplicasRequest();
        List<ServiceReplicasSetting> l = new ArrayList<ServiceReplicasSetting>();
        for(ServiceWithReplicas swr: env){
            ServiceReplicasSetting srs = new ServiceReplicasSetting();
            srs.setServiceName(swr.getServiceName());
            srs.setNumOfReplicas(swr.getNumOfReplicas());
            l.add(srs);
        }
        ssrr.setServiceReplicasSettings(l);
        ssrr.setClusterName(clus);

        System.out.println();
        for(ServiceWithReplicas e: env){
            System.out.println("--setInstanceNumOfServices--" + e.getServiceName() + ": " + e.getNumOfReplicas());
        }
        SetServiceReplicasResponse ssresult = res_temp.postForObject(
                "http://api-server:18898/api/setReplicas",ssrr,
                SetServiceReplicasResponse.class);
        System.out.println("--setInstanceNumOfServices--" + ssresult.isStatus() + ": " + ssresult.getMessage());
        System.out.println();
        return ssresult;
    }

    //////////////////////////////////// Share res with user ////////////////////////////////////////////////////
    private void responseToUser(List<ServiceWithReplicas> env, DeltaTestResponse res){
        DeltaResponse dr = new DeltaResponse();
        if(res.getStatus() == -1){ //the backend throw an exception, stop the delta test, maybe the testcase not exist
            dr.setStatus(false);
            dr.setMessage(res.getMessage());
            temp.convertAndSendToUser(s_Id,"/topic/deltaresponse" ,dr, createHeaders(s_Id));
        }
        dr.setStatus(true);//just mean the test case has been executed
        dr.setEnv(env);
        dr.setMessage(res.getMessage());
        dr.setResult(res);
        temp.convertAndSendToUser(s_Id,"/topic/deltaresponse" ,dr, createHeaders(s_Id));
    }

    private MessageHeaders createHeaders(String s_Id) {
        SimpMessageHeaderAccessor headerAccessor = SimpMessageHeaderAccessor.create(SimpMessageType.MESSAGE);
        headerAccessor.setSessionId(s_Id);
        headerAccessor.setLeaveMutable(true);
        return headerAccessor.getMessageHeaders();
    }


}
