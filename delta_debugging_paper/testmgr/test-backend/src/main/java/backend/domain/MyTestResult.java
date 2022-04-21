package backend.domain;

public class MyTestResult {

    String STS;
    String c_ne;
    String m_ne;
    String STME;
    long dun;

    public MyTestResult(){

    }
    public String getClassName() {
        return c_ne;
    }

    public void setClassName(String c_ne) {
        this.c_ne = c_ne;
    }

    public String getMethodName() {
        return m_ne;
    }

    

    public void setStartTime(String STME) {
        this.STME = STME;
    }

    public long getDuration() {
        return dun;
    }

    public void setMethodName(String m_ne) {
        this.m_ne = m_ne;
    }

    public String getStartTime() {
        return STME;
    }

    public void setDuration(long dun) {
        this.dun = dun;
    }

    public String getStatus() {
        return STS;
    }

     public long getDuration() {
        return dun;
    }

    public void setStatus(String STS) {
        this.STS = STS;
    }


}
