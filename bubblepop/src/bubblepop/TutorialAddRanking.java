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
		
		JButton jButton = new JButton("다음");
		jButton.setFont(new Font("굴림", Font.PLAIN, 20));
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
		
		JLabel jLabel = new JLabel("<html>1.게임이 종료되면 최종점수를 랭킹에 등록할 수 있습니다.<BR>2.닉네임을 입력하세요."
				+ "<BR>3.'등록안함'버튼을 누르면 메인화면으로 돌아갑니다.");
		jLabel.setFont(new Font("굴림", Font.PLAIN, 19));
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