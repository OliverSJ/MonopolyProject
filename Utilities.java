//Programmer: Shagiya Mansuri
//Utilties Class

public class Utilities extends Property 
{
	
    public Utilities()
    //POST: A default Utilities object is created with address set to 0, owner set to "" and price
    //         set to 0.
    {
    	super(0, "", 0); 
    }
    
    public Utilities(int address, String name, int cost)
    //PRE:  address is >= 0, name is initialized, and cost >= 0
    //POST: A Utilities object is returned with class member address set to address, class member 
    //         owner set to name, and class member price set to price.
    {
    	super(address, name, cost);
    }
    
    public int calcRent(Player p, int diceValue)
    //PRE:  Player p is initialized
    //      diceValue <= 12 and diceValue > 2
    //POST: The amount of rent is calculated depending the number of
    {
    	int rentAmt = 0;
    	
    	if(owner.equals(p.getToken()))
    	{
    		rentAmt = 4*p.getNumOfUtilities();
    	}
    	
    	return rentAmt;
    }
    
    public boolean payRent(Player p, int diceVal)
    //PRE:  Player is initialized
    //      diceVal <= 12 and diceVal >= 2
    //POST: Check whether player owns Utility. If so, player pays rent.
    //		FCTVAL == true if player successfully paid rent, false otherwise.
    {
    	int rent;
    	
    	if (owner.equals(p.getToken()))
    	{
    		rent = calcRent(p, diceVal);
    		return p.changeWealth(rent);
    	}
    	
    	return false;
    }
}


