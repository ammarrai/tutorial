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

@Theme("mytheme")
public class MyUI extends UI {

    private BeanItemContainer<CallSheet> container;
    /**
     * 
     * @param vaadinRequest 
     */
    @Override
    protected void init(VaadinRequest vaadinRequest) {

        final ComboBox selector = new ComboBox( "Call Sheets" );

        container = new BeanItemContainer<>(CallSheet.class);
        generateData();
        
        final Grid cnumGrid = new Grid( container );
        cnumGrid.removeColumn("id");
        cnumGrid.removeColumn("callSheet");
        
//        cnumGrid.setEditorEnabled(true);
        
        final Button saveButton = new Button(
            "Save"
            ,event ->
                {
                    Notification.show("Save button clicked");
                }
        );
        final Button cancelButton = new Button( "Cancel", FontAwesome.TRASH );
                cancelButton.addClickListener(
                        event ->
                        {
                            
                        }
                );
        
        final Button newButton = new Button(
                "New"
                ,event ->
                {
                    final CallSheet callSheet = new CallSheet();
                    callSheet.setCallSheet("A");
                    callSheet.setCnum(new Cnum( 20 ));
                    container.addBean( callSheet );
                }
        );
        
        final HorizontalLayout buttonBar = new HorizontalLayout(
                saveButton
                ,cancelButton
                ,newButton
        );

        final VerticalLayout layout = new VerticalLayout(
            selector
                ,cnumGrid
                ,buttonBar
        );
        setContent(layout);





    }

    private void generateData()
    {
       final CallSheet callSheet = new CallSheet();
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


