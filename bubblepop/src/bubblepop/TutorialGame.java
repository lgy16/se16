package bubblepop;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

public class TutorialGame extends JFrame {
	private JLabel imLabel;
	
	public TutorialGame() {
		setTitle("Bubblepop Tutorial");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(760,760);
		setLocationRelativeTo(this);
		
		JButton jButton = new JButton("����");
		jButton.setFont(new Font("����", Font.PLAIN, 20));
		jButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jButtonActionPerformed(e);
			}
		});
		getContentPane().add(jButton, BorderLayout.SOUTH);
		
		JSplitPane splitPane = new JSplitPane();
		getContentPane().add(splitPane, BorderLayout.NORTH);
		imLabel = new JLabel(new ImageIcon(getClass().getResource("tu_img/3.png")));
		splitPane.setLeftComponent(imLabel);
		imLabel.setHorizontalAlignment(JLabel.CENTER);
		
		JLabel jLabel = new JLabel("<html>1.������Ʈ�� Ŭ���� �̵��ϼ���.<BR>2.��ܿ� ���� ���������� ǥ���ϰ� �ֽ��ϴ�.<BR>3.�ϴܿ� �ռ� ������ �������� ǥ���ϰ��ֽ��ϴ�.");
		jLabel.setFont(new Font("����", Font.PLAIN, 19));
		splitPane.setRightComponent(jLabel);
				
	}
	private void jButtonActionPerformed(java.awt.event.ActionEvent evt)
    {                                         
    	TutorialItems frame = new TutorialItems();
    	frame.setResizable(false);
    	frame.setVisible(true);
    	dispose();
    }
}