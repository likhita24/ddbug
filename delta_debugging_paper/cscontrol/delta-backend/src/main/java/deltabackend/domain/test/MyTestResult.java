package deltabackend.domain.test;

public class MyTestResult {
    String sts; 
    String cName;
    String mName;
    String sTime;
    long dur;

    public MyTestResult(){

    }
    public String getClassName() {
        return cName;
    }

    public void setClassName(String cName) {
        this.cName = cName;
    }

    public String getMethodName() {
        return mName;
    }

    public void setMethodName(String mName) {
        this.mName = mName;
    }

    public String getStartTime() {
        return sTime;
    }

    public void setStartTime(String sTime) {
        this.sTime = sTime;
    }

    public long getDuration() {
        return dur;
    }

    public void setDuration(long dur) {
        this.dur = dur;
    }

    public String getStatus() {
        return sts;
    }

    public void setStatus(String sts) {
        this.sts = sts;
    }
}
