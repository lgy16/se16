package bubblepop;

import javax.swing.ImageIcon;

class Item_list
{
	private int how_many_items = 5;		//외부아이템 클래스 개수 (현재4개)
	private Item[] item_list = new Item[how_many_items];
	public ImageIcon[] item_icon = new ImageIcon[how_many_items];
	public String[] item_name = new String[how_many_items];
	private Boolean[] item_selected = new Boolean[how_many_items];
	
	public Item_list()
	{
		item_list[0] = new RemoveOne_Item();
		item_list[1] = new AllReset_Item();
		item_list[2] = new ChangeOne_Item();
		item_list[3] = new AllUseItemObject_Item();
		item_list[4] = new MoveCount3Add_Item();
	
		for(int i=0; i<how_many_items; i++)
		{
			item_icon[i] = new ImageIcon(getClass().getResource(item_list[i].get_item_ico()));
			item_name[i] = item_list[i].get_item_name();
			item_selected[i] = false;
		}
	}
	
	public void reset_state()
	{
		for(int i=0; i<how_many_items; i++)
		{
			item_selected[i]=false;
		}
	}
	
	public void set_seelcted(int number, Boolean state)
	{
		item_selected[number] = state;
	}
	
	public Boolean get_selected(int number)
	{
		
		return item_selected[number];
	}
	
	public Item get_item(int index)
	{
		return item_list[index];
	}
}
