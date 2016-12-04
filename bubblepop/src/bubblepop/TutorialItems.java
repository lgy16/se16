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
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JSplitPane;

public class TutorialItems extends JFrame {
private JLabel imLabel;
	
	public TutorialItems() {
		setTitle("Bubblepop Tutorial");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(900,400);
		setLocationRelativeTo(this);
		
		JButton jButton = new JButton("다음");
		getContentPane().add(jButton, BorderLayout.SOUTH);
		jButton.setFont(new Font("굴림", Font.PLAIN, 20));
		
		JSplitPane splitPane = new JSplitPane();
		getContentPane().add(splitPane, BorderLayout.CENTER);
		imLabel = new JLabel(new ImageIcon(getClass().getResource("tu_img/4.png")));
		splitPane.setLeftComponent(imLabel);
		imLabel.setText("");
		
		JLabel jLabel = new JLabel("<html>1.오브젝트를 움직여 같은그림 3개이상 연결하세요.<BR>2.오브젝트는 상,하,좌,우 한칸만 이동가능합니다."
				+ "<BR>3.폭탄형 오브젝트는 해당그림과 같은 모든 오브젝트를 터트립니다.<BR>4.라인형 오브젝트는 해당오브젝트가 있는 세로/가로 라인을 모두 터트립니다."
				+ "<BR>5.카운트증가형 오브젝트는 터질때마다 이동횟수를 1증가 시킵니다."
				+ "<BR>6.아이템은 랜덤으로 생성됩니다.");
		jLabel.setFont(new Font("굴림", Font.PLAIN, 20));
		splitPane.setRightComponent(jLabel);
		jButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jButtonActionPerformed(e);
			}
		});
				
	}
	private void jButtonActionPerformed(java.awt.event.ActionEvent evt)
    {                                         
    	TutorialAddRanking frame = new TutorialAddRanking();
    	frame.setResizable(false);
    	frame.setVisible(true);
    	dispose();
    }

}
