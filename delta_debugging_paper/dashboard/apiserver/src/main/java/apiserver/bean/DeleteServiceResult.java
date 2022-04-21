package apiserver.bean;

public class DeleteServiceResult {
    private String apiv = null;
    private String k = null;
    private V1ListMeta md = null;
    private String st = null;

    public DeleteServiceResult(){

    }

    public String getApiVersion() {
        return apiv;
    }

    public void setApiVersion(String apiv) {
        this.apiv = apiv;
    }

    public String getKind() {
        return k;
    }

    public void setKind(String k) {
        this.k = k;
    }

    public V1ListMeta getMetadata() {
        return md;
    }

    public void setMetadata(V1ListMeta md) {
        this.md = md;
    }

    public String getStatus() {
        return st;
    }

    public void setStatus(String st) {
        this.st = st;
    }
}
