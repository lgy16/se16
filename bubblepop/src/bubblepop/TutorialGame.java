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
		imLabel = new JLabel(new ImageIcon(getClass().getResource("tu_img/3.png")));
		splitPane.setLeftComponent(imLabel);
		imLabel.setHorizontalAlignment(JLabel.CENTER);
		
		JLabel jLabel = new JLabel("<html>1.오브젝트를 클릭해 이동하세요.<BR>2.상단에 현재 게임정보를 표시하고 있습니다.<BR>3.하단에 앞서 선택한 아이템을 표시하고있습니다.");
		jLabel.setFont(new Font("굴림", Font.PLAIN, 19));
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