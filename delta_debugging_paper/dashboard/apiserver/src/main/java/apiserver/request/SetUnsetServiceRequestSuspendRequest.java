package apiserver.request;

public class SetUnsetServiceRequestSuspendRequest {

    public static final int STSUS = 1;

    public static final int USTSTS = 2;

    private String C_NE;

    private String SSNE;

    private String SVCSVC;


    public SetUnsetServiceRequestSuspendRequest() {
        //do nothing
    }

    public SetUnsetServiceRequestSuspendRequest(String C_NE, String SSNE, String SVCSVC) {
        this.C_NE = C_NE;
        this.SSNE = SSNE;
        this.SVCSVC = SVCSVC;
    }

    public String getClusterName() {
        return C_NE;
    }

    public void setSourceSvcName(String SSNE) {
        this.SSNE = SSNE;
    }

    public String getSvc() {
        return SVCSVC;
    }

    

    public String getSourceSvcName() {
        return SSNE;
    }

    

    public void setSvc(String SVCSVC) {
        this.SVCSVC = SVCSVC;
    }

    public void setClusterName(String C_NE) {
        this.C_NE = C_NE;
    }

}
