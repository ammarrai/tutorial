package my.vaadin.app;

import com.vaadin.ui.Button;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Window;

/**
 * Created by markrai on 5/31/2017.
 */
public class NewCallSheet extends Window {

    public NewCallSheet() {
        setModal(true);

        TextField cnumText = new TextField();
        TextField CallSheetText = new TextField();


        Button saveButton = new Button("Save");
        //saveButton.addClickListener(new Button.ClickListener() {}
        //cancelButton.addClickListener(new Button.ClickListener() {}
    }
}
