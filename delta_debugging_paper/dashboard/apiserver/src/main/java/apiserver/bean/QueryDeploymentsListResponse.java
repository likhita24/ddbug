package apiserver.bean;

import java.util.List;

public class QueryDeploymentsListResponse {
    private String apiv = null;

    private String k = null;

    private List<SingleDeploymentInfo> its;

    public QueryDeploymentsListResponse(){

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

    public List<SingleDeploymentInfo> getItems() {
        return its;
    }

    public void setItems(List<SingleDeploymentInfo> its) {
        this.its = its;
    }
}
