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

public class TutorialItemSelect extends JFrame {
	private JLabel imLabel;
	
	public TutorialItemSelect() {
		setTitle("Bubblepop Tutorial");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(800,445);
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
		imLabel = new JLabel(new ImageIcon(getClass().getResource("tu_img/2.png")));
		splitPane.setLeftComponent(imLabel);
		imLabel.setHorizontalAlignment(JLabel.CENTER);
		
		JLabel jLabel = new JLabel("<html>1.아이템을 선택하세요.<BR>2.난이도 상,중,하 각각 5,4,3개의 아이템을 고를 수 있습니다."
				+ "<BR>3.선택한 아이템은 각각 한번씩 사용할수 있습니다.");
		jLabel.setFont(new Font("굴림", Font.PLAIN, 19));
		splitPane.setRightComponent(jLabel);
				
	}
	private void jButtonActionPerformed(java.awt.event.ActionEvent evt)
    {                                         
    	TutorialGame frame = new TutorialGame();
    	frame.setResizable(false);
    	frame.setVisible(true);
    	dispose();
    }
}