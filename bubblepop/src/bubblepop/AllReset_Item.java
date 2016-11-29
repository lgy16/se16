package bubblepop;

//전체 리셋 아이템
public class AllReset_Item extends Item
{
	private static String item_name = "전체 리셋";
	private static String item_ico = "ex_item/AllReset_ico.gif";
	
	public AllReset_Item()
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
		
	}
}
