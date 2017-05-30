package my.vaadin.app;


import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.*;
import my.vaadin.domain.CallSheet;
import my.vaadin.domain.Cnum;

import java.util.ArrayList;
import java.util.List;

@Theme("mytheme")
public class MyUI extends UI {


    BeanItemContainer<CallSheet> container;

    @Override
    protected void init(VaadinRequest vaadinRequest) {

        List<CallSheet> cnums = new ArrayList<>();

        ComboBox selector = new ComboBox( "Call Sheets" );

        container = new BeanItemContainer<>(CallSheet.class);
        generateData();
        
        TextField cnumText = new TextField();

        Button saveButton = new Button(
            "Save"
            ,event ->
                {
                    Notification.show("Save button clicked");
                }
        );
        saveButton.addStyleName("mynewclass");

        Button cancelButton = new Button( "Cancel");
                cancelButton.addClickListener(
                        event ->
                        {
                            
                        }
                );
        cancelButton.addStyleName("mynewclass");

        Button newButton = new Button(
                "New Callsheet"
                ,event ->
                {
                    CallSheet callSheet = new CallSheet();
                    callSheet.setCallSheet("A");
                    callSheet.setCnum(new Cnum( 20 ));
                    container.addBean( callSheet );
                }
        );
        newButton.addStyleName("mynewclass");

        HorizontalLayout buttonBar = new HorizontalLayout(
                saveButton
                ,cancelButton
                ,newButton
        );

        VerticalLayout layout = new VerticalLayout(
            selector
                ,cnumText
                ,buttonBar
        );
        setContent(layout);





    }

    private void generateData()
    {
       CallSheet callSheet = new CallSheet();
       callSheet.setCallSheet( "A" );
       callSheet.setCnum(
               new Cnum( 10 )
       );
       container.addBean( callSheet );
    }
    
    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}


