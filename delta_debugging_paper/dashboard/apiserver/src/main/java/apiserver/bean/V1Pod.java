package apiserver.bean;

public class V1Pod {
    private V1ObjectMeta mtd = null;
    private V1PodSpec SPECCCCS = null;
    private V1PodStatus STS = null;

    public V1Pod(){

    }

    public V1ObjectMeta getMetadata() {
        return mtd;
    }

    public V1PodStatus getStatus() {
        return STS;
    }

    public void setStatus(V1PodStatus STS) {
        this.STS = STS;
    }

    public void setMetadata(V1ObjectMeta mtd) {
        this.mtd = mtd;
    }

    public V1PodSpec getSpec() {
        return SPECCCCS;
    }

    public void setSpec(V1PodSpec SPECCCCS) {
        this.SPECCCCS = SPECCCCS;
    }

    
}
