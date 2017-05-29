package my.vaadin.domain;

import java.util.UUID;

/**
 *
 * @author ammar
 */
public class Cnum {
    
    /**
     * 
     */
    public Cnum()
    {
        super();
        
        id = UUID.randomUUID().toString();
    }
    
    /**
     * 
     * @param _value
     */
    public Cnum(
            final int _value
    )
    {
        super();
        
        id = UUID.randomUUID().toString();
        cnum = _value;
    }
    
    private String id;
    public final String getId() { return id; }
    public void setId( 
        final String _value 
    )
    {
            id = _value;
    }
    
    /**
     * 
     */
    private int cnum = 0;
    public int getCnum()
    {
        return cnum;
    }
    public void setCnum( final int _value )
    {
        cnum = _value;
    }
    public Cnum withCnum( final int _value )
    {
        cnum = _value;
        return this;
    }
   
    @Override
    public String toString()
    {
        return Integer.toString( cnum );
    }
}
