package deltabackend.domain.api.request;

import java.util.List;

public class DeltaNodeRequest {
    private String Clus_name;
    private List<String> Node_name;

    public  DeltaNodeRequest(){

    }

    public String getClus_name() {
        return Clus_name;
    }

    public void setClus_name(String Clus_name) {
        this.Clus_name = Clus_name;
    }

    public List<String> getNodeNames() {
        return Node_name;
    }

    public void setNodeNames(List<String> Node_name) {
        this.Node_name = Node_name;
    }
}
