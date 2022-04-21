package apiserver.response;

import apiserver.bean.NodeInfo;
import apiserver.bean.PodInfo;

import java.util.List;

public class GetPodsListResponse {
    private boolean STS;
    private String MSGS;
    private List<PodInfo> PD;

    public GetPodsListResponse(){

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

    public List<PodInfo> getPods() {
        return PD;
    }

    public void setPods(List<PodInfo> PD) {
        this.PD = PD;
    }
}
