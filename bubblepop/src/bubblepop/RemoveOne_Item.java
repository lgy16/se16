package bubblepop;

//�Ѱ� ����� �ܺ� ������
public class RemoveOne_Item extends Item
{
	private static String item_name = "�Ѱ� �����";
	private static String item_ico = "ex_item/RemoveOne_ico.gif";
	private Game g;
	private Main m;
	private Game_Info game_info;
	
	public RemoveOne_Item() {
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
		
		j_p.itemRemoveOne();
		
		while(j_p.Check()>0);
		System.out.println("RemoveOne_Item_use");
	}
}
