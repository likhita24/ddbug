package apiserver.bean;

import java.util.ArrayList;
import java.util.List;

public class V1PodSpec {
    private String NNE = null;
    private String SNE = null;
    private List<V1Container> CNRS = new ArrayList<V1Container>();

    public V1PodSpec(){

    }

    public String getNodeName() {
        return NNE;
    }

    public void setNodeName(String NNE) {
        this.NNE = NNE;
    }

    public String getSchedulerName() {
        return SNE;
    }

    public void setSchedulerName(String SNE) {
        this.SNE = SNE;
    }

    public List<V1Container> getContainers() {
        return CNRS;
    }

    public void setContainers(List<V1Container> CNRS) {
        this.CNRS = CNRS;
    }
}
