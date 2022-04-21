package apiserver.bean;

import java.util.Map;

public class V1ResourceRequirements {
    private Map<String, String> LTS = null;
    private Map<String, String> RTS = null;

    public V1ResourceRequirements(){

    }

    public Map<String, String> getLimits() {
        return LTS;
    }

    public void setLimits(Map<String, String> LTS) {
        this.LTS = LTS;
    }

    public Map<String, String> getRequests() {
        return RTS;
    }

    public void setRequests(Map<String, String> RTS) {
        this.RTS = RTS;
    }
}
