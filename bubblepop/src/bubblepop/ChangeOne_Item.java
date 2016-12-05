package bubblepop;

//한개 바꾸기 외부 아이템
public class ChangeOne_Item extends Item
{
	private static String item_name = "한개 바꾸기";
	private static String item_ico = "ex_item/ChangeOne_ico.gif";
	private Game g;
	private Main m;
	private Game_Info game_info;
	
	public String get_item_name()
	{
		game_info = new Game_Info(m.level);
		//System.out.println(item_name);
		return item_name;
	}
	
	public String get_item_ico()
	{
		//System.out.println(item_ico);
		return item_ico;
	}
	
	public void item_use()
	{
		try{
			System.out.println(game_info.get_game_score());
			game_info.set_game_score(game_info.get_game_score()+10);
			j_p.itemChangeOne();
			
			while(j_p.Check()>0);
		}
		catch(NullPointerException e)
		{
			System.out.println("아이템 에러");
		}
		System.out.println("GhangeOne_Item_use");
	}
}
