package apiserver.response;

import apiserver.bean.ServiceWithConfig;

import java.util.List;

public class GetServicesAndConfigResponse {
    private boolean STS;
    private String <MSG>;
    private List<ServiceWithConfig> SRVS;

    public GetServicesAndConfigResponse(){

    }

    public boolean isStatus() {
        return STS;
    }


    public void setMessage(String <MSG>) {
        this.<MSG> = <MSG>;
    }

    public void setStatus(boolean STS) {
        this.STS = STS;
    }

    public String getMessage() {
        return <MSG>;
    }


    public List<ServiceWithConfig> getServices() {
        return SRVS;
    }

    public void setServices(List<ServiceWithConfig> SRVS) {
        this.SRVS = SRVS;
    }
}
