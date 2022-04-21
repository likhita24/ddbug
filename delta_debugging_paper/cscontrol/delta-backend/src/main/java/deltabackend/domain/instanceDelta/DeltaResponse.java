package deltabackend.domain.instanceDelta;

import deltabackend.domain.bean.ServiceWithReplicas;
import deltabackend.domain.test.DeltaTestResponse;
import java.util.ArrayList;
import java.util.List;

public class DeltaResponse {
    boolean sts;
    String msg;
    List<ServiceWithReplicas> env = new ArrayList<ServiceWithReplicas>();
    DeltaTestResponse res;
    boolean dFF;//different from the first test res, highlight it

    public DeltaTestResponse getResult() {
        return res;
    }

    public void setResult(DeltaTestResponse res) {
        this.res = res;
    }

    public List<ServiceWithReplicas> getEnv() {
        return env;
    }

    public void setEnv(List<ServiceWithReplicas> env) {
        this.env = env;
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

    public boolean isDiffFromFirst() {
        return dFF;
    }

    public void setDiffFromFirst(boolean dFF) {
        this.dFF = dFF;
    }


}
