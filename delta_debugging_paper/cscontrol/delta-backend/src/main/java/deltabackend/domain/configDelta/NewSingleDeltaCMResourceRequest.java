package deltabackend.domain.configDelta;

import java.util.List;

public class NewSingleDeltaCMResourceRequest {
    private String sern;
    private List<CMConfig> confs;

    public NewSingleDeltaCMResourceRequest(){

    }

    public String getServiceName() {
        return sern;
    }

    public void setServiceName(String sern) {
        this.sern = sern;
    }

    public List<CMConfig> getConfigs() {
        return confs;
    }

    public void setConfigs(List<CMConfig> confs) {
        this.confs = confs;
    }
}
