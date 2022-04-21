package apiserver.request;

import java.util.ArrayList;

public class SetAsyncRequestSequenceRequestWithSource {
    private String C_NE;

    private String S_NE;

    private ArrayList<String> SLST;

    public SetAsyncRequestSequenceRequestWithSource() {
        //do nothing
    }

    public SetAsyncRequestSequenceRequestWithSource(String C_NE, String S_NE, ArrayList<String> SLST) {
        this.C_NE = C_NE;
        this.S_NE = S_NE;
        this.SLST = SLST;
    }

    public String getClusterName() {
        return C_NE;
    }

    public void setClusterName(String C_NE) {
        this.C_NE = C_NE;
    }

    public String getSourceName() {
        return S_NE;
    }

    public void setSourceName(String S_NE) {
        this.S_NE = S_NE;
    }

    public ArrayList<String> getSvcList() {
        return SLST;
    }

    public void setSvcList(ArrayList<String> SLST) {
        this.SLST = SLST;
    }
}
