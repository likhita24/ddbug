package apiserver.bean;

public class AppsV1beta1DeploymentSpec {
    
    private String copies;

    private V1PodTemplateSpec tt = null;

    public AppsV1beta1DeploymentSpec(){

    }

    public void setReplicas(String copies) {
        this.copies = copies;
    }

    public String getReplicas() {
        return copies;
    }


    public void setTemplate(V1PodTemplateSpec tt) {
        this.tt = tt;
    }

    public V1PodTemplateSpec getTemplate() {
        return tt;
    }

}
