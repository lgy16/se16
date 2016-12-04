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
		imLabel = new JLabel(new ImageIcon(getClass().getResource("tu_img/1.png")));
		splitPane.setLeftComponent(imLabel);
		imLabel.setHorizontalAlignment(JLabel.CENTER);
		
		JLabel jLabel = new JLabel("<html>1.���̵� ��,��,�� �� �ϳ��� �����ϼ���.<BR>2.���� 30,40,50 ���� �̵�Ƚ���� ���ѵ˴ϴ�."
				+ "<BR>3.'����'��ư�� ������ ������ ����ȭ������ �Ѿ�ϴ�.<BR>4.'��ŷ'��ư�� ������ ���̵��� ��ŷ��Ȳ�� �����ֽ��ϴ�.");
		jLabel.setFont(new Font("����", Font.PLAIN, 19));
		splitPane.setRightComponent(jLabel);
	}
	private void jButtonActionPerformed(java.awt.event.ActionEvent evt)
    {                                         
        //��ŷ ��ư�� ������ ��
    	TutorialItemSelect frame = new TutorialItemSelect();
    	frame.setResizable(false);
    	frame.setVisible(true);
    	dispose();
    }
}

