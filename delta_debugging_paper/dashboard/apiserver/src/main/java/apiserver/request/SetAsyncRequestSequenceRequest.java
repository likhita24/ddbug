package apiserver.request;

import java.util.ArrayList;

public class SetAsyncRequestSequenceRequest {
    private String C_NE;

    private ArrayList<String> svcList;

    public SetAsyncRequestSequenceRequest() {
        //do nothing
    }

    public String getClusterName() {
        return C_NE;
    }

    public void setClusterName(String C_NE) {
        this.C_NE = C_NE;
    }

    public SetAsyncRequestSequenceRequest(ArrayList<String> svcList) {
        this.svcList = svcList;
    }

    public ArrayList<String> getSvcList() {
        return svcList;
    }

    public void setSvcList(ArrayList<String> svcList) {
        this.svcList = svcList;
    }
}
