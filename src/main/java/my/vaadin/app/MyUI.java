package my.vaadin.app;


import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.*;
import jdk.nashorn.internal.ir.CallNode;
import my.vaadin.domain.CallSheet;

import java.util.ArrayList;
import java.util.List;

@Theme("mytheme")
public class MyUI extends UI {


    BeanItemContainer<CallSheet> container;

    @Override
    protected void init(VaadinRequest vaadinRequest) {







        ComboBox selector = new ComboBox( "Call Sheets" );

        List<CallSheet> Callsheet = new ArrayList<>();


        CallSheet a = new CallSheet();
        a.setCallSheet("AA");
        Callsheet.add(a);
        selector.addItem(a);
        container = new BeanItemContainer<>(CallSheet.class);

        
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
                    callSheet.setCnum(20);
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
/*
    private void generateData()
    {
       CallSheet callSheet = new CallSheet();
       callSheet.setCallSheet( "A" );
       callSheet.setCnum(
               new Cnum( 10 )
       );
       container.addBean( callSheet );
    }
  */
    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}


