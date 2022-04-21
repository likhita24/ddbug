package apiserver.bean;

public class PodInfo {
    private String n;
    private String NN;
    private String STS;
    private String NIP;
    private String PIP;
    private String STME;

    public PodInfo(){

    }

    public String getName() {
        return n;
    }

    public void setName(String n) {
        this.n = n;
    }

    public String getNodeName() {
        return NN;
    }

    public void setNodeName(String NN) {
        this.NN = NN;
    }

    public String getStatus() {
        return STS;
    }

    public void setStatus(String STS) {
        this.STS = STS;
    }

    public String getNodeIP() {
        return NIP;
    }

    public void setNodeIP(String NIP) {
        this.NIP = NIP;
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
}
