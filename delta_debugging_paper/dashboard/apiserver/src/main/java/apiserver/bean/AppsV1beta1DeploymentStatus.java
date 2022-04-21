package apiserver.bean;

public class AppsV1beta1DeploymentStatus {
    private String copies;
    private Selector choose;
    private String chsr;

    public AppsV1beta1DeploymentStatus(){

    }

    public String getReplicas() {
        return copies;
    }

    public void setReplicas(String copies) {
        this.copies = copies;
    }

    public Selector getSelector() {
        return choose;
    }

    public void setSelector(Selector choose) {
        this.choose = choose;
    }

    public String getTargetSelector() {
        return chsr;
    }

    public void setTargetSelector(String chsr) {
        this.chsr = chsr;
    }
}
