//Programmer: Shagiya Mansuri
//Board Class

public abstract class Board 
{
    protected final int address;
    protected final String name;
    
    public Board()
    //POST: A default Board object is created with address set to 0 and name set to " ".
    {
        address = 0;
        name = " ";
    }
    
    public Board(int address, String name)
    //PRE:  address is initialized and address >=0
    //      name is initialized
    //POST: A Board object is created with class member address set to address and class 
    //      member name set to name.
    {
    	this.address = address;
    	this.name = name;
    }

    public abstract boolean payRent(Player p);
}

