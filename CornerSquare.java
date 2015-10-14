//Programmer: Fayaz Khan 
//comments to come 
public class CornerSquare extends Board
{
	public CornerSquare()
	{
		super(0,"");
	}

	
	public CornerSquare(int location, String name)
	{
		super(location, name);
	}
	
	public boolean goCorner(Player player)
	{							
									//Nothing happens with Jail and free parking
		if(this.address==0)  		//Go corner receives $200 
			return player.changeWealth(200);
		else
			return true; 
	}
	
	@Override
	public boolean payRent(Player p) {
		// TODO Auto-generated method stub
		return false;
	}
}
