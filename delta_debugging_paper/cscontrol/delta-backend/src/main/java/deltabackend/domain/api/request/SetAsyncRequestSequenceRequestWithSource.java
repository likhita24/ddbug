package deltabackend.domain.api.request;

import java.util.ArrayList;

public class SetAsyncRequestSequenceRequestWithSource {
    private String Clus_name;
    private String scr_name;
    private ArrayList<String> svcl;

    public SetAsyncRequestSequenceRequestWithSource() {
        //do nothing
    }

    public SetAsyncRequestSequenceRequestWithSource(String Clus_name, String scr_name, ArrayList<String> svcl) {
        this.Clus_name = Clus_name;
        this.scr_name = scr_name;
        this.svcl = svcl;
    }

    public String getClusterName() {
        return Clus_name;
    }

    public void setClusterName(String Clus_name) {
        this.Clus_name = Clus_name;
    }

    public String getSourceName() {
        return scr_name;
    }

    public void setSourceName(String scr_name) {
        this.scr_name = scr_name;
    }

    public ArrayList<String> getSvcList() {
        return svcl;
    }

    public void setSvcList(ArrayList<String> svcl) {
        this.svcl = svcl;
    }
}
