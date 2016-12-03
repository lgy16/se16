package bubblepop;

//한개 바꾸기 외부 아이템
public class ChangeOne_Item extends Item
{
	private static String item_name = "한개 바꾸기";
	private static String item_ico = "ex_item/ChangeOne_ico.gif";
	
	public ChangeOne_Item()
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
		System.out.println("GhangeOne_Item_use");
	}
}
