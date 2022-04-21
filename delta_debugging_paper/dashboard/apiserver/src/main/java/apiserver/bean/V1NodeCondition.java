package apiserver.bean;

public class V1NodeCondition {
    private String MSG = null;
    private String RSN = null;
    private String STS = null;
    private String TP = null;

    public V1NodeCondition(){

    }

    public String getMessage() {
        return MSG;
    }

    public void setMessage(String MSG) {
        this.MSG = MSG;
    }

    public String getReason() {
        return RSN;
    }

    public void setReason(String RSN) {
        this.RSN = RSN;
    }

    public String getStatus() {
        return STS;
    }

    public void setStatus(String STS) {
        this.STS = STS;
    }

    public String getType() {
        return TP;
    }

    public void setType(String TP) {
        this.TP = TP;
    }
}
