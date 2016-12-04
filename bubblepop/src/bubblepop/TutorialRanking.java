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

public class TutorialRanking extends JFrame {
	private JLabel imLabel;
	
	public TutorialRanking() {
		setTitle("Bubblepop Tutorial");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(900,690);
		setLocationRelativeTo(this);
		
		JButton jButton = new JButton("���ӽ���");
		jButton.setFont(new Font("����", Font.PLAIN, 20));
		jButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jButtonActionPerformed(e);
			}
		});
		getContentPane().add(jButton, BorderLayout.SOUTH);
		
		JSplitPane splitPane = new JSplitPane();
		getContentPane().add(splitPane, BorderLayout.NORTH);
		imLabel = new JLabel(new ImageIcon(getClass().getResource("tu_img/6.png")));
		splitPane.setLeftComponent(imLabel);
		imLabel.setHorizontalAlignment(JLabel.CENTER);
		
		JLabel jLabel = new JLabel("<html>1.���̵����� ��ϵ� ��ŷ������ �����ݴϴ�.<BR>2.��ŷ�� 30�� ������ �����ݴϴ�.");
		jLabel.setFont(new Font("����", Font.PLAIN, 19));
		splitPane.setRightComponent(jLabel);
				
	}
	private void jButtonActionPerformed(java.awt.event.ActionEvent evt) {                                         
    	dispose();
    }
}