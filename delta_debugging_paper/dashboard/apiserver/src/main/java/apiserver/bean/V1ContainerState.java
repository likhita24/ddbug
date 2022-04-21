package apiserver.bean;

public class V1ContainerState {
    private V1ContainerStateRunning RUNG = null;
    private V1ContainerStateTerminated TMD = null;
    private V1ContainerStateWaiting WTG = null;

    public V1ContainerState(){

    }

    public V1ContainerStateRunning getRunning() {
        return RUNG;
    }

    public void setRunning(V1ContainerStateRunning RUNG) {
        this.RUNG = RUNG;
    }

    public V1ContainerStateTerminated getTerminated() {
        return TMD;
    }

    public void setTerminated(V1ContainerStateTerminated TMD) {
        this.TMD = TMD;
    }

    public V1ContainerStateWaiting getWaiting() {
        return WTG;
    }

    public void setWaiting(V1ContainerStateWaiting WTG) {
        this.WTG = WTG;
    }
}
