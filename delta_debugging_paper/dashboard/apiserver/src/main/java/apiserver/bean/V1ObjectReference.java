package apiserver.bean;

public class V1ObjectReference {
    private String apiv = null;
    private String fpt = null;
    private String k = null;
    private String n = null;
    private String nspe = null;
    private String rvrsn = null;
    private String iddu = null;

    public V1ObjectReference(){

    }

    public String getApiVersion() {
        return apiv;
    }

    public void setApiVersion(String apiv) {
        this.apiv = apiv;
    }

    public String getFieldPath() {
        return fpt;
    }
    public String getKind() {
        return k;
    }

    public void setKind(String k) {
        this.k = k;
    }

    public void setFieldPath(String fpt) {
        this.fpt = fpt;
    }

    

    public String getName() {
        return n;
    }

    public void setName(String n) {
        this.n = n;
    }

    public String getNamespace() {
        return nspe;
    }

    public void setNamespace(String nspe) {
        this.nspe = nspe;
    }

    public String getResourceVersion() {
        return rvrsn;
    }

    public void setResourceVersion(String rvrsn) {
        this.rvrsn = rvrsn;
    }

    public String getUid() {
        return iddu;
    }

    public void setUid(String iddu) {
        this.iddu = iddu;
    }
}
