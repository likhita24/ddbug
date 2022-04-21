package deltabackend.domain.test;

import java.util.List;

public class DeltaTestRequest {
    String clus;
    List<String> tName;

    public String getCluster() {
        return clus;
    }

    public void setCluster(String clus) {
        this.clus = clus;
    }

    public List<String> getTestNames() {
        return tName;
    }

    public void setTestNames(List<String> tName) {
        this.tName = tName;
    }
}
