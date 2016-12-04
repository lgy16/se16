package bubblepop;


import java.net.MalformedURLException;

import javax.swing.ImageIcon;

public class Effects extends javax.swing.JFrame{
	
	private static int count;
	private static int[] ob_location;
	private static int x;
	private static int y;
	
	public Effects()
	{
		count = Game_Board.pop_count;
		ob_location = Game_Board.obj_location;
	}
	
	public void sleep(int time){
	    try {
	      Thread.sleep(time);
	    } catch (InterruptedException e) { }
	}
	
	public Effects return_this()
	{
		return this;
	}
	
	public static void main(String[] args)
	{
		Effects e = new Effects();
	  	
		System.out.println("count = " + count);
		
		PopEffect[] p_effect = new PopEffect[count];
		
		for(int i=0; i<count; i++)
		{
			Effects.x=ob_location[i*2];
			Effects.y=ob_location[i*2+1];
			
			p_effect[i] = new PopEffect();
			p_effect[i].setBounds(x, y, 80, 80);
			p_effect[i].setVisible(true);
		}
		
		e.sleep(800);
		
		for(int i=0; i<e.count; i++)
		{
			p_effect[i].ii.getImage().flush();
			p_effect[i].dispose();
		}  	
		
		e=null;
	}
	
	
	
	/*
	public static void main(String args[]) throws MalformedURLException{
	    //home frame = new home();

		javax.swing.JFrame f = new javax.swing.JFrame("Animation");
		ImageIcon ii = new ImageIcon(f.getClass().getResource("effect/pop.gif"));
		javax.swing.JLabel label = new javax.swing.JLabel(ii);
		f.getContentPane().add(label);
		f.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		f.pack();
		f.setLocationRelativeTo(null);
		f.setVisible(true);
	}
	
	*/
}
