package deltabackend.domain.sequenceDelta;

import java.util.ArrayList;
import java.util.List;

public class SequenceDeltaRequest {
    String id;
    List<SingleSequenceDelta> ord_grps;
    List<String> tests;

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

    public List<String> getTests() {
        return tests;
    }

    public void setTests(List<String> tests) {
        this.tests = tests;
    }

    public SequenceDeltaRequest(){

    }
}
