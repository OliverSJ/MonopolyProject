// Programmer:  Oliver San Juan
// Assignment:  Monopoly Project
// Date:        October 10, 2015
// Description: This file will create an instance of the Player object.
//

public class Player
{
    //Data Dictionary
    private static final int NUM_OF_BOARD_POSITIONS = 40;       //Number of board positions

    private int wealth;                                         //The amount of money a player has
    private int playerPosition;                                 //The player's position on the board
    private String token;                                       //The player's token
    private boolean[] properties;                               //The player's properties, array
                                                                // is indexed via the board positions
    private String stringVal;                                   //String representation of all of 
                                                                //  the player's properties
    private int numOfRailroadsOwned;                            //The number of railroads the player
                                                                //  owns
    private int numOfUtilitiesOwned;                            //The number of utilities the player
                                                                //  owns


    public Player()
    //POST: A default Player object is contructed with moneyAmt set to 1500 (the starting amount of
    //      money for each player in the game), playerPosition set to 0, token set to 0, and 
    //      allocating the properties array
    {
        wealth = 1500;
        playerPosition = 0;
        token = " ";
        properties = new boolean[NUM_OF_BOARD_POSITIONS];
        stringVal = " ";
        numOfUtilitiesOwned = 0;
        numOfRailroadsOwned = 0;

    }

    public Player(String token)
    //PRE:  token >=0
    //POST: A Player object is constructed with private class member token being set to token
    {
        super();
        this.token = token;
    }

    public void movePosition(int diceValue)
    //PRE:  diceValue >=2 && diceValue <= 12 && diceValue is the sum of both dice in game
    //POST: The Player's position is updated by moving it ahead by the sum of the dice values
    {
        playerPosition += diceValue;
    }

    public boolean changeWealth(int changeValue)
    //PRE:  changeValue is initialized
    //POST: FCTVAL == true if the game should continue or false if it should not (player has become
    //      bankrupt)
    {  
        wealth += changeValue;

        return (wealth >= 0) ? true : false;
    }

    public boolean buyProperty(int cost, int propertyBoardPosition)
    //PRE:  cost > 0 && propertyBoardPosition > 0 && propertyBoardPosition <= 40 && the property on 
    //      propertyBoardPosition is not owned by another player
    //POST: properties is updated to indicate that the player owns the property on the board position
    //      FCTVAL == true if the purchase was successful, false if it was not
    {
        if((wealth - cost) > 0)         //If the person can afford it
        {   
            wealth -= cost;
            properties[propertyBoardPosition] = true;
            return true;
        }

        else
        {
            return false;
        }
    }

    public void addRailRoad()
    //POST: FCTVAL == private class member numOfRailroadsOwned is increased by one
    {
        numOfRailroadsOwned++;
    }

    public void addUtility()
    //POST: FCTVAL == private class member numOfUtilitiesOwned is increased by one
    {
        numOfUtilitiesOwned++;
    }

    public String getProperties(Property[] properties)
    //PRE:  properties is initialized
    //POST: FCTVAL == string representation of all of the Player's properties
    {               
        stringVal = " ";                  //Clear out stringVal from previous calls to getProperties

        //Iterator through all of the private class member array properties.  If any value is true,
        // use that index to look up the properties' name
        for(int i = 0; i < NUM_OF_BOARD_POSITIONS; ++i)
        {
            if(this.properties[i] == true && stringVal == " ")
            {
                stringVal += properties[i].name;
            }

            else if(this.properties[i] == true)      //If the player owns that property, then add it to             
            {                                        //  to stringVal

                stringVal += ", " + properties[i].name;
            }

        }

        return stringVal;
    }

    public String toString(Property[] properties)
    //PRE: properties is initialized
    //POST: FCTVAL == string representation of all of the Player object's attributes
    {
        stringVal = getProperties(properties);
        return "Player's Token:" + token + "\n" + "Player's Wealth: " + wealth + "\n" + 
                "Player's position: " + playerPosition + "\n" + 
                "Number of Railroads this player owns: " + numOfRailroadsOwned +
                "Number of utilities this player owns: " + numOfUtilitiesOwned + 
                "Properties owned by player: " + stringVal + "\n";

    }  

    public int getWealth()
    //POST: FCTVAL == private class member wealth
    {
        return wealth;
    }

    public int getPlayerPosition()
    //POST:  FCTVAL == private class member playerPosition
    {
        return playerPosition;
    }

    public String getToken()
    //POST: FCTVAL == private class member token
    {
        return token;
    }

    public int getNumOfRailRoads()
    //POST: FCTVAL == private class member numOfRailroadsOwned
    { 
        return numOfRailroadsOwned;
    }

    public int getNumOfUtilities()
    //POST: FCTVAL == private class member numOfUtilitiesOwned
    {
        return numOfUtilitiesOwned;
    }


}
