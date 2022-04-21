package deltabackend.domain.api.request;

import deltabackend.domain.configDelta.CMConfig;
import java.util.ArrayList;
import java.util.List;

public class SingleDeltaAllRequest {
    private String sern;
    private List<CMConfig> configs = new ArrayList<CMConfig>();
    private int numR;

    public SingleDeltaAllRequest(){

    }

    public SingleDeltaAllRequest(String sn, int num){
        this.sern = sn;
        this.numR = num;
    }

    public String getServiceName() {
        return sern;
    }

    public void setServiceName(String sern) {
        this.sern = sern;
    }

    public List<CMConfig> getConfigs() {
        return configs;
    }

    public void setConfigs(List<CMConfig> configs) {
        this.configs = configs;
    }

    public int getNumOfReplicas() {
        return numR;
    }

    public void setNumOfReplicas(int numR) {
        this.numR = numR;
    }

    public String toString(){
        return this.sern + ": { numR: " + this.numR + ", configs: " + this.configs.toString() + " }";
    }
}
