package deltabackend.domain.api.request;

public class SetUnsetServiceRequestSuspendRequest {
    public static final int SET_TO_SUSPEND = 1;
    public static final int UNSET_SUSPEND = 2;

    private String Clus_name;
    private String ssn;
    private String svc;

    public SetUnsetServiceRequestSuspendRequest() {
        //do nothing
    }

    public SetUnsetServiceRequestSuspendRequest(String Clus_name, String ssn, String svc) {
        this.Clus_name = Clus_name;
        this.ssn = ssn;
        this.svc = svc;
    }

    public String getClusterName() {
        return Clus_name;
    }

    public void setClusterName(String Clus_name) {
        this.Clus_name = Clus_name;
    }

    public String getSourceSvcName() {
        return ssn;
    }

    public void setSourceSvcName(String ssn) {
        this.ssn = ssn;
    }

    public String getSvc() {
        return svc;
    }

    public void setSvc(String svc) {
        this.svc = svc;
    }
}
