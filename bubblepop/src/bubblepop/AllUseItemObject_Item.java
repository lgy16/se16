package bubblepop;

//�Ѱ� ����� �ܺ� ������
public class AllUseItemObject_Item extends Item
{
	private static String item_name = "��� ������ ������Ʈ ��Ʈ����";
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
		System.out.println("AllUseItemObject_Item_use");
	}
}
