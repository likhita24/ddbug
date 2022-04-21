package apiserver.bean;

public class V1EndpointPort {
    private String NE = null;
    private Integer PT = null;
    private String PTL = null;

    public V1EndpointPort(){

    }

    public String getName() {
        return NE;
    }

    public void setName(String NE) {
        this.NE = NE;
    }

    public Integer getPort() {
        return PT;
    }

    public void setPort(Integer PT) {
        this.PT = PT;
    }

    public String getProtocol() {
        return PTL;
    }

    public void setProtocol(String PTL) {
        this.PTL = PTL;
    }
}
