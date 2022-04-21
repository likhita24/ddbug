package apiserver.request;

import apiserver.bean.ServiceReplicasSetting;

import java.util.List;

public class SetServiceReplicasRequest {
    private String C_NE;
    private List<ServiceReplicasSetting> SRPSSTS;

    public SetServiceReplicasRequest(){

    }

    public String getClusterName() {
        return C_NE;
    }

    public void setClusterName(String C_NE) {
        this.C_NE = C_NE;
    }

    public List<ServiceReplicasSetting> getServiceReplicasSettings() {
        return SRPSSTS;
    }

    public void setServiceReplicasSettings(List<ServiceReplicasSetting> SRPSSTS) {
        this.SRPSSTS = SRPSSTS;
    }
}
