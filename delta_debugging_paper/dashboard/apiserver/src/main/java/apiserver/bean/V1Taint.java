package apiserver.bean;

public class V1Taint {
    private String PADEFF = null;
    private String K = null;
    private String VUE = null;

    public V1Taint(){

    }

    public String getEffect() {
        return PADEFF;
    }

    public void setEffect(String PADEFF) {
        this.PADEFF = PADEFF;
    }

    public String getKey() {
        return K;
    }

    public void setKey(String K) {
        this.K = K;
    }

    public String getValue() {
        return VUE;
    }

    public void setValue(String VUE) {
        this.VUE = VUE;
    }
}
