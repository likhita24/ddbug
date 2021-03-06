package deltabackend.domain.ddmin;

import com.baeldung.algorithms.ddmin.ParallelDDMinDelta;
import deltabackend.domain.api.request.*;
import deltabackend.domain.api.response.DeltaCMResourceResponse;
import deltabackend.domain.api.response.SetAsyncRequestSequenceResponse;
import deltabackend.domain.api.response.SetServiceReplicasResponse;
import deltabackend.domain.api.response.SimpleResponse;
import deltabackend.domain.bean.ServiceReplicasSetting;
import deltabackend.domain.bean.ServiceWithReplicas;
import deltabackend.domain.bean.SingleDeltaCMResourceRequest;
import deltabackend.domain.configDelta.CM;
import deltabackend.domain.configDelta.CMConfig;
import deltabackend.domain.configDelta.NewSingleDeltaCMResourceRequest;
import deltabackend.domain.mixerDelta.MixerDeltaResponse;
import deltabackend.domain.sequenceDelta.SingleSequenceDelta;
import deltabackend.domain.test.DeltaTestRequest;
import deltabackend.domain.test.DeltaTestResponse;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessageType;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.client.RestTemplate;
import java.util.*;

public class MixerDDMinDeltaExt extends ParallelDDMinDelta {
    private RestTemplate res_temp = new RestTemplate();
    private SimpMessagingTemplate temp ;
    private String s_Id;
    private String exp = "exception";
    private Map<String, String> conf_ulMap = new HashMap<String, String>();
    private List<SingleDeltaCMResourceRequest> conf_envOrg;
    private List<SingleDeltaCMResourceRequest> conf_ulOrg;
    private Map<String, SingleDeltaCMResourceRequest> conf_dMap = new HashMap<String, SingleDeltaCMResourceRequest>();
    //sequence
    private Stack<String> seqNum = new Stack<String>();
    private Map<String, String> preToSender = new HashMap<String, String>();
    private Map<String, ArrayList<String>> preToReceivers = new HashMap<String, ArrayList<String>>();
    //instance
    private int ins_DN = 2;
    private List<ServiceWithReplicas> ins_envOrg = new ArrayList<ServiceWithReplicas>();
    private Map<String, ServiceWithReplicas> ins_dMap = new HashMap<String, ServiceWithReplicas>();

    public MixerDDMinDeltaExt(List<String> tests, List<SingleSequenceDelta> seqGroups, List<String> instances, List<SingleDeltaCMResourceRequest> configs, String id, SimpMessagingTemplate t, List<String> cs) {
        super();
        conf_ulMap.put("memory", "800Mi");
        conf_ulMap.put("cpu", "500m");
        seqNum.push("D");
        seqNum.push("C");
        seqNum.push("B");
        seqNum.push("A");

        expectError = "fail";
        expectPass = "pass";
        testcases = tests;
        s_Id = id;
        temp = t;
        clusters = cs;
        deltas_all = new ArrayList<String>();

        //instance
        for(String p: instances){
            ServiceWithReplicas q = new ServiceWithReplicas();
            q.setServiceName(p);
            q.setNumOfReplicas(ins_DN);
            ins_dMap.put("instance_" + p, q);
            deltas_all.add("instance_" + p);

            ServiceWithReplicas w = new ServiceWithReplicas();
            w.setServiceName(p);
            w.setNumOfReplicas(1);
            ins_envOrg.add(w);
        }
        //config
        conf_envOrg = configs;
        conf_ulOrg = new ArrayList<SingleDeltaCMResourceRequest>();
        for(SingleDeltaCMResourceRequest s : configs){
            SingleDeltaCMResourceRequest a = new SingleDeltaCMResourceRequest();
            a.setServiceName(s.getServiceName());
            a.setType(s.getType());
            a.setKey(s.getKey());
            a.setValue(conf_ulMap.get(s.getKey()));
            conf_ulOrg.add(a);
        }
        for(SingleDeltaCMResourceRequest p: configs){
            SingleDeltaCMResourceRequest q = new SingleDeltaCMResourceRequest();
            q.setServiceName(p.getServiceName());
            q.setType(p.getType());
            q.setKey(p.getKey());
            q.setValue(p.getValue());
            conf_dMap.put("config_" + q.getServiceName() + ":" + q.getType()+ ":" + q.getKey()+ ":" + q.getValue(), q);
            deltas_all.add("config_" + q.getServiceName() + ":" + q.getType()+ ":" + q.getKey()+ ":" + q.getValue());
        }
        //sequence
        for(SingleSequenceDelta group: seqGroups){
            String s = group.getSender();
            List<String> rs = group.getReceivers();
            String prefix = "seq" + seqNum.pop();
            preToSender.put(prefix, s);
            ArrayList<String> l = new ArrayList<String>();
            //put inside-payment in the first
            for(String a : rs){
                if(a.contains("inside")){
                    l.add(a);
                }
            }
            for(String a : rs){
                if( ! a.contains("inside")){
                    l.add(a);
                }
            }
            System.out.println("------ New List -----" + l);
            preToReceivers.put(prefix, l);

            int size = rs.size();
            for(int i = 0; i < size-1; i++){
                for(int j = i + 1; j < size; j++){
                    deltas_all.add( prefix + "_" + size + "_" + (i+1) +  "_" + (j+1) );
                }
            }
        }
        System.out.print("@@@@@@@@@ deltas_all @@@@@@@@@@@" + deltas_all);
    }

    /////////////////////apply delta //////////////////////////////////////

    public boolean applyDelta(List<String> deltas, String cluster) {
        System.out.println("******** applyDelta deltas ***********" + deltas);
        //instance
        List<ServiceWithReplicas> instanceEnv = new ArrayList<ServiceWithReplicas>();
        for(String s: deltas){
            if(s.contains("instance_")){
                ServiceWithReplicas e = ins_dMap.get(s);
                instanceEnv.add(e);
            }
        }
        for(ServiceWithReplicas swr1: ins_envOrg){
            boolean toAdjust = false;
            for(ServiceWithReplicas swr2: instanceEnv){
                if(swr1.getServiceName().equals(swr2.getServiceName())){
                    toAdjust = true;
                }
            }
            if(toAdjust == false){
                instanceEnv.add(swr1);
            }
        }
        //config
        List<SingleDeltaCMResourceRequest> configEnv = new ArrayList<SingleDeltaCMResourceRequest>();
        for(String s: deltas){
           if(s.contains("config_")){
               SingleDeltaCMResourceRequest e = conf_dMap.get(s);
               configEnv.add(e);
           }
        }
        for(SingleDeltaCMResourceRequest sdcr1: conf_ulOrg ){
            boolean toAdjust = false;
            for(SingleDeltaCMResourceRequest sdcr2: configEnv){
                if(sdcr1.getServiceName().equals(sdcr2.getServiceName()) && sdcr1.getType().equals(sdcr2.getType()) && sdcr1.getKey().equals(sdcr2.getKey()) ){
                    toAdjust = true;
                }
            }
            if(toAdjust == false){
                configEnv.add(sdcr1);
            }
        }
        //delta Configs & Instances simultaneously
        List<SingleDeltaAllRequest> o = toDeltaAllDS(instanceEnv, configEnv);
        if(null != o  && o.size() > 0){
            SimpleResponse sr = sendAllDelta(o, cluster);
            if( ! sr.isStatus()){
                return false;
            }
        }

        //sequence
        List<String> seqDeltas = new ArrayList<String>();
        for(String s: deltas) {
            if (s.contains("seq")) {
                seqDeltas.add(s);
            }
        }
        Map<String, String> seq_deltas = getSeqDeltas(seqDeltas);
        System.out.println();
        System.out.println("!!!!!!!!!! getSeqDeltas !!!!!!!!! " + seq_deltas);
        System.out.println();
        List<String> seqUsed = new ArrayList<String>();
        if( ! seq_deltas.isEmpty()){
            for(String key: seq_deltas.keySet()){
                seqUsed.add(key);
                String sender = preToSender.get(key);
                String[] tmp = seq_deltas.get(key).split("_");
                ArrayList<String> receivers = preToReceivers.get(key);
                ArrayList<String> orders = new ArrayList<>();
                for(int i = 0; i < tmp.length; i++){
                    orders.add(receivers.get(Integer.parseInt(tmp[i]) - 1 ));
                }
                System.out.println();
                System.out.println("22222222 ! seq_deltas.isEmpty() 2222222222222222 " + orders);
                System.out.println();
                SetAsyncRequestSequenceResponse r2 = controlSequence(sender, orders, cluster);
                if( ! r2.isStatus()){
                    return false;
                }
            }
        }
        for(String key: preToSender.keySet()){ //if some seq not cover
            if( ! seqUsed.contains(key)){
                String sender = preToSender.get(key);
                ArrayList<String> receivers = preToReceivers.get(key);
                System.out.println();
                System.out.println("333333333 ! seqUsed.contains(key) 3333333333333333 " + receivers);
                System.out.println();
                SetAsyncRequestSequenceResponse r2 = controlSequence(sender, receivers, cluster);
                if(! r2.isStatus()){
                    return false;
                }
            }
        }
        return true;
    }

    private SetAsyncRequestSequenceResponse controlSequence(String sender, ArrayList<String> receivers, String cluster) {
        SetAsyncRequestSequenceRequestWithSource sar = new SetAsyncRequestSequenceRequestWithSource();
        sar.setSourceName(sender);
        sar.setSvcList(receivers);
        sar.setClusterName(cluster);
        System.out.println("---- controlSequence ----" + receivers);
        SetAsyncRequestSequenceResponse r = res_temp.postForObject(
                "http://api-server:18898/api/setAsyncRequestSequenceWithSrcCombineWithFullSuspend",sar,
                SetAsyncRequestSequenceResponse.class);
        System.out.println("--controlSequence--" + r.isStatus() + ": " + r.getMessage());
        System.out.println();
        return r;
    }

    private List<SingleDeltaAllRequest> toDeltaAllDS( List<ServiceWithReplicas> instances, List<SingleDeltaCMResourceRequest> configs){
        System.out.println("^^^^ toDeltaAllDS instances ^^^^^^ " + instances);
        System.out.println("^^^^ toDeltaAllDS configs ^^^^^^ " + configs);

        List<SingleDeltaAllRequest> newList = new ArrayList<SingleDeltaAllRequest>();
        Set<String> existService = new HashSet<String>();

        for(ServiceWithReplicas sw: instances){
            if(existService.contains(sw.getServiceName())){
                for(SingleDeltaAllRequest sdr: newList){
                    if(sdr.getServiceName().equals(sw.getServiceName())){
                        sdr.setNumOfReplicas(sw.getNumOfReplicas());
                    }
                }
            } else {
                existService.add(sw.getServiceName());
                newList.add(new SingleDeltaAllRequest(sw.getServiceName(), sw.getNumOfReplicas()));
            }
            System.out.println("++++++++++ transformInstance ++++++++++++ " + newList);
        }

        for(SingleDeltaCMResourceRequest l: configs){
            if(existService.contains(l.getServiceName())){
                for(SingleDeltaAllRequest d: newList){
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
                        break;
                    }
                }
            } else {
                existService.add(l.getServiceName());
                SingleDeltaAllRequest newL = new SingleDeltaAllRequest();
                newL.setServiceName(l.getServiceName());
                List<CMConfig> newConfig = new ArrayList<CMConfig>();
                CMConfig cmc = new CMConfig();
                cmc.setType(l.getType());
                cmc.addValues(new CM(l.getKey(), l.getValue()));
                newConfig.add(cmc);
                newL.setConfigs(newConfig);
                newList.add(newL);
            }
            System.out.println("++++++++++ transformConfig ++++++++++++ " + newList);
        }

        System.out.println("++++++++++ transformToDeltaAllDS ++++++++++++ " + newList);
        return newList;
    }

    private SimpleResponse sendAllDelta(List<SingleDeltaAllRequest> d, String cluster){
        DeltaAllRequest dar = new DeltaAllRequest();
        dar.setClusterName(cluster);
        dar.setDeltaRequests(d);
        SimpleResponse sr = res_temp.postForObject(
                "http://api-server:18898/api/deltaAll",dar,
                SimpleResponse.class);
        System.out.println("-- sendAllDelta --" + sr.isStatus() + ": " + sr.getMessage());
        System.out.println();
        return sr;
    }

    private SetAsyncRequestSequenceResponse releaseControl(String sender, ArrayList<String> receivers, String cluster) {
        SetAsyncRequestSequenceRequestWithSource sar = new SetAsyncRequestSequenceRequestWithSource();
        sar.setSourceName(sender);
        sar.setSvcList(receivers);
        sar.setClusterName(cluster);
        System.out.println("------ Recovering ----");
        SetAsyncRequestSequenceResponse r = res_temp.postForObject(
                "http://api-server:18898/api/unsuspendAllRequests",sar,
                SetAsyncRequestSequenceResponse.class);
        System.out.println("----  Recovering  --" + r.isStatus() + ": " + r.getMessage());
        System.out.println();

        return r;
    }

    ///////////////////////////////////Test/////////////////////////////////////////

    public String processAndGetResult(List<String> deltas, List<String> testcases, String cluster) {
        System.out.println("***** processAndGetResult *****   " + deltas);
        System.out.println();
        // execute testcases
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        DeltaTestResponse result = deltaTests(testcases, cluster);

        //response to user
        List<SingleDeltaCMResourceRequest> configEnv = new ArrayList<SingleDeltaCMResourceRequest>();
        List<String> seqDeltas = new ArrayList<String>();
        List<ServiceWithReplicas> instanceEnv = new ArrayList<ServiceWithReplicas>();
        for(String s: deltas){
            if(s.contains("config_")){
                SingleDeltaCMResourceRequest e = conf_dMap.get(s);
                configEnv.add(e);
            } else if(s.contains("seq")){
                seqDeltas.add(s);
            } else if(s.contains("instance_")){
                ServiceWithReplicas e = ins_dMap.get(s);
                instanceEnv.add(e);
            }
        }
        responseToUser(configEnv,transformToServiceNames(seqDeltas, cluster),instanceEnv, result);

        String returnResult = "";
        if(result.getStatus() == 1){
            returnResult = expectPass;
        } else if(result.getStatus() == 0){
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
        DeltaTestResponse result = res_temp.postForObject(
                "http://test-backend:5001/testBackend/deltaTest",dtr,
                DeltaTestResponse.class);
        return result;
    }

    private List<SetAsyncRequestSequenceRequestWithSource> transformToServiceNames(List<String> deltas, String cluster){
        //get full order
        Map<String, String> seq_deltas = getSeqDeltas(deltas);
        //get all the service names
        List<SetAsyncRequestSequenceRequestWithSource> envs = new ArrayList<SetAsyncRequestSequenceRequestWithSource>();
        for(String key: seq_deltas.keySet()){
            SetAsyncRequestSequenceRequestWithSource srsw = new SetAsyncRequestSequenceRequestWithSource();
            String sender = preToSender.get(key);
            srsw.setSourceName(sender);
            String[] tmp = seq_deltas.get(key).split("_");
            ArrayList<String> receivers = preToReceivers.get(key);
            ArrayList<String> rs = new ArrayList<String>();
            for(int i = 0; i < tmp.length; i++){
                rs.add(receivers.get(Integer.parseInt(tmp[i]) - 1 ));
            }
            srsw.setSvcList(rs);
            srsw.setClusterName(cluster);
            envs.add(srsw);
        }
        return envs;
    }

    ///////////////////////////// Get Final Result  ///////////////////////////////////////////
    public Map<String, List<String>> getFinalResult(List<String> ddminResult){
        Map<String, List<String>> m = new HashMap<String, List<String>>();
        List<String> seqResult = new ArrayList<String>();
        List<String> instanceResult = new ArrayList<String>();
        List<String> configResult = new ArrayList<String>();
        for(String s :ddminResult){
            if(s.contains("seq_")){
                seqResult.add(s);
            } else if(s.contains("instance_")){
                instanceResult.add(s.substring(9));
            } else if(s.contains("config_")){
                configResult.add(s.substring(7));
            }
        }
        m.put("sequence", getSequenceFinalResult(seqResult));
        m.put("instance", instanceResult);
        m.put("config", configResult);
        return m;
    }

    private List<String>  getSequenceFinalResult(List<String> ddminResult){
        List<String> r = new ArrayList<String>();
        if(null != ddminResult && ddminResult.size() > 0){
            for(String s : ddminResult){
                String[] tmp = s.split("_");
                String sender = preToSender.get(tmp[0]);
                String a = sender + "-> ";
                ArrayList<String> receivers = preToReceivers.get(tmp[0]);
                for(int i = 2; i < tmp.length; i++){
                    a += receivers.get(Integer.parseInt(tmp[i]) - 1) + " ";
                }
                a += "; ";
                r.add(a);
            }
        }
        return r;
    }

    //////////////////////////////////// send result to user ////////////////////////////////////////////////////
    private void responseToUser(List<SingleDeltaCMResourceRequest> configEnv,
                                List<SetAsyncRequestSequenceRequestWithSource> seqEnv,
                                List<ServiceWithReplicas> instanceEnv, DeltaTestResponse result){
        MixerDeltaResponse mdr = new MixerDeltaResponse();
        if(result.getStatus() == -1){ //the backend throw an exception, stop the delta test, maybe the testcase not exist
            mdr.setStatus(false);
            mdr.setMessage(result.getMessage());
            temp.convertAndSendToUser(s_Id,"/topic/mixerDeltaResponse" ,mdr, createHeaders(s_Id));
        }
        mdr.setStatus(true);//just mean the test case has been executed
        mdr.setConfigEnv(configEnv);
        mdr.setInstanceEnv(instanceEnv);
        mdr.setSeqEnv(seqEnv);
        mdr.setMessage(result.getMessage());
        mdr.setResult(result);
        temp.convertAndSendToUser(s_Id,"/topic/mixerDeltaResponse" ,mdr, createHeaders(s_Id));
    }

    private MessageHeaders createHeaders(String s_Id) {
        SimpMessageHeaderAccessor headerAccessor = SimpMessageHeaderAccessor.create(SimpMessageType.MESSAGE);
        headerAccessor.setSessionId(s_Id);
        headerAccessor.setLeaveMutable(true);
        return headerAccessor.getMessageHeaders();
    }

    ////////////////////////// Recover ////////////////////////////////////
    public boolean recoverEnv(){
//        boolean a = recoverConfigEnv();
        boolean b = recoverSequenceEnv();
//        boolean c = recoverInstanceEnv();
        boolean d = recoverInstancesAndConfigs();
        if(b && d){
            return true;
        } else {
            return false;
        }
    }

    private boolean recoverInstancesAndConfigs(){
        for(String s : clusters){
            SimpleResponse r1 = sendAllDelta(toDeltaAllDS(ins_envOrg, conf_envOrg), s);
            if(! r1.isStatus()){
                return false;
            }
        }
        return true;
    }

    private boolean recoverSequenceEnv(){
        for(String c: clusters){
            for(String key: preToSender.keySet()){
                String sender = preToSender.get(key);
                ArrayList<String> receivers = preToReceivers.get(key);
                SetAsyncRequestSequenceResponse r1 = releaseControl(sender, receivers, c);
                if(! r1.isStatus()){
                    return false;
                }
            }
        }
        return true;
    }
}
