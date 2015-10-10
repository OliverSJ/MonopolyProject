//Programmer: Shagiya Mansuri

public class Property extends Board
{
    protected final int price;
    protected int rent;
    protected String owner;
    
    public Property()
    //POST: A default Property object is created with address set to 0, name set to null,
    //         owner set to null, rent set to 10, and price set to 150.
    {
    	super(0, "");
    	owner = "";
    	rent = 10;
    	price = 150;
    }
    
    public Property(int address, String name, int cost, int rentAmt)
    //PRE:  address is initialized and address >= 0
    //      cost and rentAmt >= 0
    //      name is initialized
    //POST: A Property object is created with class member address set to address, class member
    //         name set to null, price set to cost, rent set to rentAmt and owner set to null
    {
    	super(address, name);
    	price = cost;
    	rent = rentAmt;
    	owner = "";	
    }
    
    public void buyProperty(Player p)
    {
        if(owner.equals(p.getToken())
        {
            
        }    	
    }
    
    public boolean payRent(Player p)
    {
    	if (!owner.equals(p.getToken()))
    	{	
    	    p.chargeRent(rent);
    	}
    	
    	return false;
    }

}

