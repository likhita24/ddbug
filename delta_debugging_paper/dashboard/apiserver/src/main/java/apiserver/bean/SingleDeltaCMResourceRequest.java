package apiserver.bean;

public class SingleDeltaCMResourceRequest {
    private String svn;
    private String tps;
    private String k;
    private String vue;

    public SingleDeltaCMResourceRequest(){

    }

    public String getServiceName() {
        return svn;
    }

    public void setServiceName(String svn) {
        this.svn = svn;
    }

    public String getType() {
        return tps;
    }

    public void setType(String tps) {
        this.tps = tps;
    }

    public String getKey() {
        return k;
    }

    public void setKey(String k) {
        this.k = k;
    }

    public String getValue() {
        return vue;
    }

    public void setValue(String vue) {
        this.vue = vue;
    }
}
