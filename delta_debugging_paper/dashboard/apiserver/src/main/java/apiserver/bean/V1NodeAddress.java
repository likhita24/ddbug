package apiserver.bean;

public class V1NodeAddress {
    private String ADRS = null;
    private String TP = null;

    public V1NodeAddress(){

    }

    public String getAddress() {
        return ADRS;
    }

    public void setAddress(String ADRS) {
        this.ADRS = ADRS;
    }

    public String getType() {
        return TP;
    }

    public void setType(String TP) {
        this.TP = TP;
    }
}
