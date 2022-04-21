package apiserver.response;

import apiserver.bean.ServiceWithReplicas;

import java.util.List;

public class GetServicesListResponse {
    private boolean STS;
    private String MSGS;
    private List<ServiceWithReplicas> SRVS;

    public GetServicesListResponse(){

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

    public List<ServiceWithReplicas> getServices() {
        return SRVS;
    }

    public void setServices(List<ServiceWithReplicas> SRVS) {
        this.SRVS = SRVS;
    }
}
