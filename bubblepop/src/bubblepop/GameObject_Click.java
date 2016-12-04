package bubblepop;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.Calendar;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

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
								upper.ReplaceObject(row, col, upper.random.nextInt(upper.oCalendar.get(Calendar.SECOND)*upper.oCalendar.get(Calendar.MILLISECOND))%upper.MODULAR, "GameObject");
							}
						}
					}
				}
				//자기자신이 변하면 그 뒤로 터지는 이미지가 바뀜 그러니 자기자신은 제일 마지막에 바꿈.
				upper.ReplaceObject(ROW, COL, upper.random.nextInt(upper.oCalendar.get(Calendar.SECOND)*upper.oCalendar.get(Calendar.MILLISECOND))%upper.MODULAR, "GameObject");
				
				//점수갱신
				upper.upper.game_info.plus_game_score(count * 10);
				upper.upper.scoreLabel.setText(String.valueOf(upper.upper.game_info.get_game_score()));
			}
			else{
				GameObject selected = Game_Board.selectedObject;
				selected.setImage(selected.getIcon().getIconWidth(), selected.getIcon().getIconHeight(), selected.imgNum);
				upper.upper.sound.startSound("click_error");
				Game_Board.selectedObject = null;
			}
			while(upper.Check() > 0);
		}
	}
}

class RemoveVerticalLine extends GameObject_Click{
	public RemoveVerticalLine(int row, int col, Game_Board upper){
		super(row, col, upper);
		this.removeActionListener(litener);
		litener = new MyActionLitener();
		this.addActionListener(litener);
	}
	
	@Override
	public void setImage(int width, int height, int imgNum){
		this.imgNum = -1;
		try {
			Image img = ImageIO.read(getClass().getResource(selectImage("RemoveVerticalLine", -1)));
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
				
				for(int row = 0; row < upper.ROW; row++){
					upper.ReplaceObject(row, COL, upper.random.nextInt(upper.oCalendar.get(Calendar.SECOND)*upper.oCalendar.get(Calendar.MILLISECOND))%upper.MODULAR, "GameObject");
				}
				
				upper.upper.game_info.plus_game_score(upper.COL * 10);
				upper.upper.scoreLabel.setText(String.valueOf(upper.upper.game_info.get_game_score()));
			}
			else{
				GameObject selected = Game_Board.selectedObject;
				selected.setImage(selected.getIcon().getIconWidth(), selected.getIcon().getIconHeight(), selected.imgNum);
				upper.upper.sound.startSound("click_error");
				Game_Board.selectedObject = null;
			}
			while(upper.Check() > 0);
		}
	}
}

class RemoveHorizon extends GameObject_Click{
	public RemoveHorizon(int row, int col, Game_Board upper){
		super(row, col, upper);
		this.removeActionListener(litener);
		litener = new MyActionLitener();
		this.addActionListener(litener);
	}
	
	@Override
	public void setImage(int width, int height, int imgNum){
		this.imgNum = -2;
		try {
			Image img = ImageIO.read(getClass().getResource(selectImage("RemoveHorizon", -2)));
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
				
				for(int col = 0; col < upper.COL; col++){
					upper.ReplaceObject(ROW, col, upper.random.nextInt(upper.oCalendar.get(Calendar.SECOND)*upper.oCalendar.get(Calendar.MILLISECOND))%upper.MODULAR, "GameObject");
				}
				
				upper.upper.game_info.plus_game_score(upper.ROW * 10);
				upper.upper.scoreLabel.setText(String.valueOf(upper.upper.game_info.get_game_score()));
			}
			else{
				GameObject selected = Game_Board.selectedObject;
				selected.setImage(selected.getIcon().getIconWidth(), selected.getIcon().getIconHeight(), selected.imgNum);
				upper.upper.sound.startSound("click_error");
				Game_Board.selectedObject = null;
			}
			while(upper.Check() > 0);
		}
	}
}