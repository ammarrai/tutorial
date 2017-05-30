package my.vaadin.domain;

import java.util.UUID;

public class Cnum {
    

    public Cnum()
    {
        super();
        
        id = UUID.randomUUID().toString();
    }
    
    public Cnum(
            final int value
    )
    {
        super();
        
        id = UUID.randomUUID().toString();
        cnum = value;
    }
    
    private String id;
    public final String getId() { return id; }
    public void setId( 
        final String value
    )
    {
            id = value;
    }
    

    private int cnum = 0;
    public int getCnum()
    {
        return cnum;
    }
    public void setCnum( final int value )
    {
        cnum = value;
    }
    public Cnum withCnum( final int value )
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
