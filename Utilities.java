//Programmer: Shagiya Mansuri

public class Utilities extends Property 
{
    public Utilities()
    //POST: A default Utilities object is created with...
    {
    	
    }
    
    //TODO: Finish the initializer constructor
    public Utilities(int address, String name)
    {
    	
    }
    
    public int rentAmt(Player p, int diceValue)
    //PRE:  Player p is initialized
    //      diceValue <= 12 and diceValue > 2
    //POST: The amount of rent is calculated depending the number of
    {
    	
    	if(owner.equals(p.getToken()))
    	{
    		rent = 4*p.getNumOfUtilities();
    	}
    	
    	return rent;
    }

    public     
}
