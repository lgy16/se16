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
import javax.swing.JSplitPane;

public class TutorialMain extends JFrame {
	private JLabel imLabel;
	
	public TutorialMain() {
		setTitle("Bubblepop Tutorial");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(800,400);
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
		imLabel = new JLabel(new ImageIcon(getClass().getResource("tu_img/1.png")));
		splitPane.setLeftComponent(imLabel);
		imLabel.setHorizontalAlignment(JLabel.CENTER);
		
		JLabel jLabel = new JLabel("<html>1.난이도 상,중,하 중 하나를 선택하세요.<BR>2.각각 20,30,40 번의 이동횟수가 제한됩니다."
				+ "<BR>3.'다음'버튼을 누르면 아이템 선택화면으로 넘어갑니다.<BR>4.'랭킹'버튼을 누르면 난이도별 랭킹현황을 볼수있습니다.");
		jLabel.setFont(new Font("굴림", Font.PLAIN, 19));
		splitPane.setRightComponent(jLabel);
	}
	private void jButtonActionPerformed(java.awt.event.ActionEvent evt)
    {                                         
        //랭킹 버튼을 눌렀을 때
    	TutorialItemSelect frame = new TutorialItemSelect();
    	frame.setResizable(false);
    	frame.setVisible(true);
    	dispose();
    }
}

