package deltabackend.domain.api.request;

public class GetSinglePodLogRequest {
    private String Clus_name;
    private String Pod_name;

    public GetSinglePodLogRequest(){

    }

    public String getClusterName() {
        return Clus_name;
    }

    public void setClusterName(String Clus_name) {
        this.Clus_name = Clus_name;
    }

    public String getPodName() {
        return Pod_name;
    }

    public void setPodName(String Pod_name) {
        this.Pod_name = Pod_name;
    }
}
