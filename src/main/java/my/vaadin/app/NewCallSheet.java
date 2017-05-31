package my.vaadin.app;

import com.vaadin.ui.Button;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

import javax.xml.soap.Text;

/**
 * Created by markrai on 5/31/2017.
 */
public class NewCallSheet extends Window {

    public NewCallSheet() {
        setModal(true);


        TextField cnumText = new TextField();
        TextField CallSheetText = new TextField();
        Button saveButton = new Button("Save");
        Button cancelButton = new Button("Cancel");

        VerticalLayout content = new VerticalLayout(cnumText, CallSheetText, saveButton, cancelButton);

content.addComponent(cnumText);
content.addComponent(CallSheetText);
content.addComponent(saveButton);
content.addComponent(cancelButton);

        setContent(content);

    }
}
