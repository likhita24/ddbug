package deltabackend.domain.test;

import deltabackend.domain.test.MyTestResult;
import java.util.List;

public class TestResponse {
    private boolean sts;
    private String msg;
    private Integer[] cnt_res;
    private List<MyTestResult> list_res;

    public TestResponse(){

    }

    public Integer[] getResultCount() {
        return cnt_res;
    }

    public void setResultCount(Integer[] cnt_res) {
        this.cnt_res = cnt_res;
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

    public List<MyTestResult> getResultList() {
        return list_res;
    }

    public void setResultList(List<MyTestResult> list_res) {
        this.list_res = list_res;
    }
}
