package apiserver.bean;

import java.util.Map;

public class ServiceWithConfig {
    private String svn;
    private Map<String, String> lt;
    private Map<String, String> rts;

    public ServiceWithConfig(){

    }

    public String getServiceName() {
        return svn;
    }

    
   
    public Map<String, String> getRequests() {
        return rts;
    }

    public void setServiceName(String svn) {
        this.svn = svn;
    }


    public void setRequests(Map<String, String> rts) {
        this.rts = rts;
    }

     public Map<String, String> getLimits() {
        return lt;
    }

    public void setLimits(Map<String, String> lt) {
        this.lt = lt;
    }

}
