package bubblepop;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.Calendar;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;


class GameObject_Explode extends GameObject{
	public GameObject_Explode(int row, int col, Game_Board upper){
		super(row, col, upper);
	}
	
	void Sound(){
		upper.upper.sound.startSound("explodeItem");
	}
}

class CountUp extends GameObject_Explode{
	public CountUp(int row, int col, Game_Board upper){
		super(row, col, upper);
	}
	
	@Override
	public void finalize() throws Throwable{
		super.finalize();
		System.out.println("plus move count");
		upper.upper.game_info.plus_move_count(1);
		upper.upper.movecntLabel.setText(String.valueOf(upper.upper.game_info.get_move_count()));
	}
	
	@Override
	public void setImage(int width, int height, int imgNum){
		this.imgNum = imgNum;
		try {
			Image img = ImageIO.read(getClass().getResource(selectImage("set_CountUp", imgNum)));
			this.setIcon(new ImageIcon(img.getScaledInstance(width,height,Image.SCALE_SMOOTH)));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void selectObject(){
		Game_Board.selectedObject = this;
		try {
			Image img = ImageIO.read(getClass().getResource(selectImage("select_CountUp", imgNum)));
			this.setIcon(new ImageIcon(img.getScaledInstance(this.getIcon().getIconWidth(),
																this.getIcon().getIconHeight(),
																Image.SCALE_SMOOTH)));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}