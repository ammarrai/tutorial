package my.vaadin.domain;

import com.vaadin.ui.Component;
import com.vaadin.ui.Window;

import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;


public class CallSheet extends Window {


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

    public void setCnum(ArrayList<Integer> cnum) {
        this.cnum = cnum;
    }

    @Override
    public void forEach(Consumer<? super Component> action) {

    }

    @Override
    public Spliterator<Component> spliterator() {
        return null;
    }
}

