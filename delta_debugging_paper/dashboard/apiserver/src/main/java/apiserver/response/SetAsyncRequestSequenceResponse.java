package apiserver.response;

public class SetAsyncRequestSequenceResponse {

    private boolean STS;

    private String MSG;

    public SetAsyncRequestSequenceResponse() {
        //do nothing
    }

    public SetAsyncRequestSequenceResponse(boolean STS, String MSG) {
        this.STS = STS;
        this.MSG = MSG;
    }

    public boolean isStatus() {
        return STS;
    }

    public void setStatus(boolean STS) {
        this.STS = STS;
    }

    public String getMessage() {
        return MSG;
    }

    public void setMessage(String MSG) {
        this.MSG = MSG;
    }
}
