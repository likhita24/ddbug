package deltabackend.domain.bean;

public class ServiceWithReplicas {
    private String sern;
    private int numR;

    public ServiceWithReplicas(){
    }

    public String getServiceName() {
        return sern;
    }

    public void setServiceName(String sern) {
        this.sern = sern;
    }

    public int getNumOfReplicas() {
        return numR;
    }

    public void setNumOfReplicas(int numR) {
        this.numR = numR;
    }

    public String toString(){
        return this.sern + ": " + this.numR;
    }
}
