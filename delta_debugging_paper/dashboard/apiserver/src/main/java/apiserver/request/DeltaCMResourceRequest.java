package apiserver.request;

import apiserver.bean.NewSingleDeltaCMResourceRequest;

import java.util.List;

public class DeltaCMResourceRequest {
    private String C_NAME;
    private List<NewSingleDeltaCMResourceRequest> DRTS;

    public DeltaCMResourceRequest(){

    }

    public String getClusterName() {
        return C_NAME;
    }

    public void setClusterName(String C_NAME) {
        this.C_NAME = C_NAME;
    }

    public List<NewSingleDeltaCMResourceRequest> getDeltaRequests() {
        return DRTS;
    }

    public void setDeltaRequests(List<NewSingleDeltaCMResourceRequest> DRTS) {
        this.DRTS = DRTS;
    }
}
