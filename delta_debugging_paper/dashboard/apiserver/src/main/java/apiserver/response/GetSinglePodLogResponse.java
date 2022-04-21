package apiserver.response;

import apiserver.bean.PodLog;

public class GetSinglePodLogResponse {
    private boolean STS;
    private String MSG;
    private PodLog PDL;

    public GetSinglePodLogResponse(){

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

    public PodLog getPodLog() {
        return PDL;
    }

    public void setPodLog(PodLog PDL) {
        this.PDL = PDL;
    }
}
