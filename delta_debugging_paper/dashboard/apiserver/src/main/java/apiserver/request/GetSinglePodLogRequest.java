package apiserver.request;

public class GetSinglePodLogRequest {
    private String CN;
    private String PNE;

    public GetSinglePodLogRequest(){

    }

    public String getClusterName() {
        return CN;
    }

    public void setClusterName(String CN) {
        this.CN = CN;
    }

    public String getPodName() {
        return PNE;
    }

    public void setPodName(String PNE) {
        this.PNE = PNE;
    }
}
