package apiserver.bean;

public class V1ContainerStateTerminated {
    private String CID = null;
    private Integer EXCDE = null;
    private String FAT = null;
    private String MSG = null;
    private String RSN = null;
    private Integer SGL = null;
    private String STAT = null;

    public V1ContainerStateTerminated(){

    }

    public String getContainerID() {
        return CID;
    }

    public void setContainerID(String CID) {
        this.CID = CID;
    }

    public Integer getExitCode() {
        return EXCDE;
    }

    public void setExitCode(Integer EXCDE) {
        this.EXCDE = EXCDE;
    }


    public String getMessage() {
        return MSG;
    }

    public void setMessage(String MSG) {
        this.MSG = MSG;
    }

    public String getFinishedAt() {
        return FAT;
    }

    public void setFinishedAt(String FAT) {
        this.FAT = FAT;
    }

    public String getMessage() {
        return MSG;
    }

    public void setMessage(String MSG) {
        this.MSG = MSG;
    }


     public Integer getSignal() {
        return SGL;
    }

    public String getReason() {
        return RSN;
    }

    public void setReason(String RSN) {
        this.RSN = RSN;
    }
   

   

    public void setStartedAt(String STAT) {
        this.STAT = STAT;
    }

     public void setSignal(Integer SGL) {
        this.SGL = SGL;
    }

    public String getStartedAt() {
        return STAT;
    }
}
