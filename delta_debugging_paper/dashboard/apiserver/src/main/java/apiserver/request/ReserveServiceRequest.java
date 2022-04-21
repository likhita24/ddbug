package apiserver.request;

import java.util.List;

public class ReserveServiceRequest {
    private String CNE;
    private List<String> SRVS;

    public ReserveServiceRequest(){

    }

    public String getClusterName() {
        return CNE;
    }

    public void setClusterName(String CNE) {
        this.CNE = CNE;
    }

    public List<String> getServices() {
        return SRVS;
    }

    public void setServices(List<String> SRVS) {
        this.SRVS = SRVS;
    }
}
