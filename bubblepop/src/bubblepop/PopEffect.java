package bubblepop;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PopEffect extends javax.swing.JFrame{
	 JPanel contentPane;
	    JLabel imageLabel = new JLabel();
	    public ImageIcon ii;

	    public PopEffect() {
	        try {
	        	setUndecorated(true);
	        	setBackground(new Color(0,0,0,0));
	            setDefaultCloseOperation(EXIT_ON_CLOSE);
	            contentPane = (JPanel) getContentPane();
	            contentPane.setLayout(new BorderLayout());
	            setSize(new Dimension(80, 80));
	            // add the image label
	            ii = new ImageIcon(this.getClass().getResource("effect/pop.gif"));
	            imageLabel.setIcon(ii);
	            contentPane.add(imageLabel, java.awt.BorderLayout.CENTER);
	            // show it
	            this.setVisible(true);
	        } catch (Exception exception) {
	            exception.printStackTrace();
	        }
	    }	
	    
	    //public pop_obj

	    public static void main(String[] args) {
	        new PopEffect();
	    }
}

