package bubblepop;

import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.StringTokenizer;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicTabbedPaneUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.JList;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.JScrollBar;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.JTable;





/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LGY
 */

class RankingEntry{
	public RankingEntry(String level, String name, String score){
		try{		
			URL url = new URL("http://www.bublepop.esy.es/Register_Ranking/registerRanking.php");
            HttpURLConnection http = (HttpURLConnection)url.openConnection();
            http.setDefaultUseCaches(false);
            http.setDoInput(true);
            http.setDoOutput(true);
            http.setRequestMethod("POST");

            http.setRequestProperty("content-type", "application/x-www-form-urlencoded");
            StringBuffer buffer = new StringBuffer();
            buffer.append("?&level="+level+"&name="+name+"&score="+score);
            
            OutputStreamWriter outStream = new OutputStreamWriter(http.getOutputStream(), "UTF-8");
            PrintWriter writer = new PrintWriter(outStream);
            writer.write(buffer.toString());
            writer.flush();

            InputStreamReader tmp = new InputStreamReader(http.getInputStream(), "UTF-8");
            BufferedReader reader = new BufferedReader(tmp);
            StringBuilder builder = new StringBuilder();
            String str;
            while ((str = reader.readLine()) != null) {
                builder.append(str);
            }
            http.disconnect();
		}
		catch(Exception e){
			System.out.print("Fail : " + e + "\n");
		}
		finally {
			System.out.print("Finish\n");
		}
	}
}

public class Ranking extends javax.swing.JFrame {

    /**
     * Creates new form lanking
     */
    public Ranking() {
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        JLabel jLabel2 = new javax.swing.JLabel("난이도 하", JLabel.CENTER);
        JLabel jLabel3 = new javax.swing.JLabel("난이도 중", JLabel.CENTER);
        JLabel jLabel4 = new javax.swing.JLabel("난이도 상", JLabel.CENTER);
        jLabel2.setPreferredSize(new Dimension(122, 30));
        jLabel3.setPreferredSize(new Dimension(122, 30));
        jLabel4.setPreferredSize(new Dimension(122, 30));
        setResizable(false);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("BubblePop :: Ranking");

        jTabbedPane1.setMaximumSize(new java.awt.Dimension(100, 100));
        jTabbedPane1.setMinimumSize(new java.awt.Dimension(100, 100));
        jTabbedPane1.setOpaque(true);
        jTabbedPane1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTabbedPane1FocusGained(evt);
            }
        });
        
        scrollPane1 = new JScrollPane();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1Layout.setHorizontalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.TRAILING)
        		.addComponent(scrollPane1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
        );
        
        //난이도 하 테이블에 랭킹 뿌려주기
        String[] col = {"Ranking", "Name", "Time", "Score"};
        ShowRanking sr1 = new ShowRanking("low");
        DefaultTableModel model1 = new DefaultTableModel(sr1.getRankingInfo(),col);
        
        table1 = new JTable(model1);
        scrollPane1.setViewportView(table1);
        jPanel1.setLayout(jPanel1Layout);

        jTabbedPane1.addTab("난이도 하", jPanel1);
        
        scrollPane2 = new JScrollPane();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2Layout.setHorizontalGroup(
        	jPanel2Layout.createParallelGroup(Alignment.TRAILING)
        		.addComponent(scrollPane2, GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
        	jPanel2Layout.createParallelGroup(Alignment.LEADING)
        		.addComponent(scrollPane2, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
        );
        
        //난이도 중 테이블에 랭킹 뿌려주기
        ShowRanking sr2 = new ShowRanking("middle");
        DefaultTableModel model2 = new DefaultTableModel(sr2.getRankingInfo(),col);        
        
        table2 = new JTable(model2);
        scrollPane2.setViewportView(table2);
        jPanel2.setLayout(jPanel2Layout);

        jTabbedPane1.addTab("난이도 중", jPanel2);
        
        JScrollPane scrollPane3 = new JScrollPane();

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3Layout.setHorizontalGroup(
        	jPanel3Layout.createParallelGroup(Alignment.TRAILING)
        		.addComponent(scrollPane3, GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
        	jPanel3Layout.createParallelGroup(Alignment.LEADING)
        		.addComponent(scrollPane3, GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
        );
        
        //난이도 상 테이블에 랭킹 뿌려주기        
        ShowRanking sr3 = new ShowRanking("high");
        DefaultTableModel model3 = new DefaultTableModel(sr3.getRankingInfo(),col);
        
        table3 = new JTable(model3);
        scrollPane3.setViewportView(table3);
        jPanel3.setLayout(jPanel3Layout);

        jTabbedPane1.addTab("난이도 상", jPanel3);

        jLabel1.setText("랭킹");

        jButton1.setText("닫기");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        
        jTabbedPane1.setTabComponentAt(0, jLabel2);  // tab index, jLabel
        jTabbedPane1.setTabComponentAt(1, jLabel3);  // tab index, jLabel
        jTabbedPane1.setTabComponentAt(2, jLabel4);  // tab index, jLabel

/////////////////////////////////////////////////////////////////////////////////////////////////////        
///////////X눌렀을 때 종료할 거냐 묻는 코드///////////////////////////////////////////////////////////////////
        this.setDefaultCloseOperation(javax.swing.JFrame.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new java.awt.event.WindowAdapter() 
        {
        	@Override
        	public void windowClosing(java.awt.event.WindowEvent e) 
        	{
        		Main frame = new Main();
            	frame.setResizable(false);
            	frame.setVisible(true);
            	dispose();	
        	}	
        });
///////////////////////////////////////////////////////////////////////////////////////////////////////
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(213, 213, 213)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(191, 191, 191)
                                .addComponent(jButton1)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>                        

    private void jTabbedPane1FocusGained(java.awt.event.FocusEvent evt)
    {                                         
        // TODO add your handling code here:
    }                                        

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt)
    {                                         
        //닫기 버튼 클릭
    	Main frame = new Main();
    	frame.setResizable(false);
    	frame.setVisible(true);
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
            java.util.logging.Logger.getLogger(Ranking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ranking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ranking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ranking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ranking().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JScrollPane scrollPane2;
    private JTable table2;
    private JTable table3;
    // End of variables declaration                   
}









/*
		///
        JLabel jLabel2 = new javax.swing.JLabel("난이도 하", JLabel.CENTER);
        JLabel jLabel3 = new javax.swing.JLabel("난이도 중", JLabel.CENTER);
        JLabel jLabel4 = new javax.swing.JLabel("난이도 상", JLabel.CENTER);
        jLabel2.setPreferredSize(new Dimension(122, 30));
        jLabel3.setPreferredSize(new Dimension(122, 30));
        jLabel4.setPreferredSize(new Dimension(122, 30));   
        
        ///
		jTabbedPane1.setTabComponentAt(0, jLabel2);  // tab index, jLabel
        jTabbedPane1.setTabComponentAt(1, jLabel3);  // tab index, jLabel
        jTabbedPane1.setTabComponentAt(2, jLabel4);  // tab index, jLabel
*/