package deltabackend.domain.api;

import java.util.List;

public class GetServicesListResponse {
    private boolean sts;
    private String msg;
    private List<String> servs;

    public GetServicesListResponse(){

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

    public List<String> getServices() {
        return servs;
    }

    public void setServices(List<String> servs) {
        this.servs = servs;
    }
}
