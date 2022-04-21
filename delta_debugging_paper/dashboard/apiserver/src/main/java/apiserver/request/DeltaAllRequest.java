package apiserver.request;

import apiserver.bean.NewSingleDeltaCMResourceRequest;
import apiserver.bean.SingleDeltaAllRequest;

import java.util.List;

public class DeltaAllRequest {
    private String c_name;
    private List<SingleDeltaAllRequest> DRTS;

    public DeltaAllRequest(){

    }

    public String getClusterName() {
        return c_name;
    }

    public void setClusterName(String c_name) {
        this.c_name = c_name;
    }

    public List<SingleDeltaAllRequest> getDeltaRequests() {
        return DRTS;
    }

    public void setDeltaRequests(List<SingleDeltaAllRequest> DRTS) {
        this.DRTS = DRTS;
    }
}
