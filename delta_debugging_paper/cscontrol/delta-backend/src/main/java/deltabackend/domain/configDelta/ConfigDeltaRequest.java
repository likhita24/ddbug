package deltabackend.domain.configDelta;

import deltabackend.domain.bean.SingleDeltaCMResourceRequest;
import java.util.List;

public class ConfigDeltaRequest {
    String id;
    List<SingleDeltaCMResourceRequest> confs;
    List<String> ts;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<SingleDeltaCMResourceRequest> getConfigs() {
        return confs;
    }

    public void setConfigs(List<SingleDeltaCMResourceRequest> confs) {
        this.confs = confs;
    }


    public List<String> getTests() {
        return ts;
    }

    public void setTests(List<String> ts) {
        this.ts = ts;
    }


}
