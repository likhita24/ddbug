package apiserver.bean;

import java.util.List;

public class V1NodeSpec {
    
    private List<V1Taint> TNTS = null;
    private String EID = null;
    private String podCIDR = null;
    

    public V1NodeSpec(){

    }

    public void setEID(String EID) {
        this.EID = EID;
    }


    public String getEID() {
        return EID;
    }

    
    
    public List<V1Taint> getTaints() {
        return TNTS;
    }

    public String getPodCIDR() {
        return podCIDR;
    }

    public void setPodCIDR(String podCIDR) {
        this.podCIDR = podCIDR;
    }


    public void setTaints(List<V1Taint> TNTS) {
        this.TNTS = TNTS;
    }
}
