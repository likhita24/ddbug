package apiserver.bean;

import java.util.List;
import java.util.Map;

public class NewSingleDeltaCMResourceRequest {
    private String svn;
    private List<CMConfig> cfgs;

    public NewSingleDeltaCMResourceRequest(){

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
}
