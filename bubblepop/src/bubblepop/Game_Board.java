package bubblepop;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Calendar;
import java.util.Random;

import javax.swing.JPanel;

class Game_Board extends JPanel{
	protected Game upper;
	private int width=0, height=0;
	final int ROW = 8, COL = 6, GAP = 5, MODULAR = 6;
	Random random = new Random();
	Calendar oCalendar = Calendar.getInstance( );
	private GridLayout gridLayout = new GridLayout(ROW, COL, GAP, GAP);
	boolean isItStart = false;
	
	GameObject gameObject[][] = new GameObject[ROW][COL];
	public static GameObject selectedObject;
	
	public static Game_Board j_p;
	public static Game_Info g_i;
	
	public static int pop_count;
	public static int[] obj_location;

    public Game_Board()
    {
    	
    }
	   
    public Game_Board(int width, int height) {
       this.width = width;
       this.height = height;
       this.getPreferredSize();//사이즈 설정
       this.setBackground(new Color(219,231,251));
       this.setLayout(new GridLayout(ROW, COL, GAP, GAP));
 
        //Create GameObject
       for(int row = 0; row < ROW; row++){
          for(int col = 0; col < COL; col++){
             gameObject[row][col] = new GameObject(row, col, this);
             this.add(gameObject[row][col]);
             gameObject[row][col].setImage(width/COL - GAP*2, height/ROW - GAP*2, 
                   random.nextInt(oCalendar.get(Calendar.SECOND)*oCalendar.get(Calendar.MILLISECOND))%MODULAR);
          }
       }
       //System.out.println(upper);
       while(this.Check() > 0);//터지는게 없을 때까지 반복 체크
    }	
   
	public Game_Board(int width, int height, Game upper){
		isItStart = false;
		this.upper = upper;
		this.width = width;
		this.height = height;
		this.getPreferredSize();//사이즈 설정
		this.setBackground(new Color(219,231,251));
		this.setLayout(new GridLayout(ROW, COL, GAP, GAP));
		upper.sound.startSound("bgm");
		j_p = this;
		
		//Create GameObject
		for(int row = 0; row < ROW; row++){
			for(int col = 0; col < COL; col++){
				gameObject[row][col] = new GameObject(row, col, this);
				this.add(gameObject[row][col]);
				gameObject[row][col].setImage(width/COL - GAP*2, height/ROW - GAP*2, 
						random.nextInt(oCalendar.get(Calendar.SECOND)*oCalendar.get(Calendar.MILLISECOND))%MODULAR);
			}
		}
		while(this.Check() > 0);//터지는게 없을 때까지 반복 체크
		while(true)
		{
			if(this.Check() <= 0) break;
			sleep(2000);
		}
		upper.game_info.set_game_score(0);
		isItStart = true;
		
	}
	
	@Override //패널 크기 지정
	public Dimension getPreferredSize(){
		return new Dimension(width, height);
	}
	

	//패널 전체 검사 후 스텍에 저장 -> 저장된 오브젝트의 이미지 변경
	public int Check(){
		GameObject checkedObject[] = new GameObject[ROW*COL*2];
		int checkNum = 0, pointer, counter = 0;
		
		//horizon check
		for(int row = 0; row < ROW; row++){
			pointer = 0;
			counter = 0;
			for(int col = 0; col < COL; col++){
				if(gameObject[row][pointer].imgNum != gameObject[row][col].imgNum){
					if(counter >= 2){
						for(int i = pointer; i < col; i++){
							checkedObject[checkNum++] = gameObject[row][i];
						}						
					}
					pointer = col;
					counter = 0;
				}
				else{
					counter++;
				}
			}//end of line
			//last image check
			if(counter >= 2){
				for(int i = pointer; i < COL; i++){
					checkedObject[checkNum++] = gameObject[row][i];
				}						
			}
		}//end of horizon
		
		//vertical check
		for(int col = 0; col < COL; col++){
			pointer = 0;
			counter = 0;
			for(int row = 0; row < ROW; row++){
				if(gameObject[pointer][col].imgNum != gameObject[row][col].imgNum){
					if(counter >= 2){
						for(int i = pointer; i < row; i++){
							checkedObject[checkNum++] = gameObject[i][col];
						}						
					}
					pointer = row;
					counter = 0;
				}
				else{
					counter++;
				}
			}//end of line
			//last image check
			if(counter >= 2){
				for(int i = pointer; i < ROW; i++){
					checkedObject[checkNum++] = gameObject[i][col];
				}						
			}
		}//end of vertical

		//label update - get Point
		if(upper != null)
		{
			upper.game_info.plus_game_score(checkNum * 10);
			upper.scoreLabel.setText(String.valueOf(upper.game_info.get_game_score()));
		}
		
		pop_count = checkNum;
		obj_location = new int[2*checkNum];		// 이게 터지는 위치고
		
		double[] temp = new double[2];
		
		//change
		for(int i = checkNum-1 ; i >= 0; i--){			
			int r = checkedObject[i].ROW, c = checkedObject[i].COL;
			
			if(isItStart == true)
			{
				
				temp=gameObject[r][c].getPosition();
				obj_location[2*i]=(int)temp[0];
				obj_location[2*i + 1]=(int)temp[1];
				
				//System.out.println(obj_location[2*i] + " " + obj_location[(2*i)+1]);
				System.out.println("temp =" +temp);
				
				System.out.println(" temp0"+obj_location[2*i] + " temp1" + obj_location[(2*i)+1]);
				//ReplaceObject(r, c, random.nextInt(oCalendar.get(Calendar.SECOND)*oCalendar.get(Calendar.MILLISECOND))%MODULAR, "GameObject");						
			}
		
			ReplaceObject(r, c, random.nextInt(oCalendar.get(Calendar.SECOND)*oCalendar.get(Calendar.MILLISECOND))%MODULAR, "GameObject");
		}
		
		Effects.main(null);		
		
		if(isItStart == true)
		{
			Effects.main(null);
		}

		return checkNum;
	}
	
	void ReplaceObject(int row, int col, int imgNum, String type){
		//if(isItStart == true)
			//gameObject[row][col].getPosition();
		this.remove(gameObject[row][col]);
		gameObject[row][col] = CreateObject(row, col, type);
		this.add(gameObject[row][col], row*COL + col);
		gameObject[row][col].setImage(width/COL - GAP*2, height/ROW - GAP*2, imgNum);

		System.gc();
	}
	
	GameObject CreateObject(int row, int col, String type){
		switch(type){
		case "GameObject":
			return new GameObject(row, col, this);
		case "RemoveSame":
			return new RemoveSame(row, col, this);
		case "RemoveVerticalLine":
			return new RemoveVerticalLine(row, col, this);
		case "RemoveHorizon":
			return new RemoveHorizon(row, col, this);
		case "CountUp":
			return new CountUp(row, col, this);
		}
		return null;
	}
	/**************/
	   //아이템 
	   public void itemAllreset()// 전체 리셋 아이템
	   {
	      for(int row = 0; row < ROW; row++){
	         for(int col = 0; col < COL; col++){
	            gameObject[row][col].setImage(width/COL - GAP*2, height/ROW - GAP*2, 
	                  random.nextInt(oCalendar.get(Calendar.SECOND)*oCalendar.get(Calendar.MILLISECOND))%MODULAR);
	         }
	      }
	      while(this.Check() > 0);//터지는게 없을 때까지 반복 체크
	      
	   }
	   public void itemChangeOne()
	   {
		   int ran_row = random.nextInt(8);
			int ran_col = random.nextInt(6);
			gameObject[ran_row][ran_col].setImage(width/COL - GAP*2, height/ROW - GAP*2, 
					random.nextInt(oCalendar.get(Calendar.SECOND)*oCalendar.get(Calendar.MILLISECOND))%MODULAR);
			upper.scoreLabel.setText(String.valueOf(upper.game_info.get_game_score()));
	   }
	   public void itemRemoveOne()
	   {
		   int rand = random.nextInt(6);
			int pulscnt=0;
			for(int i = 0; i< ROW ; i++)
			{
				for(int j = 0; j< COL ; j++)
				{
					if(gameObject[i][j].imgNum == rand)
					{
						gameObject[i][j].setImage(width/COL - GAP*2, height/ROW - GAP*2, 
								random.nextInt(oCalendar.get(Calendar.SECOND)*oCalendar.get(Calendar.MILLISECOND))%MODULAR);
						pulscnt++;
					}
				}
			}
			upper.game_info.plus_game_score(pulscnt*10);
			upper.scoreLabel.setText(String.valueOf(upper.game_info.get_game_score()));
	   }
	   public void itemBoom()
	   {
		   int ran_row = random.nextInt(6);
			int ran_col = random.nextInt(4);
			for(int i = 0; i< ran_row+3 ; i++)
			{
				for(int j = 0; j< ran_col+3 ; j++)
				{
					gameObject[i][j].setImage(width/COL - GAP*2, height/ROW - GAP*2, 
							random.nextInt(oCalendar.get(Calendar.SECOND)*oCalendar.get(Calendar.MILLISECOND))%MODULAR);
					
				}
			}
			upper.game_info.plus_game_score(90);
			upper.scoreLabel.setText(String.valueOf(upper.game_info.get_game_score()));
	   }   
	   
		public void sleep(int time){
		    try {
		      Thread.sleep(time);
		    } catch (InterruptedException e) { }
		}
	   /*****************/
}
