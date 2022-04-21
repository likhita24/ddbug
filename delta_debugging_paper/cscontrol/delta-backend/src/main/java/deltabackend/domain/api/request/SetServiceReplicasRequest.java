package deltabackend.domain.api.request;

import deltabackend.domain.bean.ServiceReplicasSetting;
import java.util.List;

public class SetServiceReplicasRequest {
    private String Clus_name;
    private List<ServiceReplicasSetting> serviceReplicasSettings;

    public SetServiceReplicasRequest(){

    }

    public String getClusterName() {
        return Clus_name;
    }

    public void setClusterName(String Clus_name) {
        this.Clus_name = Clus_name;
    }

    public List<ServiceReplicasSetting> getServiceReplicasSettings() {
        return serviceReplicasSettings;
    }

    public void setServiceReplicasSettings(List<ServiceReplicasSetting> serviceReplicasSettings) {
        this.serviceReplicasSettings = serviceReplicasSettings;
    }
}
