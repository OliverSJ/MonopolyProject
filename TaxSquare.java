
public class TaxSquare extends Board
{
	public TaxSquare()
	{
		super(0,"");
	}

	public TaxSquare(int location, String name)
	{
		super(location, name);
	}
	
	
	public boolean payTax(Player player)
	{
		if(this.address==4)  		//Income Tax
			return player.changeWealth(-75);
		else						//Luxury Tax(38)
			return player.changeWealth(-200);
	}
	
	@Override
	public boolean payRent(Player p) {
		// TODO Auto-generated method stub
		return false;
	}
}
