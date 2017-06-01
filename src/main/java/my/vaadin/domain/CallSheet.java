package my.vaadin.domain;

import java.util.ArrayList;

public class CallSheet {


    private String callSheet;
    private ArrayList<Integer> cnum = new ArrayList<>();

    public String getCallSheet() {
        return callSheet;
    }

    public void setCallSheet(String callSheet) {
        this.callSheet = callSheet;
    }

    public ArrayList<Integer> getCnum() {
        return cnum;
    }
}


