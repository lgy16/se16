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
	Game_Board upper;
	final int ROW, COL;
	public int imgNum;
   
	public GameObject(int row, int col, Game_Board upper){
	   this.upper = upper;
	   this.ROW = row;
	   this.COL = col;
	   this.addActionListener(new MyActionLitener());
	}
   
	//�̹��� �ּ� �ҷ�����
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
		}
		return "Fail";
	}
   
	//�̹��� �����ϱ�
	public void setImage(int width, int height, int imgNum){
		this.imgNum = imgNum;
		try {
			Image img = ImageIO.read(getClass().getResource(selectImage("set", imgNum)));
			this.setIcon(new ImageIcon(img.getScaledInstance(width,height,Image.SCALE_SMOOTH)));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//���ӿ�����Ʈ ���ý� ���� �̹����� ����
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
   
	//�������� üũ �� �̵����� ����
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
		
		while(upper.Check() > 0);
		
		if(upper.upper.game_info.get_move_count() <= 0){
			upper.upper.Exit_Game();
		}
	}
   
	//��ư Ŭ�� �̺�Ʈ
	private class MyActionLitener implements ActionListener{
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
	}
	class MyActionLitener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(Game_Board.selectedObject == null){
				int count = 0;
				Sound();
				for(int row = 0; row < ROW; row++){
					for(int col = 0; col < COL; col++){
						if(imgNum == upper.gameObject[row][col].imgNum){
							count++;
							if(row != ROW && col != COL){
								System.out.println(row + "/" + col);
							}
						}
					}
				}
			}
			else{
				moveObject();
			}
		}
	}
}