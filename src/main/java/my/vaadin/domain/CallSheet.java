package my.vaadin.domain;
import java.util.ArrayList;


public class CallSheet {


    private String callSheet;
    public String getCallSheet()
    {
        return callSheet;
    }
    public void setCallSheet(String callSheet) {
        this.callSheet = callSheet;
    }


    private ArrayList<Integer>  cnum = new ArrayList();

    public ArrayList<Integer> getCnum() {
        return cnum;
    }
    public void setCnum(ArrayList<Integer> cnum) {
        this.cnum = cnum;
    }
}

