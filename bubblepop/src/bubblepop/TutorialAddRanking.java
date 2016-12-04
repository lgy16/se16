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

public class TutorialAddRanking extends JFrame {
	private JLabel imLabel;
	
	public TutorialAddRanking() {
		setTitle("Bubblepop Tutorial");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(760,380);
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
		imLabel = new JLabel(new ImageIcon(getClass().getResource("tu_img/5.png")));
		splitPane.setLeftComponent(imLabel);
		imLabel.setHorizontalAlignment(JLabel.CENTER);
		
		JLabel jLabel = new JLabel("<html>1.������ ����Ǹ� ���������� ��ŷ�� ����� �� �ֽ��ϴ�.<BR>2.�г����� �Է��ϼ���."
				+ "<BR>3.'��Ͼ���'��ư�� ������ ����ȭ������ ���ư��ϴ�.");
		jLabel.setFont(new Font("����", Font.PLAIN, 19));
		splitPane.setRightComponent(jLabel);
				
	}
	private void jButtonActionPerformed(java.awt.event.ActionEvent evt)
    {                                         
    	TutorialRanking frame = new TutorialRanking();
    	frame.setResizable(false);
    	frame.setVisible(true);
    	dispose();
    }
}