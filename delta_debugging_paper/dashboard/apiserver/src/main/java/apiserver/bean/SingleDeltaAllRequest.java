package apiserver.bean;

import java.util.List;

public class SingleDeltaAllRequest {
    private String svn;
    private List<CMConfig> cfgs;
    private int nor;

    public SingleDeltaAllRequest(){

    }

    public String getServiceName() {
        return svn;
    }

    public void setServiceName(String svn) {
        this.svn = svn;
    }

    public List<CMConfig> getConfigs() {
        return cfgs;
    }

    public void setConfigs(List<CMConfig> cfgs) {
        this.cfgs = cfgs;
    }

    public int getNumOfReplicas() {
        return nor;
    }

    public void setNumOfReplicas(int nor) {
        this.nor = nor;
    }
}
