package bubblepop;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import java.awt.Dimension;
import java.awt.event.ActionEvent;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LGY
 */
public class AddRanking extends javax.swing.JFrame {
	private Game game;
	private int score;
	private String level;
    /**
     * Creates new form AddRanking
     */
	public AddRanking() {
        initComponents();
    }

    public AddRanking(Game_Info info, Game g) {
    	score = info.get_game_score();
    	level = info.get_game_level();
    	game=g;
        initComponents();
    }

	/**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">             
    
    
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton1.addActionListener(new java.awt.event.ActionListener() { //랭킹등록 버튼 클릭시
        	public void actionPerformed(java.awt.event.ActionEvent evt) {
        		jButton1ActionPerformed(evt);
        	}
        });
        jButton2 = new javax.swing.JButton();
        jButton2.addActionListener(new java.awt.event.ActionListener() { //등록안함 버튼 클릭시
        	public void actionPerformed(java.awt.event.ActionEvent evt) {
        		jButton2ActionPerformed(evt);
        	}
        });
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        
        setPreferredSize(new java.awt.Dimension(400, 250));
        java.awt.Dimension scrnSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
    	int x = (scrnSize.width - 400)/2;
    	int y = (scrnSize.height - 250)/2;
    	
    	setLocation(x,y);
    	
        setResizable(false);

        
        setTitle("BubblePop :: 랭킹등록");

        jButton1.setText("랭킹등록");

        jButton2.setText("등록안함");

        jLabel1.setText(" 난이도 : " + level + "   획득한 점수: " + score + "점");
        
        jLabel2.setText("랭킹에 등록하시려면 아래 빈칸에 닉네임을 입력해 주세요.");

        jLabel3.setText("닉네임");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jButton1)
                        .addGap(75, 75, 75)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addGap(33, 33, 33))
        );

        pack();
    }// </editor-fold>          
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt)
    {
    	switch(level){
    	case "상":
    		level = "high";
    		break;
    	case "중":
    		level = "middle";
    		break;
    	case "하":
    		level = "low";
    		break;
    	}                
        //랭킹등록 버튼 클릭
    	JOptionPane.showMessageDialog(this, "등록되었습니다.", null, JOptionPane.INFORMATION_MESSAGE);
    	new RankingEntry(level, jTextField1.getText(), String.valueOf(score));
    	Ranking frame = new Ranking();
    	frame.setResizable(false);
    	frame.setVisible(true);
    	game.dispose();
    	dispose();
    }  
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt)
    {                                         
        //등록안함 버튼 클릭
    	Main frame = new Main();
    	frame.setResizable(false);
    	frame.setVisible(true);
    	game.dispose();
    	dispose();
    }  

    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AddRanking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddRanking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddRanking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddRanking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddRanking().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration                   
}
