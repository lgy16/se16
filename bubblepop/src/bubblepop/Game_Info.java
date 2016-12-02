package bubblepop;

public class Game_Info {
	
	private String game_level;
	private int game_score;
	int move_count;
	
	public Game_Info(String level)
	{
		game_level = level;
		game_score = 0;
		if(level == "상") move_count = 30;
		else if(level == "중") move_count = 40;
		else if(level == "하") move_count = 50;
	}
	
	public String get_game_level()
	{
		return game_level;
	}
	
	/*
	public void set_game_level(String level)
	{
		game_level=level;
	}
	*/
	
	public int get_game_score()
	{
		return game_score;
	}
	
	public void set_game_score(int score)
	{
		game_score =+ score;
	}
	
	public int use_move_count()
	{
		return --move_count;	//0을 리턴하면 게임 종료
	}
	
	public int get_move_count()
	{
		return move_count;
	}
}
