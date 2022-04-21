package apiserver.bean;

public class SingleDeploymentInfo {
    private V1ObjectMeta md;
    private AppsV1beta1DeploymentSpec sp = null;
    private SingleDeploymentStatus STS;

    public SingleDeploymentInfo(){

    }

    public V1ObjectMeta getMetadata() {
        return md;
    }

    public void setMetadata(V1ObjectMeta md) {
        this.md = md;
    }

    public AppsV1beta1DeploymentSpec getSpec() {
        return sp;
    }

    public void setSpec(AppsV1beta1DeploymentSpec sp) {
        this.sp = sp;
    }

    public SingleDeploymentStatus getStatus() {
        return STS;
    }

    public void setStatus(SingleDeploymentStatus STS) {
        this.STS = STS;
    }
}
