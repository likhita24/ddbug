package deltabackend.domain.sequenceDelta;

import deltabackend.domain.api.request.SetAsyncRequestSequenceRequestWithSource;
import deltabackend.domain.test.DeltaTestResponse;
import java.util.List;

public class SequenceDeltaResponse {
    boolean sts;
    String msg;
    List<SetAsyncRequestSequenceRequestWithSource> listEnv;
    DeltaTestResponse res;
    boolean dFF;

    public SequenceDeltaResponse(){

    }

    public List<SetAsyncRequestSequenceRequestWithSource> getEnvList() {
        return listEnv;
    }

    public void setEnvList(List<SetAsyncRequestSequenceRequestWithSource> listEnv) {
        this.listEnv = listEnv;
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

    public DeltaTestResponse getResult() {
        return res;
    }

    public void setResult(DeltaTestResponse res) {
        this.res = res;
    }

    public boolean isDiffFromFirst() {
        return dFF;
    }

    public void setDiffFromFirst(boolean dFF) {
        this.dFF = dFF;
    }
}
