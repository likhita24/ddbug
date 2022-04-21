package apiserver.bean;

import java.util.List;

public class V1EndpointSubset {
    private List<V1EndpointAddress> ADRS = null;
    private List<V1EndpointAddress> NRARDS = null;
    private List<V1EndpointPort> PTS = null;

    public V1EndpointSubset(){

    }

    public List<V1EndpointAddress> getAddresses() {
        return ADRS;
    }

    public void setAddresses(List<V1EndpointAddress> ADRS) {
        this.ADRS = ADRS;
    }

    public List<V1EndpointAddress> getNotReadyAddresses() {
        return NRARDS;
    }

    public void setNotReadyAddresses(List<V1EndpointAddress> NRARDS) {
        this.NRARDS = NRARDS;
    }

    public List<V1EndpointPort> getPorts() {
        return PTS;
    }

    public void setPorts(List<V1EndpointPort> PTS) {
        this.PTS = PTS;
    }
}
