package my.vaadin.domain;
import java.util.UUID;

public class CallSheet {

    public CallSheet()
    {
         id = UUID.randomUUID().toString();
    }
    
    private String id;
    public String getId() { return id; }
    public void setId( 
        final String value
    )
    {
            id = value;
    }
  

    private String callSheet;
    public String getCallSheet()
    {
        return callSheet;
    }
    public void setCallSheet(String callSheet) {
        this.callSheet = callSheet;
    }
    

    private int cnum;

    public int getCnum() {
        return cnum;
    }
    public void setCnum(int cnum) {
        this.cnum = cnum;
    }
}

