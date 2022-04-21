package deltabackend.domain.api.response;

public class DeltaNodeByListResponse {
    private boolean sts;
    private String msg;

    public DeltaNodeByListResponse(){
    }

    public boolean isStatus() {
        return sts;
    }

    public void setStatus(boolean sts) {
        this.sts = sts;
    }

    public String getMessage() {
        return msg;
    }

    public void setMessage(String msg) {
        this.msg = msg;
    }
}
