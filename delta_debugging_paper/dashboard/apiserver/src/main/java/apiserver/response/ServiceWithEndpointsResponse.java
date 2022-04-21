package apiserver.response;

import apiserver.bean.ServiceWithEndpoints;

import java.util.List;

public class ServiceWithEndpointsResponse {
    private boolean STS;
    private String MSG;
    private List<ServiceWithEndpoints> SRVS;

    public ServiceWithEndpointsResponse(){

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

    public List<ServiceWithEndpoints> getServices() {
        return SRVS;
    }

    public void setServices(List<ServiceWithEndpoints> SRVS) {
        this.SRVS = SRVS;
    }
}
