package my.vaadin.app;

import com.vaadin.server.Page;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

import org.jsoup.helper.StringUtil;

import java.util.Map;

import my.vaadin.domain.CallSheet;

/**
 * Created by markrai on 5/31/2017.
 */
public class NewCallSheet extends Window {


    public NewCallSheet(MyUI myUI) {
        super("Add New CallSheet");
        Map<String, CallSheet> callSheetMap = myUI.getCallSheetMap();

        // Create components for popup Window
        Label callSheet = new Label("CallSheet Name");
        callSheet.addStyleName("textbox");
        Label cnumsLabel = new Label("Complex Number");
        cnumsLabel.addStyleName("textbox");
        TextField cnumText = new TextField();
        TextField CallSheetText = new TextField();
        Button saveButton = new Button("Add");

        saveButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                if (CallSheetText.getValue() == "" || cnumText.getValue() == "") {
                    Notification.show("Invalid Input !!");
                } else {
                    // Get data from popup Window
                    String inputtedCallSheet = CallSheetText.getValue().toString();
                    String cnumns[] = cnumText.getValue().toString().split(",");

                    // Create a new CallSheet object
                    CallSheet sheet = new CallSheet();
                    sheet.setCallSheet(inputtedCallSheet);
                    StringBuilder msg = new StringBuilder();
                    for (String cnum : cnumns) {
                        if (!StringUtil.isNumeric(cnum) && Integer.parseInt(cnum) < 0
                                && Integer.parseInt(cnum) > 10000) {
                            msg.append("Cnum must be number between 1- 10000 : " + cnum + "\n");
                        } else {
                            sheet.getCnum().add(Integer.parseInt(cnum));
                            System.out.println("CallSheet :: " + CallSheetText.getValue());
                            System.out.println("Cnums :: " + cnum);
                            msg.append("Valid Cnum , Saved!" + cnum + "\n");
                        }
                    }
                    Notification.show(msg.toString());
                    // Save new CallSheet to map
                    callSheetMap.put(inputtedCallSheet, sheet);
                    // Add new CallSheet to the selector
                    myUI.getSelector().addItem(inputtedCallSheet);
                    close();

                }
            }
        });
        Button cancelButton = new Button("Cancel");
        cancelButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                close();
            }
        });

        HorizontalLayout callSheetRow = new HorizontalLayout(callSheet, CallSheetText);
        HorizontalLayout cnumRow = new HorizontalLayout(cnumsLabel, cnumText);
        HorizontalLayout buttonBar = new HorizontalLayout(saveButton, cancelButton);
        buttonBar.addStyleName("buttonBar");
        VerticalLayout layout = new VerticalLayout(callSheetRow, cnumRow, buttonBar);
        layout.setComponentAlignment(buttonBar, Alignment.BOTTOM_CENTER);
        layout.setComponentAlignment(callSheetRow, Alignment.BOTTOM_CENTER);
        layout.setComponentAlignment(cnumRow, Alignment.BOTTOM_CENTER);
        setContent(layout);
    }
}