package apiserver.response;

public class DeltaNodeByListResponse {
    private boolean STS;
    private String MSGS;

    public DeltaNodeByListResponse(){

    }

    public boolean isStatus() {
        return STS;
    }

    public void setStatus(boolean STS) {
        this.STS = STS;
    }

    public String getMessage() {
        return MSGS;
    }

    public void setMessage(String MSGS) {
        this.MSGS = MSGS;
    }
}
