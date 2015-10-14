import java.util.Arrays;

//Programmer: Shagiya Mansuri
//Utilties Class

public class Utilities extends Property 
{
	
    public Utilities()
    //POST: A default Utilities object is created with address set to 0, name set to " ", price
    //         set to 0, and owner set to "bank"
    {
    	super(0, " ", 0); 
        owner = "bank";
    }
    
    public Utilities(int address, String name, int cost)
    //PRE:  address is >= 0, name is initialized, and cost >= 0
    //POST: A Utilities object is returned with class member address set to address, class member 
    //         owner set to name, class member price set to price, and owner set to "bank"
    {
    	super(address, name, cost);
        owner = "bank";
    }
    
    public int calcRent(Player p, int diceValue)
    //PRE:  Player p is initialized
    //      diceValue <= 12 and diceValue > 2
    //POST: The amount of rent is calculated depending the number of
    {
    	int rentAmt=0;
        if (p.getNumOfUtilities() == 1)                //Player owns 1 utility 
    	{
            rentAmt = 4 * diceValue;                   //Rent is 4 times diceValue
        }
        else if (p.getNumOfUtilities() == 2)           //Player owns 2 utilites
	{
            rentAmt = 10 * diceValue;                  //Rent is 10 times diceVAlue
        }

    	return rentAmt;                                //Return calculated rent
    }
    
    public boolean payRent(Player p, int diceVal)
    //PRE:  Player is initialized
    //      diceVal <= 12 and diceVal >= 2
    //POST: Check whether player owns Utility. If so, player pays rent.
    //		FCTVAL == true if player successfully paid rent, false otherwise.
    {
    	int rent;
    	
    	if (owner.equals(p.getToken()))                 //Player owns utility
    	{
    		rent = (-1) * calcRent(p, diceVal);     //Calculate rent
    		return p.changeWealth(rent);            //Charge rent and check if succesful transaction
    	}
    	
    	return false;                                   //Return false if player does not own utility
    }

    public boolean buy(Player p)
    {
        boolean successfulTransaction = super.buy(p);   //Player buys property

        if(successfulTransaction)                       //Player was able to buy property
        {
                p.addUtility();                         //Player owns the utility
                return true;                            //Buying was a success
        }

        return false;                                   //Buying failed
    }

    public String toString()
    //POST: FCVAL == returns string represention of object
    {
    	return super.toString();
    }
    
    /*Below This line Fayaz Khan*/
    
    public String[] getPossibleActions(Player player)
    {
    	String [] options = new String[20];
    	
    	Arrays.fill(options, ""); //fills it with blank spaces; 
    	
    	if(owner.equals("bank"))
    	{
    		options[0] = "Buy Property?";
    		options[1] = "Skip?";
    
    	}
    	
    	
    	return options;
    }

    
    
}