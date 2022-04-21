package apiserver.bean;

public class V1NodeSystemInfo {
    private String ARCRE = null;
    private String BID = null;
    private String CVRSN = null;
    private String KVRSN = null;
    private String KPVRSN = null;
    private String KUBVRSN = null;
    private String MID = null;
    private String OS = null;
    private String OSIMG = null;
    private String SUUID = null;

    public V1NodeSystemInfo(){

    }

    public String getArchitecture() {
        return ARCRE;
    }

    

    public void setBootID(String BID) {
        this.BID = BID;
    }

    public String getContainerRuntimeVersion() {
        return CVRSN;
    }

    public void setArchitecture(String ARCRE) {
        this.ARCRE = ARCRE;
    }

    public String getBootID() {
        return BID;
    }

    public void setContainerRuntimeVersion(String CVRSN) {
        this.CVRSN = CVRSN;
    }

    public String getKernelVersion() {
        return KVRSN;
    }

    public void setKernelVersion(String KVRSN) {
        this.KVRSN = KVRSN;
    }

    public String getKubeProxyVersion() {
        return KPVRSN;
    }

    public String getMachineID() {
        return MID;
    }

    public void setMachineID(String MID) {
        this.MID = MID;
    }

    public void setKubeProxyVersion(String KPVRSN) {
        this.KPVRSN = KPVRSN;
    }

    public String getKubeletVersion() {
        return KUBVRSN;
    }

    public void setKubeletVersion(String KUBVRSN) {
        this.KUBVRSN = KUBVRSN;
    }

    

    public String getOperatingSystem() {
        return OS;
    }

    public String getSystemUUID() {
        return SUUID;
    }

    public void setSystemUUID(String SUUID) {
        this.SUUID = SUUID;
    }

    public void setOperatingSystem(String OS) {
        this.OS = OS;
    }

    public String getOsImage() {
        return OSIMG;
    }

    public void setOsImage(String OSIMG) {
        this.OSIMG = OSIMG;
    }

    
}
