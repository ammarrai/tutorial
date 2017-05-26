package my.vaadin.app;

import java.util.List;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.data.Property;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.*;

/**
 * This UI is the application entry point. A UI may either represent a browser window
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class MyUI extends UI {

    TextField testField = new TextField();
    ComboBox testBox = new ComboBox();


    @Override
    protected void init(VaadinRequest vaadinRequest) {
        final VerticalLayout layout = new VerticalLayout();
        setContent(layout);

        Label testLabel = new Label();


        testBox.addValueChangeListener(new Property.ValueChangeListener() {
            @Override
            public void valueChange(Property.ValueChangeEvent valueChangeEvent) {
                Notification.show("CHANGED");
            }
        });


        testLabel.setValue("My new label");
        testLabel.setValue("another label!");
        testField.setValue("my test field");

        testBox.addItem("item1");
        testBox.addItem("item2");
        testBox.addItem("item3");
        testBox.addItem("item4");

        layout.addComponent(testLabel);
        layout.addComponent(testField);
        layout.addComponent(testBox);
        layout.addComponent(testField);


        HorizontalLayout hLayout = new HorizontalLayout();
        Label label2 = new Label("Another test label: ");
        label2.setWidth("200px");
        hLayout.addComponent(label2);
        TextField field2 = new TextField();


        TextField field3 = new TextField();  //Really long text field
        field3.setHeight("600px");
        //hLayout.addComponent(field3);

        hLayout.addComponent(field2);
        layout.addComponent(hLayout);
        label2.setValue("2");




    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}


