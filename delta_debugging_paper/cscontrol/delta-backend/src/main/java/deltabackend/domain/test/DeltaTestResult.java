package deltabackend.domain.test;

public class DeltaTestResult {
    String sts; 
    String cName;
    long dur = 0;

    public DeltaTestResult(){

    }

    public String getStatus() {
        return sts;
    }

    public void setStatus(String sts) {
        this.sts = sts;
    }

    public String getClassName() {
        return cName;
    }

    public void setClassName(String cName) {
        this.cName = cName;
    }

    public long getDuration() {
        return dur;
    }

    public void setDuration(long dur) {
        this.dur = dur;
    }

}
