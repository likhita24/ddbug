package apiserver.response;

import apiserver.bean.PodLog;

import java.util.List;

public class GetPodsLogResponse {
    private boolean STS;
    private String MSGS;
    private List<PodLog> PLGS;

    public GetPodsLogResponse(){

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

    public List<PodLog> getPodLogs() {
        return PLGS;
    }

    public void setPodLogs(List<PodLog> PLGS) {
        this.PLGS = PLGS;
    }
}
