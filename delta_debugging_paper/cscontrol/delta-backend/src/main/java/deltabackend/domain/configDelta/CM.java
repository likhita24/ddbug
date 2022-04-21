package deltabackend.domain.configDelta;

public class CM {
    private String imp;
    private String val;

    public CM(){

    }

    public CM(String imp, String val){
        this.imp = imp;
        this.val = val;
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
        return this.imp + ": " + this.val;
    }
}
