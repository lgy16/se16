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
		
		JButton jButton = new JButton("����");
		getContentPane().add(jButton, BorderLayout.SOUTH);
		jButton.setFont(new Font("����", Font.PLAIN, 20));
		
		JSplitPane splitPane = new JSplitPane();
		getContentPane().add(splitPane, BorderLayout.CENTER);
		imLabel = new JLabel(new ImageIcon(getClass().getResource("tu_img/4.png")));
		splitPane.setLeftComponent(imLabel);
		imLabel.setText("");
		
		JLabel jLabel = new JLabel("<html>1.������Ʈ�� ������ �����׸� 3���̻� �����ϼ���.<BR>2.������Ʈ�� ��,��,��,�� ��ĭ�� �̵������մϴ�."
				+ "<BR>3.��ź�� ������Ʈ�� �ش�׸��� ���� ��� ������Ʈ�� ��Ʈ���ϴ�.<BR>4.������ ������Ʈ�� �ش������Ʈ�� �ִ� ����/���� ������ ��� ��Ʈ���ϴ�."
				+ "<BR>5.ī��Ʈ������ ������Ʈ�� ���������� �̵�Ƚ���� 1���� ��ŵ�ϴ�."
				+ "<BR>6.�������� �������� �����˴ϴ�.");
		jLabel.setFont(new Font("����", Font.PLAIN, 20));
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
