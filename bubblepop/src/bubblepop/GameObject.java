package bubblepop;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Calendar;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

//import bubblepop.GameObject.MyActionLitener;

class GameObject extends JButton{
	Game_Board upper;
	final int ROW, COL;
	public int imgNum;
	MyActionLitener litener;
   
	public GameObject(int row, int col, Game_Board upper){
	   this.upper = upper;
	   this.ROW = row;
	   this.COL = col;
	   litener = new MyActionLitener();
	   this.addActionListener(litener);
	}
   
	//이미지 주소 불러오기
	String selectImage(String mod, int imgNum){
		switch(mod){
		case "set":
			switch(imgNum){
			case 0:
				return "img/circle.png";
			case 1:
				return "img/triangle.png";
			case 2:
				return "img/square.png";
			case 3:
				return "img/star.png";
			case 4:
				return "img/diamond.png";
			case 5:
				return "img/hexagon.png";
			}
	   case "select":
		   switch(imgNum){
		   case 0:
			   return "img/selected_circle.png";
		   case 1:
			   return "img/selected_triangle.png";
		   case 2:
			   return "img/selected_square.png";
		   case 3:
			   return "img/selected_star.png";
		   case 4:
				return "img/selected_diamond.png";
		   case 5:
				return "img/selected_hexagon.png";
		   }
	   case "RemoveSame":
		   switch(imgNum){
			case 0:
				return "img/RemoveSame_circle.png";
			case 1:
				return "img/RemoveSame_triangle.png";
			case 2:
				return "img/RemoveSame_square.png";
			case 3:
				return "img/RemoveSame_star.png";
			case 4:
				return "img/RemoveSame_diamond.png";
			case 5:
				return "img/RemoveSame_hexagon.png";
			}
		}
		return "Fail";
	}
   
	//이미지 셋팅하기
	public void setImage(int width, int height, int imgNum){
		this.imgNum = imgNum;
		try {
			Image img = ImageIO.read(getClass().getResource(selectImage("set", imgNum)));
			this.setIcon(new ImageIcon(img.getScaledInstance(width,height,Image.SCALE_SMOOTH)));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//게임오브젝트 선택시 선택 이미지로 변경
	public void selectObject(){
		Game_Board.selectedObject = this;
		try {
			Image img = ImageIO.read(getClass().getResource(selectImage("select", imgNum)));
			this.setIcon(new ImageIcon(img.getScaledInstance(this.getIcon().getIconWidth(),
																this.getIcon().getIconHeight(),
																Image.SCALE_SMOOTH)));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
   
	//동서남북 체크 후 이동여부 결정
	public void moveObject(){
		GameObject selected = Game_Board.selectedObject;
		int N = this.ROW - 1;
		int S = this.ROW + 1;
		int W = this.COL - 1;
		int E = this.COL + 1;
		
		if((selected.ROW == N && selected.COL == this.COL) || (selected.ROW == S && selected.COL == this.COL) 
				|| (selected.ROW == this.ROW && selected.COL == W) || (selected.ROW == this.ROW && selected.COL == E)){
			int tmp = imgNum;
			setImage(selected.getIcon().getIconWidth(), selected.getIcon().getIconHeight(), selected.imgNum);
			selected.setImage(this.getIcon().getIconWidth(), this.getIcon().getIconHeight(), tmp);
			upper.upper.sound.startSound("move");
			upper.upper.game_info.minus_move_count(1);
			upper.upper.movecntLabel.setText(String.valueOf(upper.upper.game_info.get_move_count()));
		}
		else{
			selected.setImage(selected.getIcon().getIconWidth(), selected.getIcon().getIconHeight(), selected.imgNum);
			upper.upper.sound.startSound("click_error");
		}
		Game_Board.selectedObject = null;
		
		while(upper.Check() > 0){
			upper.ReplaceObject(ROW, COL, imgNum, "RemoveSame");
		};
		
		if(upper.upper.game_info.get_move_count() <= 0){
			upper.upper.Exit_Game();
		}
	}
   
	//버튼 클릭 이벤트
	class MyActionLitener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(upper.upper.game_info.get_move_count() > 0){
				if(Game_Board.selectedObject == null){
					upper.upper.sound.startSound("select");
					selectObject();
				}
				else{
					moveObject();
				}
			}	
		}
	}
}


class GameObject_Click extends GameObject{
	public GameObject_Click(int row, int col, Game_Board upper){
		super(row, col, upper);
	}
	
	void Sound(){
		upper.upper.sound.startSound("clickItem");
	}
}

class RemoveSame extends GameObject_Click{
	public RemoveSame(int row, int col, Game_Board upper){
		super(row, col, upper);
		this.removeActionListener(litener);
		litener = new MyActionLitener();
		this.addActionListener(litener);
	}
	
	@Override
	public void setImage(int width, int height, int imgNum){
		this.imgNum = imgNum;
		try {
			Image img = ImageIO.read(getClass().getResource(selectImage("RemoveSame", imgNum)));
			this.setIcon(new ImageIcon(img.getScaledInstance(width,height,Image.SCALE_SMOOTH)));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	void Sound(){
		upper.upper.sound.startSound("explode");
	}


	class MyActionLitener extends GameObject_Click.MyActionLitener{
		public void actionPerformed(ActionEvent e){
			if(Game_Board.selectedObject == null){
				Sound();
				
				int count = 0;
				for(int row = 0; row < upper.ROW; row++){
					for(int col = 0; col < upper.COL; col++){
						if(imgNum == upper.gameObject[row][col].imgNum){
							count++;
							if(row != ROW || col != COL){
								System.out.println(row + "/" + col);
								upper.ReplaceObject(row, col, upper.random.nextInt(upper.oCalendar.get(Calendar.SECOND)*upper.oCalendar.get(Calendar.MILLISECOND))%upper.MODULAR, "GameObject");
							}
						}
					}
				}
				upper.ReplaceObject(ROW, COL, upper.random.nextInt(upper.oCalendar.get(Calendar.SECOND)*upper.oCalendar.get(Calendar.MILLISECOND))%upper.MODULAR, "GameObject");
				upper.upper.game_info.plus_game_score(count * 10);
				upper.upper.scoreLabel.setText(String.valueOf(upper.upper.game_info.get_game_score()));
			}
			else{
				GameObject selected = Game_Board.selectedObject;
				selected.setImage(selected.getIcon().getIconWidth(), selected.getIcon().getIconHeight(), selected.imgNum);
				upper.upper.sound.startSound("click_error");
				Game_Board.selectedObject = null;
			}
			return;
		}
	}
}