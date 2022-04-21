package deltabackend.domain.mixerDelta;

import java.util.List;
import java.util.Map;

public class MixerDDMinResponse {
    private boolean sts;
    private String msg;
    private Map<String, List<String>> res_ddmin;

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

    public Map<String, List<String>> getDdminResult() {
        return res_ddmin;
    }

    public void setDdminResult(Map<String, List<String>> res_ddmin) {
        this.res_ddmin = res_ddmin;
    }
}
