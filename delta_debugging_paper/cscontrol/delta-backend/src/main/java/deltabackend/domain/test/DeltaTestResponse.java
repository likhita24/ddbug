package deltabackend.domain.test;

import java.util.ArrayList;
import java.util.List;

public class DeltaTestResponse {

    private int sts;
    private String msg;
    List<DeltaTestResult> dRes = new ArrayList<DeltaTestResult>();

    public int getStatus() {
        return sts;
    }

    public void setStatus(int sts) {
        this.sts = sts;
    }

    public String getMessage() {
        return msg;
    }

    public void setMessage(String msg) {
        this.msg = msg;
    }

    public List<DeltaTestResult> getDeltaResults() {
        return dRes;
    }

    public void setDeltaResults(List<DeltaTestResult> res) {
        this.dRes = res;
    }

    public void addDeltaResult(DeltaTestResult d){
        dRes.add(d);
    }
}
