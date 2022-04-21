package apiserver.bean;

public class PodLog {
    private String PNAME;
    private String LS;

    public PodLog(){

    }

    public String getPodName() {
        return PNAME;
    }

    public void setPodName(String PNAME) {
        this.PNAME = PNAME;
    }

    public String getLogs() {
        return LS;
    }

    public void setLogs(String LS) {
        this.LS = LS;
    }
}
