package my.vaadin.domain;

import java.util.UUID;

public class Cnum {
    

    public Cnum()
    {

    }
    
    public Cnum(
            int value
    )
    {


        cnum = value;
    }
    
    private String id;
    public String getId() { return id; }
    public void setId( 
        String value
    )
    {
            id = value;
    }
    

    private int cnum = 0;
    public int getCnum()
    {
        return cnum;
    }
    public void setCnum(int value )
    {
        cnum = value;
    }
    public Cnum withCnum(int value )
    {
        cnum = value;
        return this;
    }
   
    @Override
    public String toString()
    {
        return Integer.toString( cnum );
    }
}
