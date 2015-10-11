//Programmer: Shagiya Mansuri
//Proprty class

public class Property extends Board
{
    protected int price;                                 //Buying price of property
    protected String owner;                              //Owner of property
    
    public Property()
    //POST: A default Property object is created with address set to 0, name set to " ",
    //         owner set to "bank", rent set to 10, and price set to 150.
    {
    	super(0, " ");
    	owner = "bank";
    	price = 150;
    }
     
    public Property(int address, String name, int cost)
    //PRE:  address is initialized and address >= 0
    //      cost >= 0
    //      name is initialized
    //POST: A Property object is created  with class member address set to address, class member
    //         name set to name, price set to cost, and owner set to "bank".
    {
    	super(address, name);
    	price = cost;
    	owner = "bank";	
    }
    
    public boolean buy(Player p)
    {
    	boolean canBuy;                                  //Boolean for if player has money to buy
    	
    	if (owner.equals(p.getToken()))		         //Owner is bank
    	{
    		canBuy = p.buyProperties(price, address); //Check if player has money to buy
    		
    		if(canBuy)                               //Player has money to buy property
    		{
    		    owner = p.getToken();                //Set owner to player token
    		    return true;                         //Successful buy
    		}
    	}
    	
    	return false;					 //Unsuccessful buy
    }
    
    //TODO: WHAT DO I DO WITH THIS METHOD?
    @Override
    public boolean payRent(Player p) 
    {
	return false;
    }

    public String toString()
    //POST: FCTVAL == reutrns string repersentation of object
    {
	return super.toString() + "Owner: " + owner + ". Price: " + price + ". ";
    }
}

