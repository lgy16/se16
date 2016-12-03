package bubblepop;

public class MoveCount3Add_Item extends Item 
{
	private static String item_name = "이동 횟수 3회 추가";
	private static String item_ico = "ex_item/MoveCount3Add_ico.gif";
	
	public MoveCount3Add_Item()
	{

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
		System.out.println("MoveCount3Add_Item_use");
	}
}
