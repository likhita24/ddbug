package deltabackend.domain.serviceDelta;

import java.util.List;

public class ReserveServiceResponse {
    private boolean sts;
    private String msg;
    private List<String> sern;

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

    public List<String> getServiceNames() {
        return sern;
    }

    public void setServiceNames(List<String> sern) {
        this.sern = sern;
    }
}
