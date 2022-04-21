package apiserver.bean;

public class NodeInfo {
    private String r;
    private String n;
    private String IP_ADDR;
    private String STS;
    private String KPV = null;
    private String KV = null;
    private String OS = null;
    private String OIMG = null;
    private String CRV = null;

    public NodeInfo(){

    }

    public String getRole() {
        return r;
    }

    public String getName() {
        return n;
    }

    public void setName(String n) {
        this.n = n;
    }

    public void setRole(String r) {
        this.r = r;
    }

    public String getIp() {
        return IP_ADDR;
    }

    public void setIp(String IP_ADDR) {
        this.IP_ADDR = IP_ADDR;
    }

    public String getStatus() {
        return STS;
    }

    public void setStatus(String STS) {
        this.STS = STS;
    }

    public String getKubeProxyVersion() {
        return KPV;
    }

    public void setKubeProxyVersion(String KPV) {
        this.KPV = KPV;
    }

    public String getKubeletVersion() {
        return KV;
    }

    public void setKubeletVersion(String KV) {
        this.KV = KV;
    }

    public String getOperatingSystem() {
        return OS;
    }

    public void setOperatingSystem(String OS) {
        this.OS = OS;
    }

    public String getOsImage() {
        return OIMG;
    }

    public void setOsImage(String OIMG) {
        this.OIMG = OIMG;
    }

    public String getContainerRuntimeVersion() {
        return CRV;
    }

    public void setContainerRuntimeVersion(String CRV) {
        this.CRV = CRV;
    }
}
