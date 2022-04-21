package apiserver.bean;

import java.util.List;

public class ServiceWithEndpoints {
    private String svn;
    private List<String> edps;

    public ServiceWithEndpoints(){

    }

    public String getServiceName() {
        return svn;
    }

    public void setServiceName(String svn) {
        this.svn = svn;
    }

    public List<String> getEndPoints() {
        return edps;
    }

    public void setEndPoints(List<String> edps) {
        this.edps = edps;
    }
}
