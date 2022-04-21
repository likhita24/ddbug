package apiserver.bean;

import java.util.List;

public class CMConfig {
    private String t;
    private List<CM> vs;

    public CMConfig(){

    }

    public String getType() {
        return t;
    }

    public void setType(String t) {
        this.t = t;
    }

    public List<CM> getValues() {
        return vs;
    }

    public void setValues(List<CM> vs) {
        this.vs = vs;
    }
}
