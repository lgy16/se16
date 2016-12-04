package bubblepop;

public class Game_Info {
	
	private String game_level;
	private int game_score;
	int move_count;
	
	public Game_Info(String level)
	{
		game_level = level;
		game_score = 0;
		if(level == "»ó") move_count = 20;
		else if(level == "Áß") move_count = 30;
		else if(level == "ÇÏ") move_count = 40;
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
		game_score = score;
	}
	
	public void plus_game_score(int score)
	{
		game_score += score;
	}

	public int get_move_count()
	{
		return move_count;
	}
	
	public void set_move_count(int count)
	{
		move_count = count;
	}
	
	public void plus_move_count(int move)
	{
		move_count += move;
	}
	
	public void minus_move_count(int move)
	{
		move_count -= move;
	}
}
