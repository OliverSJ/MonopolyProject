//Programmer: Shagiya Mansuri
//Proprty class

public class Property extends Board
{
    protected int price;
    protected String owner;
    
    public Property()
    //POST: A default Property object is created with address set to 0, name set to null,
    //         owner set to null, rent set to 10, and price set to 150.
    {
    	super(0, "");
    	owner = "";
    	price = 150;
    }
    
    public Property(int address, String name, int cost)
    //PRE:  address is initialized and address >= 0
    //      cost >= 0
    //      name is initialized
    //POST: A Property object is created with class member address set to address, class member
    //         name set to null, price set to cost, and owner set to null
    {
    	super(address, name);
    	price = cost;
    	owner = "";	
    }
    
    //TODO: Player has to set property in array to true;
    public boolean buy(Player p)
    {
    	boolean canBuy;
    	
    	if (owner.equals(p.getToken()))		        //Owner is bank
    	{
    		canBuy = p.buyProperties(price, address); //Check if player has money to buy
    		
    		if(canBuy)                              //player has money
    		{
    		    owner = p.getToken();               //set token
    		    p.setProperties(address);           //player owns location
    		    return true;                        //successful buy
    		}
    	}
    	
    	return false;							//unsuccessful buy
    }
    
    //TODO: WHAT DO I DO WITH THIS METHOD?
    @Override
    public boolean payRent(Player p) 
    {
	return false;
    }
}

