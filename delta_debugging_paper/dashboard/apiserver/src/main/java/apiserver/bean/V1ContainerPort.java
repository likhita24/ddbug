package apiserver.bean;

public class V1ContainerPort {
    private Integer CPT = null;
    private String HIP = null;
    private Integer HOP = null;
    private String n = null;
    private String PTL = null;

    public V1ContainerPort(){

    }

    public Integer getContainerPort() {
        return CPT;
    }

    public void setContainerPort(Integer CPT) {
        this.CPT = CPT;
    }

    public String getHostIP() {
        return HIP;
    }

    public void setHostIP(String HIP) {
        this.HIP = HIP;
    }

    public Integer getHostPort() {
        return HOP;
    }

    public void setHostPort(Integer HOP) {
        this.HOP = HOP;
    }

    public String getName() {
        return n;
    }

    public void setName(String n) {
        this.n = n;
    }

    public String getProtocol() {
        return PTL;
    }

    public void setProtocol(String PTL) {
        this.PTL = PTL;
    }
}
