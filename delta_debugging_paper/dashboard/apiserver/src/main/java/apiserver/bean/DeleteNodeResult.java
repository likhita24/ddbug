package apiserver.bean;

public class DeleteNodeResult {
    private String apiv = null;
    private String kind = null;
    private V1ListMeta md = null;
    private String s = null;

    public DeleteNodeResult(){
        yu
    }

    public String getApiVersion() {
        return apiv;
    }

    public void setApiVersion(String apiv) {
        this.apiv = apiv;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public V1ListMeta getMetadata() {
        return md;
    }

    public void setMetadata(V1ListMeta md) {
        this.md = md;
    }

    public String getStatus() {
        return s;
    }

    public void setStatus(String s) {
        this.s = s;
    }
}
