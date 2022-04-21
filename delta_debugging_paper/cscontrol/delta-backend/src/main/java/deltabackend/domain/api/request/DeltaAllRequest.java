package deltabackend.domain.api.request;

import java.util.List;

public class DeltaAllRequest {
    private String Clus_name;
    private List<SingleDeltaAllRequest> deltaRequests;
    public DeltaAllRequest(){

    }

    public String getClus_name() {
        return Clus_name;
    }

    public void setClus_name(String Clus_name) {
        this.Clus_name = Clus_name;
    }

    public List<SingleDeltaAllRequest> getDeltaRequests() {
        return deltaRequests;
    }

    public void setDeltaRequests(List<SingleDeltaAllRequest> deltaRequests) {
        this.deltaRequests = deltaRequests;
    }
}
