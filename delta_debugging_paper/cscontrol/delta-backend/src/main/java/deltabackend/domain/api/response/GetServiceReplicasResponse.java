package deltabackend.domain.api.response;

import deltabackend.domain.bean.ServiceWithReplicas;
import java.util.List;

public class GetServiceReplicasResponse {
    private boolean sts;
    private String msg;
    private List<ServiceWithReplicas> sers;

    public GetServiceReplicasResponse(){
    }

    public boolean isStatus() {
        return sts;
    }

    public void setStatus(boolean sts) {
        this.sts = sts;
    }

    public String getMessage() {
        return msg;
    }

    public void setMessage(String msg) {
        this.msg = msg;
    }

    public List<ServiceWithReplicas> getServices() {
        return sers;
    }

    public void setServices(List<ServiceWithReplicas> sers) {
        this.sers = sers;
    }
}
