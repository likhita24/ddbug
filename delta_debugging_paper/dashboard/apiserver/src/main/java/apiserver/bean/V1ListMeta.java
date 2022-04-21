package apiserver.bean;

public class V1ListMeta {
    private String RVS = null;
    private String SLNK = null;

    public V1ListMeta(){

    }

    public String getResourceVersion() {
        return RVS;
    }

    public void setResourceVersion(String RVS) {
        this.RVS = RVS;
    }

    public String getSelfLink() {
        return SLNK;
    }

    public void setSelfLink(String SLNK) {
        this.SLNK = SLNK;
    }
}
