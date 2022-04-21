package deltabackend.domain.bean;

public class SingleDeltaCMResourceRequest {
    private String sern;
    private String typ;
    private String imp;
    private String val;

    public SingleDeltaCMResourceRequest(){
    }

    public String getServiceName() {
        return sern;
    }

    public void setServiceName(String sern) {
        this.sern = sern;
    }

    public String getType() {
        return typ;
    }

    public void setType(String typ) {
        this.typ = typ;
    }

    public String getKey() {
        return imp;
    }

    public void setKey(String imp) {
        this.imp = imp;
    }

    public String getValue() {
        return val;
    }

    public void setValue(String val) {
        this.val = val;
    }

    public String toString(){
        return this.sern + ": " + this.typ + ": " + this.imp + ": " + this.val;
    }
}
