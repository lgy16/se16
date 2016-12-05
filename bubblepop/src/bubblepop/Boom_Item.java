package bubblepop;

//한개 지우기 외부 아이템
public class Boom_Item extends Item
{
	private static String item_name = "모든 아이템 오브젝트 터트리기";
	private static String item_ico = "ex_item/AllUseItemObject_ico.gif";
	
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
		j_p.itemBoom();
		
		while(j_p.Check()>0);
		System.out.println("AllUseItemObject_Item_use");
	}
}
