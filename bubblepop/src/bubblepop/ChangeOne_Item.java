package bubblepop;

//�Ѱ� �ٲٱ� �ܺ� ������
public class ChangeOne_Item extends Item
{
	private static String item_name = "�Ѱ� �ٲٱ�";
	private static String item_ico = "ex_item/ChangeOne_ico.gif";
	
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
		try{
			j_p.itemChangeOne();
		}
		catch(NullPointerException e)
		{
			System.out.println("������ ����");
		}
		System.out.println("GhangeOne_Item_use");
	}
}
