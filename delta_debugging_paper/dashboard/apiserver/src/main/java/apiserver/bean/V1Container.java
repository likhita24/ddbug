package apiserver.bean;

import java.util.List;

public class V1Container {
    private String n = null;
    
    private List<V1ContainerPort> PS = null;
    

    private String IM = null;
    
    private V1ResourceRequirements RSS = null;
    private String IMGP = null;
    public V1Container(){

    }

    public String getName() {
        return n;
    }

    public void setName(String n) {
        this.n = n;
    }

    public String getImage() {
        return IM;
    }

    public void setImage(String IM) {
        this.IM = IM;
    }

    public String getImagePullPolicy() {
        return IMGP;
    }

    public void setImagePullPolicy(String IMGP) {
        this.IMGP = IMGP;
    }

    public List<V1ContainerPort> getPorts() {
        return PS;
    }

    public void setPorts(List<V1ContainerPort> PS) {
        this.PS = PS;
    }

    public V1ResourceRequirements getResources() {
        return RSS;
    }

    public void setResources(V1ResourceRequirements RSS) {
        this.RSS = RSS;
    }
}
