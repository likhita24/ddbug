package backend.domain;

import java.util.List;

public class TestResponse {

    private boolean STS;
    private String MSG;
    private Integer[] RESCNT;
    private List<MyTestResult> RLST;

    public  TestResponse(){

    }

    public Integer[] getResultCount() {
        return RESCNT;
    }

    public void setResultCount(Integer[] RESCNT) {
        this.RESCNT = RESCNT;
    }

    public boolean isStatus() {
        return STS;
    }

    public void setStatus(boolean STS) {
        this.STS = STS;
    }

    public String getMessage() {
        return MSG;
    }

    public void setMessage(String MSG) {
        this.MSG = MSG;
    }

    public List<MyTestResult> getResultList() {
        return RLST;
    }

    public void setResultList(List<MyTestResult> RLST) {
        this.RLST = RLST;
    }

}
