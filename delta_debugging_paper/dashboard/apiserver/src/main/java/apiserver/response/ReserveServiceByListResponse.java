package apiserver.response;

public class ReserveServiceByListResponse {
    private boolean STS;
    private String MSG;

    public ReserveServiceByListResponse(){

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
