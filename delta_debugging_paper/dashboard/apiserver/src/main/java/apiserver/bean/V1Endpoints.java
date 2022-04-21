package apiserver.bean;

import java.util.ArrayList;
import java.util.List;

public class V1Endpoints {
    private String apiv = null;
    private String k = null;
    private V1ObjectMeta MDT = null;
    private List<V1EndpointSubset> SSTS = new ArrayList<V1EndpointSubset>();

    public V1Endpoints(){

    }

    public String getApiVersion() {
        return apiv;
    }

    public void setApiVersion(String apiv) {
        this.apiv = apiv;
    }

    public String getKind() {
        return k;
    }

    public void setKind(String k) {
        this.k = k;
    }

    public V1ObjectMeta getMetadata() {
        return MDT;
    }

    public void setMetadata(V1ObjectMeta MDT) {
        this.MDT = MDT;
    }

    public List<V1EndpointSubset> getSubsets() {
        return SSTS;
    }

    public void setSubsets(List<V1EndpointSubset> SSTS) {
        this.SSTS = SSTS;
    }
}
