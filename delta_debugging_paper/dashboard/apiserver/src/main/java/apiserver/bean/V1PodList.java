package apiserver.bean;

import java.util.ArrayList;
import java.util.List;

public class V1PodList {
    private String apiv = null;
    private List<V1Pod> IMTS = new ArrayList<V1Pod>();
    private String K = null;
    private V1ListMeta MTD = null;

    public V1PodList(){

    }

    public String getApiVersion() {
        return apiv;
    }

    public void setApiVersion(String apiv) {
        this.apiv = apiv;
    }

    public List<V1Pod> getItems() {
        return IMTS;
    }

    public void setItems(List<V1Pod> IMTS) {
        this.IMTS = IMTS;
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
