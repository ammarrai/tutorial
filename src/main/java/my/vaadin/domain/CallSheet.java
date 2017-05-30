package my.vaadin.domain;
import java.util.UUID;

public class CallSheet {

    public CallSheet()
    {
        super();
        
        id = UUID.randomUUID().toString();
    }
    
    private String id;
    public final String getId() { return id; }
    public void setId( 
        final String value
    )
    {
            id = value;
    }
  

    private String callSheet = "";
    public String getCallSheet()
    {
        return callSheet;
    }
    public void setCallSheet(String callSheet) {
        this.callSheet = callSheet;
    }
    

    private Cnum cnum;
    public Cnum getCnum()
    {
        return cnum;
    }
    public void setCnum( final Cnum value )
    {
        cnum = value;
    }
}

