package apiserver.response;

public class DeltaCMResourceResponse {
    private boolean sts;
    private String MSGS;

    public DeltaCMResourceResponse(){

    }

    public boolean isStatus() {
        return sts;
    }

    public void setStatus(boolean sts) {
        this.sts = sts;
    }

    public String getMessage() {
        return MSGS;
    }

    public void setMessage(String MSGS) {
        this.MSGS = MSGS;
    }
}
