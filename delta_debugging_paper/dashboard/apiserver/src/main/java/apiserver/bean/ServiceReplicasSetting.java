package apiserver.bean;

public class ServiceReplicasSetting {
    private String svn;
    private int nor;

    public ServiceReplicasSetting(){

    }

    public String getServiceName() {
        return svn;
    }

    public void setServiceName(String svn) {
        this.svn = svn;
    }

    public int getNumOfReplicas() {
        return nor;
    }

    public void setNumOfReplicas(int nor) {
        this.nor = nor;
    }
}
