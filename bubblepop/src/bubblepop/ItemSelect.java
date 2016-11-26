package bubblepop;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JOptionPane;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LGY
 */
public class ItemSelect extends javax.swing.JFrame {
	int selectcnt;
	int cnt=0;
	public static boolean item1=false;
	public static boolean item2=false;
	public static boolean item3=false;
	public static boolean item4=false;
	public static boolean item5=false;
	Main m = new Main();
	
    /**
     * Creates new form ItemSelect
     */
    public ItemSelect() {
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


        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        itemRemove = new javax.swing.JButton();
        itemRecreate = new javax.swing.JButton();
        itemChangecnt = new javax.swing.JButton();
        itemHint = new javax.swing.JButton();
        itemChangeone = new javax.swing.JButton();
        JLabel1 =new javax.swing.JLabel();
        
        
        /******************/
        if(m.level == "상")
        	selectcnt = 3;
        
    	else if(m.level == "중")
    		selectcnt = 4;
    	else
    		selectcnt = 5;
        /******************/

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);	//이 창을 끌 때 부모 frame이 함께 꺼지지 않게 한다.
        setTitle("Item Select");
        setAlwaysOnTop(true);

        jPanel1.setAutoscrolls(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 269, Short.MAX_VALUE)
        );
        
        /***************************************/
        
        itemRemove.setText("하나 지우기");
        itemRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if(item1 == false) {
                	if(cnt < selectcnt)
                	{
                		itemRemove.setBackground(Color.ORANGE);
                		cnt++;
                		item1 = true;
                	}
                	else
                	{
                		JOptionPane.showMessageDialog(null, "아이템 개수는 " + selectcnt +"개 선택할 수 있습니다.");
                	}
                		
                }
                else
                {
                	itemRemove.setBackground(null);
                	cnt--;
                	item1 = false;
                }
            }
        });
        
        itemRecreate.setText("리셋");
        itemRecreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	if(item2 == false) {
            		if(cnt < selectcnt)
                	{
            			itemRecreate.setBackground(Color.ORANGE);
            			cnt++;
            			item2 = true;
                	}
            		else
                	{
            			JOptionPane.showMessageDialog(null, "아이템 개수는 " + selectcnt +"개 선택할 수 있습니다.");
                	}
                		           		
                }
                else
                {
                	itemRecreate.setBackground(null);
                	cnt--;
                	item2 = false;
                }
            }
        });
        
        itemChangecnt.setText("이동회수로 바꿈");
        itemChangecnt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	if(item3 == false) {
            		if(cnt < selectcnt)
                	{
            			itemChangecnt.setBackground(Color.ORANGE);
            			cnt++;
            			item3 = true;
                	}
            		else
                	{
            			JOptionPane.showMessageDialog(null, "아이템 개수는 " + selectcnt +"개 선택할 수 있습니다.");
                	}
                }
            	
                else
                {
                	itemChangecnt.setBackground(null);
                	cnt--;
                	item3 = false;
                }
            }
        });
        
        itemHint.setText("힌트");
        itemHint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	if(item4 == false) {
            		if(cnt < selectcnt)
                	{
            			itemHint.setBackground(Color.ORANGE);
            			cnt++;
            			item4 = true;
                	}
            		else
                	{
                		JOptionPane.showMessageDialog(null, "아이템 개수는 " + selectcnt +"개 선택할 수 있습니다.");
                	}
            		
                }
                else
                {
                	itemHint.setBackground(null);
                	cnt--;
                	item4 = false;
                }
            }
        });
        
        itemChangeone.setText("하나 바꾸기");
        itemChangeone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	if(item5 == false) {
            		if(cnt < selectcnt)
                	{
            			itemChangeone.setBackground(Color.ORANGE);
            			cnt++;
            			item5 = true;
                	}
            		else
                	{
            			JOptionPane.showMessageDialog(null, "아이템 개수는 " + selectcnt +"개 선택할 수 있습니다.");
                	}
            		
                }
                else
                {
                	itemChangeone.setBackground(null);
                	cnt--;
                	item5 = false;
                }
            }
        });  
        
        
        
        /**************************************/       

        jButton1.setText("취소");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("선택완료");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(51)
        			.addComponent(jButton1)
        			.addGap(37)
        			.addComponent(jButton2)
        			.addGap(46))
        		.addGroup(layout.createSequentialGroup()
        			.addGap(22)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(itemRecreate, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
        				.addComponent(itemRemove, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE))
        			.addContainerGap())
        		.addGroup(Alignment.TRAILING, layout.createSequentialGroup()
        			.addGap(22)
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        				.addComponent(itemChangeone, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
        				.addComponent(itemHint, GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
        				.addComponent(itemChangecnt, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE))
        			.addContainerGap())
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(itemRemove, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(itemRecreate, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(itemChangecnt, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(itemHint, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(itemChangeone, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jButton1)
        				.addComponent(jButton2))
        			.addContainerGap())
        );
        getContentPane().setLayout(layout);

        pack();
    }// </editor-fold>    
    
    //취소버튼 클릭
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
    	/****/
		cnt = 0;
		item1=false;
		item2=false;
		item3=false;
		item4=false;
		item5=false;
		/***/
    	dispose(); //창을 닫는다
    }                                        

    //선택완료버튼 클릭
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) 
    {                                         
        
    	int reply=JOptionPane.showConfirmDialog(this, "선택하신 아이템을 가지고 플레이하게 됩니다. 게임을 시작하시겠습니까?", null, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		
		if (reply == JOptionPane.YES_OPTION)
		{
			//게임 플레이 창으로 전환
			Game frame = new Game();
			frame.setResizable(false);
			frame.setVisible(true);
			/****/
			cnt = 0;
			item1=false;
			item2=false;
			item3=false;
			item4=false;
			item5=false;
			/***/
			dispose();
	    }
		else
		{
			//다시 선택
	    }
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
            java.util.logging.Logger.getLogger(ItemSelect.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ItemSelect.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ItemSelect.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ItemSelect.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ItemSelect().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration    
    
    private javax.swing.JButton itemRemove;
    private javax.swing.JButton itemRecreate;
    private javax.swing.JButton itemChangecnt;
    private javax.swing.JButton itemHint;
    private javax.swing.JButton itemChangeone;
    
    private javax.swing.JLabel JLabel1;
    

  
}
