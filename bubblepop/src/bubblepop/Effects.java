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
		
		System.out.println("count = " + count);
		
		PopEffect[] p_effect = new PopEffect[count];
		
		int i;
		for(i=0; i<count; i++)
		{
			Effects.x=ob_location[i*2]-10;
			Effects.y=ob_location[i*2+1]-10;
			
			p_effect[i] = new PopEffect();
			p_effect[i].setBounds(x, y, 80, 80);
			p_effect[i].setVisible(true);
		}
		System.out.println("i = "+i);
		
		sleep(800);
		
		for(i=0; i<count; i++)
		{
			p_effect[i].ii.getImage().flush();
			p_effect[i].dispose();
		}  	
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
		new Effects();
	  	/*
		System.out.println("count = " + count);
		
		PopEffect[] p_effect = new PopEffect[count];
		
		int i;
		for(i=0; i<count; i++)
		{
			Effects.x=ob_location[i*2]-10;
			Effects.y=ob_location[i*2+1]-10;
			
			p_effect[i] = new PopEffect();
			p_effect[i].setBounds(x, y, 80, 80);
			p_effect[i].setVisible(true);
		}
		System.out.println("i = "+i);
		
		e.sleep(800);
		
		for(i=0; i<e.count; i++)
		{
			p_effect[i].ii.getImage().flush();
			p_effect[i].dispose();
		}  	
		
		e=null;
		*/
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



/*
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

import icon_example.Flap;

public class Effects extends JComponent implements Runnable 
{
	Image[] images = new Image[10];
	int frame = 0;
	private static int count;
	private static int[] ob_location;
	private static int x;
	private static int y;
	
	public Effects()
	{
		count = Game_Board.pop_count;
		ob_location = Game_Board.obj_location;
	}
	
	public void paint(Graphics g) {
	    Image image = images[frame];
	    if (image != null)
	    {
	        // Draw the current image
	        int x = 0;
	        int y = 0;
	        g.drawImage(image, x, y, this);
	        
	        System.out.println("app.paint()");
	    }
	}
	
	
	public void run() {
	    // Load the array of images
	    images[0] = new ImageIcon(this.getClass().getResource("effect/1.png")).getImage();
	    images[1] = new ImageIcon(this.getClass().getResource("effect/2.png")).getImage();
	    images[2] = new ImageIcon(this.getClass().getResource("effect/3.png")).getImage();
	    images[3] = new ImageIcon(this.getClass().getResource("effect/4.png")).getImage();
	    images[4] = new ImageIcon(this.getClass().getResource("effect/5.png")).getImage();
	    images[5] = new ImageIcon(this.getClass().getResource("effect/6.png")).getImage();
	    images[6] = new ImageIcon(this.getClass().getResource("effect/7.png")).getImage();
	    images[7] = new ImageIcon(this.getClass().getResource("effect/8.png")).getImage();
	    images[8] = new ImageIcon(this.getClass().getResource("effect/9.png")).getImage();
	    images[9] = new ImageIcon(this.getClass().getResource("effect/10.png")).getImage();
	    
	    System.out.println("8");
	    // Display each image for 1 second
	    int delay = 100;    // 1 second
	
	    System.out.println("9");
	    try {
	        while (true) {
	            // Move to the next image
	            frame = (frame+1)%images.length;
	
	            // Causes the paint() method to be called
	            repaint();
	
	            System.out.println(frame);
	            // Wait
	            Thread.sleep(delay);
	        }
	    } catch (Exception e) {
	    }
	    System.out.println("10");
	}
	
	public static void main(String[] args) {
			
	
		Effects app = new Effects();
	    //Display the animation in a frame
	    JFrame[] p_effect = new JFrame[count];
	    
	    int i;
		for(i=0; i<count; i++)
		{
			x=ob_location[i*2]-10;
			y=ob_location[i*2+1]-10;
			
			p_effect[i] = new JFrame();
			p_effect[i].setBounds(x, y, 80, 80);
			p_effect[i].getContentPane().add(p_effect[i]);
			p_effect[i].setSize(80, 80);
			p_effect[i].setVisible(true);
		}
		System.out.println("i = "+i);
	    
	    
	    
		for(i=0; i < count; i++)
		{
			(new Thread(p_effect[i])).start();  	
		    
		    	    
			p_effect[i].addWindowListener(new WindowAdapter() {
			    @Override
			    public void windowClosing(WindowEvent e) {	
			    	System.exit(0);
			    }
			    
		});
		}

	    
	}

}
*/
