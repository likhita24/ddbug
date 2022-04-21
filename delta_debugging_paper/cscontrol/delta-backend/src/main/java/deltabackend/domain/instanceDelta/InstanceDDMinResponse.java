package deltabackend.domain.instanceDelta;

import java.util.List;

public class InstanceDDMinResponse {

   public InstanceDDMinResponse(){

   }

    private boolean sts;
    private String msg;
    private List<String> res_ddmin;

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

    public List<String> getDdminResult() {
        return res_ddmin;
    }

    public void setDdminResult(List<String> res_ddmin) {
        this.res_ddmin = res_ddmin;
    }
}
