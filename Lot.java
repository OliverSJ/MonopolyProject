//Programmer:  Shagiya Mansuri
//Assignment:  Monopoly
//Date:        October 11, 2015
//Description: Lot class

import java.awt.Color;
import java.util.Arrays;

public class Lot extends Property
{
    private static final int HOUSE_HOTEL_COST  = 150;  //Cost of buying a hotel or a house
    private final Color color;                         //Color of lot
    private final int[] propertyRent;                  //Array of house and hotel rents
    private int numHouses;                             //Number of houses on lot
    private boolean hotelOnLot;                        //Hotel on lot status

    
    public Lot()
    //POST: A default Lot object is created with address set to 0, name set to " ", price set to 150,
    //         numHouses set to 0, hotelOnLot set to false, owner set to "bank", color set to white, 
    //         and an allocated array of propertyRent is created.
    {
    	super(0, " ", 150);
    	numHouses = 0;
    	hotelOnLot = false;
    	propertyRent = new int[6];
    	owner = "bank";
    	color = Color.WHITE;
    }
    
    public Lot(int address, String name, int cost, Color c, int[] rents)
    //PRE:  address >= 0, name is initialized, cost >= 0, and rents is initialized.
    //      propertyRent and rents should have the same length
    //POST: A Lot object is created with class member address set to address, class member 
    //         name set to name, class member price set to cost, numHouses set to 0, hotlOnLot
    //         set to false, color set to c, and an allocated array of propertyRent set to rents. 
    {
    	super(address, name, cost);
    	propertyRent = rents;	
    	numHouses = 0;
    	hotelOnLot = false;
    	owner = "bank";
    	color = c;
    }
    
    public boolean buyBuilding(Player p)
    //PRE:  Player is initialized. Player owns all lots of same color and is building evenly.
    //POST: Player is charged cost of property if player has enough money. numProperties 
    //      is updated according to the number of properties on the lot.
    //      FCTVAL == true if transaction was successful, false otherwise
    {    
    	boolean successfulTransaction;                  //Player has enough money status
    	int chargeCost;                                 //Amount to charge player
    	
    	if (hotelOnLot == true)                         //There is a hotel on property
    	{
    		return false;                           //Player cannot buy anymore property
    	}
    	else if (numHouses == 4)                        //Player already owns 4 houses
    	{
    		hotelOnLot = true;                      //Player can only buy hotel
    		numHouses = 0;                          //Player returns houses for a hotel
    	}
    	
    	chargeCost = (-1) * HOUSE_HOTEL_COST;   
    	successfulTransaction = p.changeWealth(chargeCost); //Player transaction status

        if(successfulTransaction)                       //Player was able to buy property
        {
        	if (hotelOnLot == false)                //Hotel was not bought, a house was bought
        	{
        		numHouses++;
        	}
        	
        	return true;                            //Buying was a success
        }

        return false;                                   //Buying was unsuccessful
    }
    
    public boolean payRent(Player p)
    //PRE:  Player p is initialized
    //POST: POST: Check whether player owns property. If so, player pays rent.
    //		FCTVAL == true if player successfully paid rent, false otherwise.
    {
    	int index;                                     //Index in propertyRent array
    	int rent;                                      //Rent player owes
    	
    	if(hotelOnLot == true)
    	{
    		index = 5;                             //Where rent for hotel is stored in array
    	}
    	else
    	{
    	    index = numHouses;                         //Index of house
    	}
    	
    	if (owner.equals(p.getToken()) && index >= 1)  //The player at least one property
    	{
    		rent = (-1) * calcRent(p, index);      //Calculate rent
    		return p.changeWealth(rent);           //Charge rent and return success
    	}
    	
    	return false;                                  //Unsuccessful, player does not own lot
    }

    public int calcRent(Player p, int index)
    //PRE:  Player p is initialized
    //POST: The amount of rent is calculated depending the number of houses or hotels player owns.
	//      FCTVL: Amount of rent the player owns.
    {
    	int rentAmt = propertyRent[index];             //Get rent for property
    	
    	return rentAmt;                                //Return calculated rent
    }
    
    public String toString()
    //POST: FCTVAL: String representation of object is returned.
    {
    	super.toString();
    	
    	return "Price of Lot: " + price + "Buying price of houses and hotel: "
    			+ HOUSE_HOTEL_COST + ". Number of houses on lot: " + numHouses +
    			". Hotel on lot: " + hotelOnLot + ". "; 
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
    	else
    	{
    										//Checking if all property purchased in color group
    										//	is not necessary according to piazza post
    		if(owner.equals(player.getToken()))
    		{  			
    			if(numHouses<4)
    				options[3] = "Buy House?";
    			else
    			{
    				if(!hotelOnLot)			//No Hotel on lot, has 4 houses 
    					options[4] = "Buy Hotel?";
    			}
    		}
    				
    	}
    	
    	
    	return options;
    }
}
