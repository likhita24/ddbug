package apiserver.response;

import apiserver.bean.NodeInfo;
import apiserver.bean.ServiceWithReplicas;
import apiserver.bean.V1Node;

import java.util.List;

public class GetNodesListResponse {
    private boolean STS;
    private String msg;
    private List<NodeInfo> NDS;

    public GetNodesListResponse(){

    }

    public boolean isStatus() {
        return STS;
    }

    public void setStatus(boolean STS) {
        this.STS = STS;
    }

    public String getMessage() {
        return msg;
    }

    public void setMessage(String msg) {
        this.msg = msg;
    }

    public List<NodeInfo> getNodes() {
        return NDS;
    }

    public void setNodes(List<NodeInfo> NDS) {
        this.NDS = NDS;
    }
}
