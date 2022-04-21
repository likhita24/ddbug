package apiserver.bean;

import java.util.List;

public class V1PodStatus {
    private String PS = null;
    private String HIP = null;
    private String PIP = null;
    private String STME = null;
    private List<V1ContainerStatus> CSTS = null;

    public V1PodStatus(){

    }

    public String getPhase() {
        return PS;
    }

    public void setPhase(String PS) {
        this.PS = PS;
    }

    public String getHostIP() {
        return HIP;
    }

    public void setHostIP(String HIP) {
        this.HIP = HIP;
    }

    public String getPodIP() {
        return PIP;
    }

    public void setPodIP(String PIP) {
        this.PIP = PIP;
    }

    public String getStartTime() {
        return STME;
    }

    public void setStartTime(String STME) {
        this.STME = STME;
    }

    public List<V1ContainerStatus> getContainerStatuses() {
        return CSTS;
    }

    public void setContainerStatuses(List<V1ContainerStatus> CSTS) {
        this.CSTS = CSTS;
    }
}
