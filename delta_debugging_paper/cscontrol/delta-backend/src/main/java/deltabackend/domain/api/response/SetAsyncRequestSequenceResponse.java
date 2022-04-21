package deltabackend.domain.api.response;

public class SetAsyncRequestSequenceResponse {
    private boolean sts;
    private String msg;

    public SetAsyncRequestSequenceResponse() {
        //do nothing
    }

    public SetAsyncRequestSequenceResponse(boolean sts, String msg) {
        this.sts = sts;
        this.msg = msg;
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
