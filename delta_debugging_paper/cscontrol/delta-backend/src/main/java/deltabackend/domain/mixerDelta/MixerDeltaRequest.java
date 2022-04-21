package deltabackend.domain.mixerDelta;

import deltabackend.domain.bean.SingleDeltaCMResourceRequest;
import deltabackend.domain.sequenceDelta.SingleSequenceDelta;
import java.util.ArrayList;
import java.util.List;

public class MixerDeltaRequest {
    String id;
    List<String> ins;
    List<SingleSequenceDelta> ord_grps;
    List<SingleDeltaCMResourceRequest> confs;
    List<String> tests;

    public MixerDeltaRequest(){

    }

    public List<SingleSequenceDelta> getSeqGroups() {
        return ord_grps;
    }

    public void setSeqGroups(List<SingleSequenceDelta> ord_grps) {
        this.ord_grps = ord_grps;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getInstances() {
        return ins;
    }

    public void setInstances(List<String> ins) {
        this.ins = ins;
    }

    public List<SingleDeltaCMResourceRequest> getConfigs() {
        return confs;
    }

    public void setConfigs(List<SingleDeltaCMResourceRequest> confs) {
        this.confs = confs;
    }

    public List<String> getTests() {
        return tests;
    }

    public void setTests(List<String> tests) {
        this.tests = tests;
    }
}
