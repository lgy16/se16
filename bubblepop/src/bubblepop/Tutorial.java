package bubblepop;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Tutorial extends JFrame {
	private JLabel imLabel;
	
	public Tutorial() {
		setTitle("Bubblepop Tutorial");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(497,431);
		setLocationRelativeTo(this);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		imLabel = new JLabel(new ImageIcon(getClass().getResource("tu_img/1.png")));
		panel.add(imLabel);
		imLabel.setHorizontalAlignment(JLabel.CENTER);
		
		JButton jButton = new JButton("¥Ÿ¿Ω");
		jButton.setFont(new Font("±º∏≤", Font.PLAIN, 20));
		jButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jButtonActionPerformed(e);
			}
		});
		getContentPane().add(jButton, BorderLayout.SOUTH);
	}
	private void jButtonActionPerformed(java.awt.event.ActionEvent evt)
    {                                         
        //∑©≈∑ πˆ∆∞¿ª ¥≠∑∂¿ª ∂ß
    	TutorialItemSelect frame = new TutorialItemSelect();
    	frame.setResizable(false);
    	frame.setVisible(true);
    	dispose();
    }
}
class TutorialItemSelect extends JFrame {
	private JLabel imLabel;
	
	public TutorialItemSelect() {
		setTitle("Bubblepop Tutorial");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(450,480);
		setLocationRelativeTo(this);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		imLabel = new JLabel(new ImageIcon(getClass().getResource("tu_img/2.png")));
		panel.add(imLabel);
		imLabel.setHorizontalAlignment(JLabel.CENTER);
		
		JButton jButton = new JButton("¥Ÿ¿Ω");
		jButton.setFont(new Font("±º∏≤", Font.PLAIN, 20));
		jButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jButtonActionPerformed(e);
			}
		});
		getContentPane().add(jButton, BorderLayout.SOUTH);
				
	}
	private void jButtonActionPerformed(java.awt.event.ActionEvent evt)
    {                                         
    	TutorialGame frame = new TutorialGame();
    	frame.setResizable(false);
    	frame.setVisible(true);
    	dispose();
    }
}
class TutorialGame extends JFrame {
	private JLabel imLabel;
	
	public TutorialGame() {
		setTitle("Bubblepop Tutorial");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(500,800);
		setLocationRelativeTo(this);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		imLabel = new JLabel(new ImageIcon(getClass().getResource("tu_img/3.png")));
		panel.add(imLabel);
		imLabel.setHorizontalAlignment(JLabel.CENTER);
		
		JButton jButton = new JButton("¥Ÿ¿Ω");
		jButton.setFont(new Font("±º∏≤", Font.PLAIN, 20));
		jButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jButtonActionPerformed(e);
			}
		});
		getContentPane().add(jButton, BorderLayout.SOUTH);
				
	}
	private void jButtonActionPerformed(java.awt.event.ActionEvent evt)
    {                                         
    	TutorialAddRanking frame = new TutorialAddRanking();
    	frame.setResizable(false);
    	frame.setVisible(true);
    	dispose();
    }
}
class TutorialAddRanking extends JFrame {
	private JLabel imLabel;
	
	public TutorialAddRanking() {
		setTitle("Bubblepop Tutorial");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(497,431);
		setLocationRelativeTo(this);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		imLabel = new JLabel(new ImageIcon(getClass().getResource("tu_img/4.png")));
		panel.add(imLabel);
		imLabel.setHorizontalAlignment(JLabel.CENTER);
		
		JButton jButton = new JButton("¥Ÿ¿Ω");
		jButton.setFont(new Font("±º∏≤", Font.PLAIN, 20));
		jButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jButtonActionPerformed(e);
			}
		});
		getContentPane().add(jButton, BorderLayout.SOUTH);
				
	}
	private void jButtonActionPerformed(java.awt.event.ActionEvent evt)
    {                                         
    	TutorialRanking frame = new TutorialRanking();
    	frame.setResizable(false);
    	frame.setVisible(true);
    	dispose();
    }
}
class TutorialRanking extends JFrame {
	private JLabel imLabel;
	
	public TutorialRanking() {
		setTitle("Bubblepop Tutorial");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(650,750);
		setLocationRelativeTo(this);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		imLabel = new JLabel(new ImageIcon(getClass().getResource("tu_img/5.png")));
		panel.add(imLabel);
		imLabel.setHorizontalAlignment(JLabel.CENTER);
		
		JButton jButton = new JButton("∞‘¿”Ω√¿€");
		jButton.setFont(new Font("±º∏≤", Font.PLAIN, 20));
		jButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jButtonActionPerformed(e);
			}
		});
		getContentPane().add(jButton, BorderLayout.SOUTH);
				
	}
	private void jButtonActionPerformed(java.awt.event.ActionEvent evt) {                                         
    	dispose();
    }
}