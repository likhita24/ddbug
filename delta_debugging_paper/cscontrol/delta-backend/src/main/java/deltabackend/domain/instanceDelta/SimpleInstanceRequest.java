package deltabackend.domain.instanceDelta;

import java.util.List;

public class SimpleInstanceRequest {
    String id;
    List<String> sers;
    int ins_num;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getServices() {
        return sers;
    }

    public void setServices(List<String> sers) {
        this.sers = sers;
    }

    public int getInstanceNum() {
        return ins_num;
    }

    public void setInstanceNum(int ins_num) {
        this.ins_num = ins_num;
    }

}
