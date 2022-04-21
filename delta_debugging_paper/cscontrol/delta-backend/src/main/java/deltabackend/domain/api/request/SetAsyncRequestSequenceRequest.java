package deltabackend.domain.api.request;

import java.util.ArrayList;

public class SetAsyncRequestSequenceRequest {
    private String Clus_name;
    private ArrayList<String> svcl;

    public SetAsyncRequestSequenceRequest() {
        //do nothing
    }

    public String getClusterName() {
        return Clus_name;
    }

    public void setClusterName(String Clus_name) {
        this.Clus_name = Clus_name;
    }

    public SetAsyncRequestSequenceRequest(ArrayList<String> svcl) {
        this.svcl = svcl;
    }

    public ArrayList<String> getSvcList() {
        return svcl;
    }

    public void setSvcList(ArrayList<String> svcl) {
        this.svcl = svcl;
    }
}
