package deltabackend.domain.api.request;

import java.util.List;

public class ReserveServiceRequest {
    private String Clus_name;
    private List<String> services;

    public ReserveServiceRequest(){

    }

    public String getClusterName() {
        return Clus_name;
    }

    public void setClusterName(String Clus_name) {
        this.Clus_name = Clus_name;
    }

    public List<String> getServices() {
        return services;
    }

    public void setServices(List<String> services) {
        this.services = services;
    }
}
