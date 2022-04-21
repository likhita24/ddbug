package deltabackend.domain.nodeDelta;

import java.util.List;

public class NodeDeltaRequest {
    String id;
    List<String> nName;
    String clus = null;

    public String getCluster() {
        return clus;
    }

    public void setCluster(String clus) {
        this.clus = clus;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getNodeNames() {
        return nName;
    }

    public void setNodeNames(List<String> nName) {
        this.nName = nName;
    }

}
