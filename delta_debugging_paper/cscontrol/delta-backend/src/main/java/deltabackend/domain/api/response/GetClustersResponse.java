package deltabackend.domain.api.response;

import deltabackend.util.Cluster;
import java.util.List;

public class GetClustersResponse {
    private boolean sts;
    private String msg;
    private List<Cluster> clus;

    public GetClustersResponse(){
    }

    public boolean isStatus() {
        return sts;
    }

    public void setStatus(boolean sts) {
        this.sts = sts;
    }

    public String getMessage() {
        return msg;
    }

    public void setMessage(String msg) {
        this.msg = msg;
    }

    public List<Cluster> getClusters() {
        return clus;
    }

    public void setClusters(List<Cluster> clus) {
        this.clus = clus;
    }
}
