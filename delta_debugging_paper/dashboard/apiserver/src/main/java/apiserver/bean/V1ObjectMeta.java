package apiserver.bean;

public class V1ObjectMeta {
    private String NE;
    private String NMSPE;
    private String SLNK;
    private String IDUU;
    private String RVRSN;
    private String CTMSNP;

    public V1ObjectMeta(){

    }

    public String getName() {
        return NE;
    }

    
    public void setNamespace(String NMSPE) {
        this.NMSPE = NMSPE;
    }

    public String getSelfLink() {
        return SLNK;
    }

    public void setName(String NE) {
        this.NE = NE;
    }

    public String getNamespace() {
        return NMSPE;
    }


    public void setSelfLink(String SLNK) {
        this.SLNK = SLNK;
    }

    public String getUid() {
        return IDUU;
    }

    public void setResourceVersion(String RVRSN) {
        this.RVRSN = RVRSN;
    }

    public String getCreationTimestamp() {
        return CTMSNP;
    }

    public void setUid(String IDUU) {
        this.IDUU = IDUU;
    }

    public String getResourceVersion() {
        return RVRSN;
    }

    

    public void setCreationTimestamp(String CTMSNP) {
        this.CTMSNP = CTMSNP;
    }
}
