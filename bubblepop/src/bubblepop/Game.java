package bubblepop;


import javax.swing.JOptionPane;
import javax.swing.JToggleButton;

import java.awt.GridLayout;

import javax.swing.JLabel;


////////////Game 화면
public class Game extends javax.swing.JFrame {
	protected Sound sound;
	private Item_list i_list;
	private Game_Info game_info;
	private int count;
    /**
     * Creates new form game
     */
    public Game()
    {
        initComponents();
    }
    
    public Game(Item_list list, Game_Info g_info, int cnt)
    {
    	count=cnt;
    	game_info=g_info;
    	i_list=list;
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
    	
    	gameBoard = new Game_Board(375, 450);
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        levelLabel = new JLabel();
        scoreLabel = new JLabel();
        movecntLabel = new JLabel();
        jPanel2 = new javax.swing.JPanel();
        ex_item_buttons = new javax.swing.JButton[5];

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("BubblePop :: Play");
        setResizable(false);
        setMaximumSize(new java.awt.Dimension(400, 660));
        setMinimumSize(new java.awt.Dimension(400, 660));
        setPreferredSize(new java.awt.Dimension(400, 660));

        jLabel1.setPreferredSize(new java.awt.Dimension(30, 30));
        jLabel2.setPreferredSize(new java.awt.Dimension(30, 30));
        jLabel3.setPreferredSize(new java.awt.Dimension(30, 30));
        
        jPanel2.setPreferredSize(new java.awt.Dimension(375, 50));
        jPanel2.setMinimumSize(new java.awt.Dimension(375, 50));
        jPanel2.setMaximumSize(new java.awt.Dimension(375, 50));
        
        jLabel1.setText("난이도 ");

        jLabel2.setText("점수");

        jLabel3.setText("남은 횟수");
           
        levelLabel.setText(game_info.get_game_level());
        scoreLabel.setText(String.valueOf(game_info.get_game_score()));
        movecntLabel.setText(String.valueOf(game_info.get_move_count()));
        System.out.println(game_info.get_game_level() + "\t" + game_info.get_game_score() + "\t" + game_info.get_move_count());
        
        jPanel2.setLayout(new GridLayout(1, 5, 24, 24));
        for(int i=0; i<5; i++)
        {
        	ex_item_buttons[i] = new javax.swing.JButton(i_list.item_icon[i]);
        	ex_item_buttons[i].setPreferredSize(new java.awt.Dimension(50, 50));
        	ex_item_buttons[i].setHorizontalAlignment(javax.swing.SwingConstants.CENTER);	
        	ex_item_buttons[i].setOpaque(true);
        	if(i>=count)
        	{
        		ex_item_buttons[i].setVisible(false);
        	}
        	jPanel2.add(ex_item_buttons[i]); //jPanel1에 버튼을 추가  	
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(20, 20, 20)
            .addGroup(jPanel2Layout.createSequentialGroup()
            		.addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
           .addGap(0, 0, 0)
           .addGroup(jPanel2Layout.createSequentialGroup()
        		   .addContainerGap())
        );
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup
        (
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup
            (
            		layout.createSequentialGroup()
            		.addContainerGap()
            		.addGroup
            		(
	                		layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                		.addGroup
	                		(
	                				layout.createSequentialGroup()
	                				.addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
			                        .addGap(18, 18, 18)
			                        .addComponent(levelLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
			                        .addGap(18, 18, 18)
			                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
			                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 132, Short.MAX_VALUE)
			                        .addComponent(scoreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
			                        .addGap(18, 18, 18)
			                        .addComponent(jLabel3)
			                        .addGap(56, 56, 56)
			                        .addComponent(movecntLabel,  javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
			                        .addGap(18, 18, 18)
	                        )
	                		.addGroup
	                		(
		                    		javax.swing.GroupLayout.Alignment.CENTER, layout.createSequentialGroup()
		                    		.addGroup
		                    		(
		                    				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
		                    				.addComponent(jPanel2, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		                    				.addComponent(gameBoard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(12, 12, 12)
		                    		)
		                    		.addContainerGap()
		                    )
            		)
               )
        );
        layout.setVerticalGroup
        (
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup
            (
            		javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            		.addContainerGap()
            		.addGroup
            		(
            				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
            				.addComponent(jLabel1)
            				.addComponent(levelLabel)
            				.addComponent(jLabel2)
            				.addComponent(scoreLabel)
            				.addComponent(jLabel3)
            				.addComponent(movecntLabel)
            		)
            		.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            		.addComponent(gameBoard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            		.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, 8)// javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            		.addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE)
            		.addContainerGap()
            )
        );

/////////////////////////////////////////////////////////////////////////////////////////////////////        
///////////X눌렀을 때 종료할 거냐 묻는 코드///////////////////////////////////////////////////////////////////
        this.setDefaultCloseOperation(javax.swing.JFrame.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new java.awt.event.WindowAdapter() 
        {
        	@Override
        	public void windowClosing(java.awt.event.WindowEvent e) 		
        	{
        		if (JOptionPane.showConfirmDialog(null, 
        	            "지금 게임을 중단하면 랭킹에 등록 할 수 없습니다. 게속하시겠습니까?", null, 
        	            JOptionPane.YES_NO_OPTION,
        	            JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
        	            Main frame = new Main();
        	            frame.setResizable(false);
                    	frame.setVisible(true);
                    	dispose();	
        	        }
        		//sound.stop_Main_Sound();
        	}	
        });
       
        


        pack();
    }// </editor-fold>                        

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
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Game().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private Game_Board gameBoard;
    private javax.swing.JPanel jPanel2;
    private JLabel levelLabel;
    private JLabel scoreLabel;
    private JLabel movecntLabel;
    private javax.swing.JButton[] ex_item_buttons;
    
    // End of variables declaration                   
}
