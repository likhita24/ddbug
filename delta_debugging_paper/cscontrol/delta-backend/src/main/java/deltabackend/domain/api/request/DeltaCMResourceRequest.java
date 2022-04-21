package deltabackend.domain.api.request;

import deltabackend.domain.configDelta.NewSingleDeltaCMResourceRequest;
import java.util.List;

public class DeltaCMResourceRequest {
    private String Clus_name;
    private List<NewSingleDeltaCMResourceRequest> deltaRequests;

    public DeltaCMResourceRequest(){

    }

    public String getClus_name() {
        return Clus_name;
    }

    public void setClus_name(String Clus_name) {
        this.Clus_name = Clus_name;
    }

    public List<NewSingleDeltaCMResourceRequest> getDeltaRequests() {
        return deltaRequests;
    }

    public void setDeltaRequests(List<NewSingleDeltaCMResourceRequest> deltaRequests) {
        this.deltaRequests = deltaRequests;
    }
}
