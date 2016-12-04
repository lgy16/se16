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
		
		JButton jButton = new JButton("게임시작");
		jButton.setFont(new Font("굴림", Font.PLAIN, 20));
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
		
		JLabel jLabel = new JLabel("<html>1.난이도별로 등록된 랭킹정보를 보여줍니다.<BR>2.랭킹은 30위 까지만 보여줍니다.");
		jLabel.setFont(new Font("굴림", Font.PLAIN, 19));
		splitPane.setRightComponent(jLabel);
				
	}
	private void jButtonActionPerformed(java.awt.event.ActionEvent evt) {                                         
    	dispose();
    }
}