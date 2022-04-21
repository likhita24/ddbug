package apiserver.bean;

public class SingleDeploymentStatus {
    private int obsG;
    private int RPS;
    private int UPRS;
    private int RRS;
    private int ARS;

    public SingleDeploymentStatus(){

    }

    public int getObservedGeneration() {
        return obsG;
    }

    public void setObservedGeneration(int obsG) {
        this.obsG = obsG;
    }

    public int getReplicas() {
        return RPS;
    }

    public void setReplicas(int RPS) {
        this.RPS = RPS;
    }

    public int getUpdatedReplicas() {
        return UPRS;
    }

    public void setUpdatedReplicas(int UPRS) {
        this.UPRS = UPRS;
    }

    public int getReadyReplicas() {
        return RRS;
    }

    public void setReadyReplicas(int RRS) {
        this.RRS = RRS;
    }

    public int getAvailableReplicas() {
        return ARS;
    }

    public void setAvailableReplicas(int ARS) {
        this.ARS = ARS;
    }
}
