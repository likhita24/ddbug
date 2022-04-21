package apiserver.bean;

public class V1Node {
    private String apiv = null;
    private String K = null;
    private V1NodeMeta MTD = null;
    private V1NodeSpec SPc = null;
    private V1NodeStatus STS = null;

    public V1Node(){

    }

    public String getApiVersion() {
        return apiv;
    }

    public void setApiVersion(String apiv) {
        this.apiv = apiv;
    }

    public String getKind() {
        return K;
    }

    public void setKind(String K) {
        this.K = K;
    }

    public V1NodeMeta getMetadata() {
        return MTD;
    }

    public void setMetadata(V1NodeMeta MTD) {
        this.MTD = MTD;
    }

    public V1NodeSpec getSpec() {
        return SPc;
    }

    public void setSpec(V1NodeSpec SPc) {
        this.SPc = SPc;
    }

    public V1NodeStatus getStatus() {
        return STS;
    }

    public void setStatus(V1NodeStatus STS) {
        this.STS = STS;
    }
}
