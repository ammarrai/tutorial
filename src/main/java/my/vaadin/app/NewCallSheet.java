package my.vaadin.app;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

import javax.xml.soap.Text;

/**
 * Created by markrai on 5/31/2017.
 */
public class NewCallSheet extends Window {


    public NewCallSheet() {
        super("Add New CallSheet");
        Label callSheet = new Label("CallSheet");
        Label cnumsLabel = new Label("CNUMS");
        TextField cnumText = new TextField();
        TextField CallSheetText = new TextField();
        Button saveButton = new Button("Add");
        saveButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {

            }
        });
        Button cancelButton = new Button("Cancel");

        VerticalLayout content = new VerticalLayout(callSheet, CallSheetText, cnumsLabel, cnumText, saveButton, cancelButton);

        setContent(content);
    }
}
