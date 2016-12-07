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
	int ROW, COL;
	public int imgNum;
	MyActionLitener litener;
   
	public GameObject(int row, int col, Game_Board upper){
	   this.upper = upper;
	   this.ROW = row;
	   this.COL = col;
	   litener = new MyActionLitener();
	   this.addActionListener(litener);
	}
	
	double[] getPosition(){
		System.out.println(this.getLocationOnScreen().getX() + "/" + this.getLocationOnScreen().getY());
		
		double[] ob_location_info = new double[2];
		ob_location_info[0] = this.getLocationOnScreen().getX();
		ob_location_info[1] = this.getLocationOnScreen().getY();
		
		return ob_location_info;
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
	   case "RemoveVerticalLine":
		   return "img/RemoveVerticalLine.png";
	   case "RemoveHorizon":
		   return "img/RemoveHorizon.png";
	   case "set_CountUp":
		   switch(imgNum){
		   case 0:
				return "img/CountUp_circle.png";
			case 1:
				return "img/CountUp_triangle.png";
			case 2:
				return "img/CountUp_square.png";
			case 3:
				return "img/CountUp_star.png";
			case 4:
				return "img/CountUp_diamond.png";
			case 5:
				return "img/CountUp_hexagon.png";
		   }
	   case "select_CountUp":
		   switch(imgNum){
		   case 0:
				return "img/CountUp_selected_circle.png";
			case 1:
				return "img/CountUp_selected_triangle.png";
			case 2:
				return "img/CountUp_selected_square.png";
			case 3:
				return "img/CountUp_selected_star.png";
			case 4:
				return "img/CountUp_selected_diamond.png";
			case 5:
				return "img/CountUp_selected_hexagon.png";
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
		
			int this_ROW = this.ROW, this_COL = this.COL, selected_imgNum = Game_Board.selectedObject.imgNum;
			
			//move에서 선택된 것 -> select된 곳으로 이동
			upper.gameObject[selected.ROW][selected.COL] = upper.gameObject[this_ROW][this_COL];
			upper.gameObject[selected.ROW][selected.COL].ROW = selected.ROW;
			upper.gameObject[selected.ROW][selected.COL].COL = selected.COL;
			upper.add(upper.gameObject[selected.ROW][selected.COL], upper.gameObject[selected.ROW][selected.COL].ROW * upper.COL + upper.gameObject[selected.ROW][selected.COL].COL);
			
			//select에서 선택된 것 -> move된 곳으로 이동
			upper.gameObject[this_ROW][this_COL] = Game_Board.selectedObject;
			upper.gameObject[this_ROW][this_COL].ROW = this_ROW;
			upper.gameObject[this_ROW][this_COL].COL = this_COL;			
			upper.gameObject[this_ROW][this_COL].setImage(selected.getIcon().getIconWidth(), selected.getIcon().getIconHeight(), selected_imgNum);
			upper.add(upper.gameObject[this_ROW][this_COL], upper.gameObject[this_ROW][this_COL].ROW * upper.COL + upper.gameObject[this_ROW][this_COL].COL);
			
//			void ReplaceObject(int row, int col, int imgNum, String type){
//				this.remove(gameObject[row][col]);
//				gameObject[row][col] = CreateObject(row, col, type);
//				this.add(gameObject[row][col], row*COL + col);
//				gameObject[row][col].setImage(width/COL - GAP*2, height/ROW - GAP*2, imgNum);
//			}
			
//			setImage(selected.getIcon().getIconWidth(), selected.getIcon().getIconHeight(), selected.imgNum);
//			selected.setImage(this.getIcon().getIconWidth(), this.getIcon().getIconHeight(), empty);
			
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
			//바뀐게 있으면 오브젝트 하나를 아이템으로 변환
			String itmeType = "";
			int num = upper.random.nextInt(upper.oCalendar.get(Calendar.SECOND)*upper.oCalendar.get(Calendar.MILLISECOND)) % 6;
			switch(num){
			case 0:
			case 1:
				itmeType = "RemoveSame";
				break;
			case 2:
				itmeType = "RemoveVerticalLine";
				break;
			case 3:
				itmeType = "RemoveHorizon";
				break;
			case 4:
			case 5:
				itmeType = "CountUp";
				break;
			}
			upper.ReplaceObject(ROW, COL, imgNum, itmeType);
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
					//System.out.println(ROW + "/" + COL + "/" + imgNum);
					upper.upper.sound.startSound("select");
					selectObject();
				}
				else{
					//System.out.println(ROW + "/" + COL + "/" + imgNum);
					moveObject();
				}
			}	
		}
	}
}