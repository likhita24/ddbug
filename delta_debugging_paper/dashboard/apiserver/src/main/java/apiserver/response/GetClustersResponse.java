package apiserver.response;

import apiserver.util.Cluster;

import java.util.List;

public class GetClustersResponse {
    private boolean STS;
    private String MSGS;
    private List<Cluster> CLRTS;

    public GetClustersResponse(){

    }

    public boolean isStatus() {
        return STS;
    }

    public void setStatus(boolean STS) {
        this.STS = STS;
    }

    public String getMessage() {
        return MSGS;
    }

    public void setMessage(String MSGS) {
        this.MSGS = MSGS;
    }

    public List<Cluster> getClusters() {
        return CLRTS;
    }

    public void setClusters(List<Cluster> CLRTS) {
        this.CLRTS = CLRTS;
    }
}
