package bubblepop;

import javax.swing.ImageIcon;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;

public class Effects extends JComponent implements Runnable 
{
	Image[] images = new Image[10];
	int frame = 0;
	private static int count;
	private static int[] ob_location;
	private static int x;
	private static int y;
	private Boolean is_stop;
	
	public Effects()
	{
		System.out.println("count = " + count);
		count = Game_Board.pop_count;
		ob_location = Game_Board.obj_location;
		is_stop=false;
	}
	
	public void paint(Graphics g) {
	    Image image = images[frame];
	    if (image != null)
	    {
	        // Draw the current image
	        int x = 0;
	        int y = 0;
	        g.drawImage(image, x, y, this);
	    }
	    
	    System.out.println("Thread dead");
	    
	}
	
	public void stop()
	{
		is_stop=true;
	}
	
	
	public void run() {
	    // Load the array of images
	    images[0] = new ImageIcon(this.getClass().getResource("effect/1.gif")).getImage();
	    images[1] = new ImageIcon(this.getClass().getResource("effect/2.gif")).getImage();
	    images[2] = new ImageIcon(this.getClass().getResource("effect/3.gif")).getImage();
	    images[3] = new ImageIcon(this.getClass().getResource("effect/4.gif")).getImage();
	    images[4] = new ImageIcon(this.getClass().getResource("effect/5.gif")).getImage();
	    images[5] = new ImageIcon(this.getClass().getResource("effect/6.gif")).getImage();
	    images[6] = new ImageIcon(this.getClass().getResource("effect/7.gif")).getImage();
	    images[7] = new ImageIcon(this.getClass().getResource("effect/8.gif")).getImage();
	    images[8] = new ImageIcon(this.getClass().getResource("effect/9.gif")).getImage();
	    images[9] = new ImageIcon(this.getClass().getResource("effect/10.gif")).getImage();
	    
	    // Display each image for 1 second
	    int delay = 100;    // 1 second
	
	    try {
	        while (!is_stop) {
	            // Move to the next image
	            frame = (frame+1)%images.length;
	
	            // Causes the paint() method to be called
	            repaint();
	
	            System.out.println(frame);
	            // Wait
	            Thread.sleep(delay);
	            
	            if(frame == 9)
	            {
	            	stop();
	            }
	        }
	    } catch (Exception e) {
	    }
	}
	
	public static void main(String[] args) {
			
		count = Game_Board.pop_count;
		Effects[] app = new Effects[count];
	    JFrame[] p_effect = new JFrame[count];
	    
	    System.out.println("count = " + count);
	    
	    int i;
	    for(i=0; i<count; i++)
		{
	    	app[i] = new Effects();
		}
	    
		for(i=0; i<count; i++)
		{
			x=ob_location[i*2]-10;
			y=ob_location[i*2+1]-10;

			p_effect[i] = new JFrame();
			p_effect[i].setBounds(x, y, 80, 80);
			p_effect[i].getContentPane().add(app[i]);
			p_effect[i].setSize(80, 80);
			p_effect[i].setUndecorated(true);
			p_effect[i].setBackground(new Color(0,0,0,0));
			p_effect[i].setVisible(true);
		}
  
		for(i=0; i < count; i++)
		{
			(new Thread(app[i])).start();  	
		        	    
			p_effect[i].addWindowListener(new WindowAdapter() {
			    @Override
			    public void windowClosing(WindowEvent e) {	
			    	System.exit(0);
			    }			    
		});
		}    
	}
}

