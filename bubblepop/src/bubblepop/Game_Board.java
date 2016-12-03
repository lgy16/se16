package bubblepop;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Calendar;
import java.util.Random;

import javax.swing.JPanel;

class Game_Board extends JPanel{
	protected Game upper;
	private final int width, height;
	private final int ROW = 8, COL = 6, GAP = 5, MODULAR = 6;
	private Random random = new Random();
	private Calendar oCalendar = Calendar.getInstance( );
	
	private GameObject gameObject[][] = new GameObject[ROW][COL];
	public static GameObject selectedObject;
   
	public Game_Board(int width, int height, Game upper){
		this.upper = upper;
		this.width = width;
		this.height = height;
		this.getPreferredSize();//사이즈 설정
		this.setBackground(new Color(219,231,251));
		this.setLayout(new GridLayout(ROW, COL, GAP, GAP));
		upper.sound.startSound("bgm");
		
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
	}
	
	@Override //패널 크기 지정
	public Dimension getPreferredSize(){
		return new Dimension(width, height);
	}

	//패널 전체 검사 후 스텍에 저장 -> 저장된 오브젝트의 이미지 변경
	public int Check(){
		GameObject checkedObject[] = new GameObject[ROW*COL];
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

		//label update
		upper.game_info.plus_game_score(checkNum * 10);
		upper.scoreLabel.setText(String.valueOf(upper.game_info.get_game_score()));
		
		//change
		for(int i = checkNum-1 ; i >= 0; i--){
			checkedObject[i].setImage(width/COL - GAP*2, height/ROW - GAP*2,
					random.nextInt(oCalendar.get(Calendar.SECOND)*oCalendar.get(Calendar.MILLISECOND))%MODULAR);
		}
		
		return checkNum;
	}
}
