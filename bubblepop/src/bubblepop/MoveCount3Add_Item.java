package bubblepop;

public class MoveCount3Add_Item extends Item 
{
	private static String item_name = "이동 횟수 3회 추가";
	private static String item_ico = "ex_item/MoveCount3Add_ico.gif";
	private Game g;
	private Main m;
	private Game_Info game_info;
	int plus3=0;
	
	public MoveCount3Add_Item() {
		game_info = new Game_Info(m.level);
		// TODO Auto-generated constructor stub
	}

	public String get_item_name()
	{
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
		
		//System.out.println(plus3);
		plus3 = game_info.get_move_count();
		System.out.println(plus3);
		plus3 = plus3+3;
		System.out.println(plus3);
		game_info.set_move_count(game_info.get_move_count()+3);
		System.out.println("MoveCount3Add_Item_use");
	}
}