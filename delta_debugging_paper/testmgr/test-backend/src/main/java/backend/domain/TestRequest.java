package backend.domain;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class TestRequest {
    @Valid
    @NotNull
    private String TSTRN;

    public TestRequest(){

    }
    public String getTestString() {
        return TSTRN;
    }

    public void setTestString(String TSTRN) {
        this.TSTRN = TSTRN;
    }



}
