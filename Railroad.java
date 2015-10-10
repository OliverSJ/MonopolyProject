//Programmer: Shagiya Mansuri

public class Railroad extends Property
{
	
	public int rentAmt(Player p)
    //PRE:  Player p is initialized
    //POST: The amount of rent is calculated depending the number of railroads the player owns.
	//      FCTVL: Amount of rent the player owns.
    {
    	int rentAmt = 0;
    	
    	if(owner.equals(p.getToken()))
    	{
    		rentAmt = 4*p.getNumOfRailRoads();
    	}
    	
    	return rentAmt;
    }

}

