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
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
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
    ComboBox selector;
    TextField cnumText;
    Map<String, CallSheet> callSheetMap = new LinkedHashMap<>(); // Map to store Saved CallSheet

    @Override
    protected void init(VaadinRequest vaadinRequest) {

        Label callSheetLabel = new Label("Callsheet Name:");

        Label cnumsLabel = new Label("Complex Number");

        List<String> list = new ArrayList<>();

        container = new BeanItemContainer(String.class, list);

        selector = new ComboBox("Callsheet Name:", container);

        callSheetLabel.addStyleName("textbox");

        cnumText = new TextField("Complex Number: ");

        cnumsLabel.addStyleName("textbox");

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
                        cnumText.setValue(cnumsText.toString().substring(0, cnumsText.toString().length() - 1));
                    } else {
                        cnumText.clear();
                    }
                }
            }
        });

        /* SAVE BUTTON */

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
                                    && Integer.parseInt(cnum) > 9999999) {
                                msg.append("Cnum must be number between 1- 9999999 : " + cnum + "\n");
                            } else {
                                callSheet.getCnum().add(Integer.parseInt(cnum));
                                System.out.println("CallSheet :: " + selector.getValue());
                                System.out.println("Cnums :: " + cnum);
                                msg.append("Valid Cnum , Saved!" + cnum + "\n");
                            }
                        }
                        Notification.show(msg.toString());
                        callSheetMap.put(selector.getValue().toString(), callSheet);
                    } catch (Exception e) {
                        Notification.show("Invalid Input!");
                    }
                }
            }
        });
        saveButton.addStyleName("mynewclass");

        /* NEW CALL SHEET BUTTON */

        Button newButton = new Button("New Callsheet");
        newButton.addClickListener(new ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                // Send current UI to Popup UI to manipulate data field
                NewCallSheet newCallSheetWindow = new NewCallSheet((MyUI) UI.getCurrent());
                newCallSheetWindow.setModal(true);
                newCallSheetWindow.setResizable(true);
                newCallSheetWindow.setDraggable(true);
                newCallSheetWindow.setWidth("300px");
                newCallSheetWindow.setHeight("-1px");
                // Open it in the UI
                addWindow(newCallSheetWindow);
            }
        });
        newButton.addStyleName("mynewclass");

        FormLayout callSheetRow = new FormLayout( selector);
        FormLayout cnumRow = new FormLayout( cnumText);
        HorizontalLayout buttonBar = new HorizontalLayout(saveButton, newButton);
        VerticalLayout layout = new VerticalLayout(callSheetRow, cnumRow, buttonBar);
        setContent(layout);
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }

    public BeanItemContainer<CallSheet> getContainer() {
        return container;
    }

    public void setContainer(BeanItemContainer<CallSheet> container) {
        this.container = container;
    }

    public ComboBox getSelector() {
        return selector;
    }

    public void setSelector(ComboBox selector) {
        this.selector = selector;
    }

    public TextField getCnumText() {
        return cnumText;
    }

    public void setCnumText(TextField cnumText) {
        this.cnumText = cnumText;
    }

    public Map<String, CallSheet> getCallSheetMap() {
        return callSheetMap;
    }

    public void setCallSheetMap(Map<String, CallSheet> callSheetMap) {
        this.callSheetMap = callSheetMap;
    }
}
