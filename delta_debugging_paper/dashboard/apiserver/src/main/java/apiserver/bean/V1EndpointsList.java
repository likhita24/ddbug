package apiserver.bean;

import java.util.ArrayList;
import java.util.List;

public class V1EndpointsList {
    private String apiv = null;
    private List<V1Endpoints> IMS = new ArrayList<V1Endpoints>();
    private String K = null;
    private V1ListMeta MTD = null;

    public V1EndpointsList(){

    }

    public String getApiVersion() {
        return apiv;
    }

    public void setApiVersion(String apiv) {
        this.apiv = apiv;
    }

    public List<V1Endpoints> getItems() {
        return IMS;
    }

    public void setItems(List<V1Endpoints> IMS) {
        this.IMS = IMS;
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
