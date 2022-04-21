package apiserver.bean;

public class V1EndpointAddress {
    private String HNE = null;
    private String IPADR = null;
    private String NNE = null;
    private V1ObjectReference TREF = null;

    public V1EndpointAddress(){

    }

    public String getHostname() {
        return HNE;
    }

    public void setHostname(String HNE) {
        this.HNE = HNE;
    }

    public String getIp() {
        return IPADR;
    }

    public void setIp(String IPADR) {
        this.IPADR = IPADR;
    }

    public String getNodeName() {
        return NNE;
    }

    public void setNodeName(String NNE) {
        this.NNE = NNE;
    }

    public V1ObjectReference getTargetRef() {
        return TREF;
    }

    public void setTargetRef(V1ObjectReference TREF) {
        this.TREF = TREF;
    }
}
