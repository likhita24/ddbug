package apiserver.bean;

import java.util.List;
import java.util.Map;

public class V1NodeStatus {
    private List<V1NodeAddress> ADRSS = null;
    private Map<String, String> CAPC = null;
    private Map<String, String> ALLTLE = null;
    private V1NodeSystemInfo NINF = null;
    private List<V1NodeCondition> CONDS = null;

    public V1NodeStatus(){

    }

    public List<V1NodeAddress> getAddresses() {
        return ADRSS;
    }

    public void setAddresses(List<V1NodeAddress> ADRSS) {
        this.ADRSS = ADRSS;
    }

    public Map<String, String> getCapacity() {
        return CAPC;
    }

    public void setCapacity(Map<String, String> CAPC) {
        this.CAPC = CAPC;
    }

    public Map<String, String> getAllocatable() {
        return ALLTLE;
    }

    public void setAllocatable(Map<String, String> ALLTLE) {
        this.ALLTLE = ALLTLE;
    }

    public V1NodeSystemInfo getNodeInfo() {
        return NINF;
    }

    public void setNodeInfo(V1NodeSystemInfo NINF) {
        this.NINF = NINF;
    }

    public List<V1NodeCondition> getConditions() {
        return CONDS;
    }

    public void setConditions(List<V1NodeCondition> CONDS) {
        this.CONDS = CONDS;
    }
}
