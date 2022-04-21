package apiserver.bean;

import java.util.ArrayList;
import java.util.List;

public class V1NodeList {
    private String apiv = null;

    private List<V1Node> ITM = new ArrayList<V1Node>();

    private String K = null;

    private V1ListMeta MTD = null;

    public V1NodeList(){

    }

    public String getApiVersion() {
        return apiv;
    }

    public void setApiVersion(String apiv) {
        this.apiv = apiv;
    }

    public List<V1Node> getItems() {
        return ITM;
    }

    public void setItems(List<V1Node> ITM) {
        this.ITM = ITM;
    }

    public String getKind() {
        return K;
    }

    public void setKind(String K) {
        this.K = K;
    }

    public V1ListMeta getMetadata() {
        return MTD;
    }

    public void setMetadata(V1ListMeta MTD) {
        this.MTD = MTD;
    }
}
