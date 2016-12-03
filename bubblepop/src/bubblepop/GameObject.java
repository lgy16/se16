package bubblepop;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

//import bubblepop.GameObject.MyActionLitener;

class GameObject extends JButton{
	private Game_Board upper;
	private final int ROW, COL;
	public int imgNum;
   
	public GameObject(int row, int col, Game_Board upper){
	   this.upper = upper;
	   this.ROW = row;
	   this.COL = col;
	   this.addActionListener(new MyActionLitener());
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
			upper.sound.startSound("sound/Up.wav",0);
		}
		else{
			selected.setImage(selected.getIcon().getIconWidth(), selected.getIcon().getIconHeight(), selected.imgNum);
			upper.sound.startSound("sound/Stun.wav",0);
		}
		Game_Board.selectedObject = null;
		
		while(upper.Check() == 0);
	}
   
	//버튼 클릭 이벤트
	private class MyActionLitener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(Game_Board.selectedObject == null){
				upper.sound.startSound("sound/Coin.wav",0);
				selectObject();
			}
			else{
				moveObject();
			}
		}
	}
}