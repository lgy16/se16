package bubblepop;

//외부아이템 부모클래스
public abstract class Item
{
	private static String item_name;
	private static String item_ico;
	
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
	
	public abstract void item_use();
}
