//Fayaz Khan 
//comments to come 

public class CardSquare extends Board
{
	public CardSquare()
	{
		super(0,"");
	}

	public CardSquare(int location, String name)
	{
		super(location, name);
	}
	
	public boolean gamble(Player player)
	{
		int amount = (-200) + (int)(Math.random() * ((200-(-200)+1)));
		
		return player.changeWealth(amount);
		
	}
	
	@Override
	public boolean payRent(Player p) {
		// TODO Auto-generated method stub
		return false;
	}
}
