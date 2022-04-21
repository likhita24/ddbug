package apiserver.bean;

public class V1ContainerStateWaiting {
    private String MSG = null;
    private String RSN = null;

    public V1ContainerStateWaiting(){

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
}
