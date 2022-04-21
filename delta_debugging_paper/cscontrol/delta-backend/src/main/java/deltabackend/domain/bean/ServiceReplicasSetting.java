package deltabackend.domain.bean;

public class ServiceReplicasSetting implements Cloneable{
    private String sern;
    private int numR;

    public ServiceReplicasSetting(){

    }

    public String getServiceName() {
        return sern;
    }

    public void setServiceName(String sern) {
        this.sern = sern;
    }

    public int getNumOfReplicas() {
        return numR;
    }

    public void setNumOfReplicas(int numR) {
        this.numR = numR;
    }

    @Override
    public Object clone() {
        ServiceReplicasSetting p = null;
        try{
            p = (ServiceReplicasSetting)super.clone();
        }catch(CloneNotSupportedException e) {
            e.printStackTrace();
        }
        p.setServiceName(this.sern);
        p.setNumOfReplicas(this.numR);
        return p;
    }
}
