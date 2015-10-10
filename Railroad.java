//Programmer: Shagiya Mansuri
//Railroad Class

public class Railroad extends Property
{
	
    public Railroad()
    //POST: A default Railroad object is created with address set to 0, owner set to "" and price
    //         set to 0.
    {
    	super(0, "", 0); 
    }
	
    public Railroad(int address, String name, int cost) 
    //PRE:  address is >= 0, name is initialized, and cost >= 0
    //POST: A Railroad object is returned with class member address set to address, class member 
    //         owner set to name, and class member price set to price.
    {
	super(address, name, cost);
    }

    public int calcRent(Player p)
    //PRE:  Player p is initialized
    //POST: The amount of rent is calculated depending the number of railroads the player owns.
    //      FCTVL: Amount of rent the player owns.
    {
    	int rentAmt = 0;
    	
    	if(owner.equals(p.getToken()))
    	{
    		rentAmt = 25 * p.getNumOfRailRoads();
    	}
    	
    	return rentAmt;
    }
	
    public boolean payRent(Player p)
    //PRE:  Player is initialized
    //POST: Check whether player owns RailRoad. If so, player pays rent.
    //		FCTVAL == true if player successfully paid rent, false otherwise.
    {
    	int rent;
    	
    	if (!owner.equals(p.getToken()))
    	{
    	    rent = calcRent(p);
    	    return p.changeWealth(rent);
    	}
    	
    	return false;
    }

}


