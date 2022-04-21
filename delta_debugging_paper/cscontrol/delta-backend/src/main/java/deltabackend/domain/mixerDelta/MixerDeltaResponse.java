package deltabackend.domain.mixerDelta;

import deltabackend.domain.api.request.SetAsyncRequestSequenceRequestWithSource;
import deltabackend.domain.bean.ServiceWithReplicas;
import deltabackend.domain.bean.SingleDeltaCMResourceRequest;
import deltabackend.domain.test.DeltaTestResponse;
import java.util.List;

public class MixerDeltaResponse {
    boolean sts;
    String msg;
    List<SingleDeltaCMResourceRequest> conf_env;
    List<SetAsyncRequestSequenceRequestWithSource> seqEnv;
    List<ServiceWithReplicas> ins_env;
    DeltaTestResponse res;
    boolean dFF;

    public MixerDeltaResponse(){

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

    public List<SingleDeltaCMResourceRequest> getConfigEnv() {
        return conf_env;
    }

    public void setConfigEnv(List<SingleDeltaCMResourceRequest> conf_env) {
        this.conf_env = conf_env;
    }

    public List<SetAsyncRequestSequenceRequestWithSource> getSeqEnv() {
        return seqEnv;
    }

    public void setSeqEnv(List<SetAsyncRequestSequenceRequestWithSource> seqEnv) {
        this.seqEnv = seqEnv;
    }

    public List<ServiceWithReplicas> getInstanceEnv() {
        return ins_env;
    }

    public void setInstanceEnv(List<ServiceWithReplicas> ins_env) {
        this.ins_env = ins_env;
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
