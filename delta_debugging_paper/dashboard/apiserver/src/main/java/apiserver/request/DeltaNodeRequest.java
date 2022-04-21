package apiserver.request;

import java.util.List;

public class DeltaNodeRequest {
    private String C_NE;
    private List<String> NNES;

    public  DeltaNodeRequest(){

    }

    public String getClusterName() {
        return C_NE;
    }

    public void setClusterName(String C_NE) {
        this.C_NE = C_NE;
    }

    public List<String> getNodeNames() {
        return NNES;
    }

    public void setNodeNames(List<String> NNES) {
        this.NNES = NNES;
    }
}
