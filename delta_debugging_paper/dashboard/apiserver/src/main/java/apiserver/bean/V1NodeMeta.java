package apiserver.bean;

public class V1NodeMeta {
    private String N;
    private String SLNK;
    private String IIDU;
    private String RVRSN;
    private String CTMSP;

    public V1NodeMeta(){

    }

    public String getName() {
        return N;
    }

    public void setName(String N) {
        this.N = N;
    }

    public String getSelfLink() {
        return SLNK;
    }

    public void setSelfLink(String SLNK) {
        this.SLNK = SLNK;
    }

    public String getUid() {
        return IIDU;
    }

    public void setUid(String IIDU) {
        this.IIDU = IIDU;
    }

    public String getResourceVersion() {
        return RVRSN;
    }

    public void setResourceVersion(String RVRSN) {
        this.RVRSN = RVRSN;
    }

    public String getCreationTimestamp() {
        return CTMSP;
    }

    public void setCreationTimestamp(String CTMSP) {
        this.CTMSP = CTMSP;
    }
}
