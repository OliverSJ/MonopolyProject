//Programmer: Shagiya Mansuri
//Railroad Class

public class Railroad extends Property
{
	
    public Railroad()
    //POST: A default Railroad object is created with address set to 0, name  set to " ", price
    //         set to 0, and owner set to bank
    {
    	super(0, " ", 0); 
        owner = "bank";
    }
	
    public Railroad(int address, String name, int cost) 
    //PRE:  address is >= 0, name is initialized, and cost >= 0
    //POST: A Railroad object is returned with class member address set to address, class member 
    //         name set to name, class member price set to price, and owner set to "bank"
    {
	super(address, name, cost);
        owner = "bank";
    }

    public int calcRent(Player p)
    //PRE:  Player p is initialized
    //POST: The amount of rent is calculated depending the number of railroads the player owns.
    //      FCTVL: Amount of rent the player owns.
    {
    	int rentAmt = 25 * p.getNumOfRailRoads();             //Rent is $25 per railroads owned
    	
    	return rentAmt;
    }
	
    public boolean payRent(Player p)
    //PRE:  Player is initialized
    //POST: Check whether player owns RailRoad. If so, player pays rent.
    //		FCTVAL == true if player successfully paid rent, false otherwise.
    {
    	int rent;                                             //Rent cost
    	
    	if (owner.equals(p.getToken()))                       //Player owns railroad 
    	{
    	    rent = (-1) * calcRent(p);                        //Calculate rent player owns
    	    return p.changeWealth(rent);                      //Return if transaction was successful
    	}
    	
    	return false;                                         //Player is not owner, can not pay rent
    }

    public boolean buy(Player p)
    {
	boolean successfulTransaction = super.buy(p);         //Player buys property
		
	if(successfulTransaction)                             //Player was able to buy property
	{
		p.addRailRoad();                              //Player owns the railroad 
		return true;                                  //Buying was a success
	}
		
	return false;	                                      //Buying failed
    }
   
    public String toString()
    //POST: FCTVAL == returns string representation of object
    {
	return super.toString();
    }
}


