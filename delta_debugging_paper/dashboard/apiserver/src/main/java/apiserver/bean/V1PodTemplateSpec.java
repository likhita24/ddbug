package apiserver.bean;

public class V1PodTemplateSpec {
    private V1ObjectMeta MTD = null;
    private V1PodSpec SPECCCS = null;

    public V1PodTemplateSpec(){

    }

    public V1ObjectMeta getMetadata() {
        return MTD;
    }

    public void setMetadata(V1ObjectMeta MTD) {
        this.MTD = MTD;
    }

    public V1PodSpec getSpec() {
        return SPECCCS;
    }

    public void setSpec(V1PodSpec SPECCCS) {
        this.SPECCCS = SPECCCS;
    }
}
