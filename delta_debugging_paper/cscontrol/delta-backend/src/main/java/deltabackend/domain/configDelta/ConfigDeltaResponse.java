package deltabackend.domain.configDelta;

import deltabackend.domain.bean.SingleDeltaCMResourceRequest;
import deltabackend.domain.test.DeltaTestResponse;
import java.util.ArrayList;
import java.util.List;

public class ConfigDeltaResponse {
    boolean sts;
    String msg;
    List<SingleDeltaCMResourceRequest> env = new ArrayList<SingleDeltaCMResourceRequest>();
    DeltaTestResponse res;
    boolean dFF;

    public DeltaTestResponse getResult() {
        return res;
    }

    public void setResult(DeltaTestResponse res) {
        this.res = res;
    }

    public List<SingleDeltaCMResourceRequest> getEnv() {
        return env;
    }

    public void setEnv(List<SingleDeltaCMResourceRequest> env) {
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
