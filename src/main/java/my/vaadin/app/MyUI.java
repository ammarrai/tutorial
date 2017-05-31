package my.vaadin.app;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.data.Property;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import org.jsoup.helper.StringUtil;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.annotation.WebServlet;

import my.vaadin.domain.CallSheet;

@Theme("mytheme")
public class MyUI extends UI {

    BeanItemContainer<CallSheet> container;

    @Override
    protected void init(VaadinRequest vaadinRequest) {

        Map<String, CallSheet> callSheetMap = new LinkedHashMap<>();
        List<String> list = new ArrayList<>();
        list.add("AA");
        list.add("BB");
        list.add("PC");
        list.add("BM");
        list.add("JB");
        list.add("DK");
        BeanItemContainer<CallSheet> container = new BeanItemContainer(String.class, list);

        ComboBox selector = new ComboBox("Call Sheets", container);

        TextField cnumText = new TextField();

        selector.addValueChangeListener(new Property.ValueChangeListener() {
            @Override
            public void valueChange(Property.ValueChangeEvent valueChangeEvent) {
                if (valueChangeEvent.getProperty().getValue() != null) {
                    String chosenCallsheet = valueChangeEvent.getProperty().getValue().toString();
                    if (callSheetMap.get(chosenCallsheet) != null) {
                        StringBuilder cnumsText = new StringBuilder();
                        for (Integer cnum : callSheetMap.get(chosenCallsheet).getCnum()) {
                            cnumsText.append(cnum + ",");
                        }
                        cnumText.setValue(cnumsText.toString().substring(0, cnumsText.toString().length()-1));
                    } else {
                        cnumText.clear();
                    }
                }
            }
        });

        Button saveButton = new Button("Save");
        saveButton.addClickListener(new ClickListener() {

            @Override
            public void buttonClick(com.vaadin.ui.Button.ClickEvent event) {

                if (selector.getValue() == null || cnumText.getValue() == null) {

                    Notification.show("Invalid Input !!");

                } else {

                    CallSheet callSheet = new CallSheet();
                    callSheet.setCallSheet(selector.getValue().toString());

                    String cnumns[] = cnumText.getValue().toString().split(",");

                    StringBuilder msg = new StringBuilder();

                    try {
                        for (String cnum : cnumns) {

                            if (!StringUtil.isNumeric(cnum) && Integer.parseInt(cnum) < 0
                                    && Integer.parseInt(cnum) > 10000) {

                                msg.append("Cnum must be number between 1- 10000 : " + cnum + "\n");

                            } else {
                                callSheet.getCnum().add(Integer.parseInt(cnum));
                                System.out.println("CallSheet :: " + selector.getValue());
                                System.out.println("Cnums :: " + cnum);
                                msg.append("Valid Cnum , Saved!" + cnum + "\n");
                            }
                        }
                        Notification.show(msg.toString());
                        callSheetMap.put(selector.getValue().toString(),callSheet);
                    } catch (Exception e) {
                        Notification.show("Invalid Input!");
                    }
                }
            }
        });
        saveButton.addStyleName("mynewclass");

        Button cancelButton = new Button("Cancel");
        cancelButton.addClickListener(event -> {

        });
        cancelButton.addStyleName("mynewclass");

        Button newButton = new Button("New Callsheet", event -> {
            CallSheet callSheet = new CallSheet();
            callSheet.setCallSheet("A");
            container.addBean(callSheet);
        });
        newButton.addStyleName("mynewclass");

        HorizontalLayout buttonBar = new HorizontalLayout(saveButton, cancelButton, newButton);

        VerticalLayout layout = new VerticalLayout(selector, cnumText, buttonBar);
        setContent(layout);

    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
