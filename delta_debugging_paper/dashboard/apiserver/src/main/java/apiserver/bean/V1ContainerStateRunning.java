package apiserver.bean;

public class V1ContainerStateRunning {
    private String STAT = null;

    public V1ContainerStateRunning(){

    }

    public String getStartedAt() {
        return STAT;
    }

    public void setStartedAt(String STAT) {
        this.STAT = STAT;
    }
}
