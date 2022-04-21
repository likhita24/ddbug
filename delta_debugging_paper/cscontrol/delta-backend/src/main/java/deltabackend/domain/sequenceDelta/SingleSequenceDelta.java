package deltabackend.domain.sequenceDelta;

import java.util.ArrayList;
import java.util.List;

public class SingleSequenceDelta {
    String sen;
    ArrayList<String> rec;

    public SingleSequenceDelta(){

    }

    public String getSender() {
        return sen;
    }

    public void setSender(String sen) {
        this.sen = sen;
    }

    public ArrayList<String> getReceivers() {
        return rec;
    }

    public void setReceivers(ArrayList<String> rec) {
        this.rec = rec;
    }


}
