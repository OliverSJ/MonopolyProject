// Programmer:  Oliver San Juan
// Assignment:  Monopoly Project
// Date:        October 6, 2015
// Description: This file will create an instance of the Player object.
//

public class Player
{
    //Data Dictionary
    private static final int NUM_OF_BOARD_POSITIONS = 40;       //Number of board positions

    private int moneyAmt;                                       //The amount of money a player has
    private int playerPosition;                                 //The player's position on the board
    private int token;                                          //The player's token
    private boolean[] properties;                               //The player's properties, array
                                                                // is indexed via the board positions

    public Player()
    //POST: A default Player object is contructed with moneyAmt set to 1500 (the starting amount of
    //      money for each player in the game), playerPosition set to 0, token set to 0, and 
    //      allocating the properties array
    {
        moneyAmt = 1500;
        playerPosition = 0;
        token = 0;
        properties = new boolean[NUM_OF_BOARD_POSITIONS];

    }

    public Player(int token)
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

    public void addProperty(int propertyBoardPosition)
    //PRE:  propertyBoardPosition > 0 && propertyBoardPosition <= 40 && the property on 
    //      propertyBoardPosition is not owned by another player
    //POST: properties is updated to indicate that the player owns the property on the board position
    {
        properties[propertyBoardPosition] = true;
    }

    public boolean changeMoneyAmount(int changeValue)
    //PRE:
    //POST: 
    {  

    }





}