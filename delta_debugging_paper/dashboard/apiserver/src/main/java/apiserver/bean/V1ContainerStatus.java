package apiserver.bean;

public class V1ContainerStatus {
    private String n = null;
    private Boolean RDY = null;
    private Integer RSTCNT = null;
    private String IM = null;
    private String IGD = null;
    private String CNID = null;
    private V1ContainerState STS = null;
    private V1ContainerState LSTS = null;

    public V1ContainerStatus(){

    }

    public String getName() {
        return n;
    }

    public void setName(String n) {
        this.n = n;
    }

    public Boolean getReady() {
        return RDY;
    }

    public void setReady(Boolean RDY) {
        this.RDY = RDY;
    }

    public Integer getRestartCount() {
        return RSTCNT;
    }

    public void setRestartCount(Integer RSTCNT) {
        this.RSTCNT = RSTCNT;
    }

    public String getImage() {
        return IM;
    }

    public void setImage(String IM) {
        this.IM = IM;
    }

    public String getImageID() {
        return IGD;
    }

    public void setImageID(String IGD) {
        this.IGD = IGD;
    }

    public String getContainerID() {
        return CNID;
    }

    public void setContainerID(String CNID) {
        this.CNID = CNID;
    }

    public V1ContainerState getState() {
        return STS;
    }

    public void setState(V1ContainerState STS) {
        this.STS = STS;
    }

    public V1ContainerState getLastState() {
        return LSTS;
    }

    public void setLastState(V1ContainerState LSTS) {
        this.LSTS = LSTS;
    }
}
