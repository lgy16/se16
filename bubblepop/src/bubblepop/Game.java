package bubblepop;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Calendar;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.Label;
import javax.swing.JLabel;

class GameObject extends JButton{
	private Game_Board upper;
	private final int ROW, COL;
	public int imgNum;
   
	public GameObject(int row, int col, Game_Board upper){
	   this.upper = upper;
	   this.ROW = row;
	   this.COL = col;
	   this.addActionListener(new MyActionLitener());
	}
   
	//이미지 주소 불러오기
	String selectImage(String mod, int imgNum){
		switch(mod){
		case "set":
			switch(imgNum){
			case 0:
				return "img/circle.png";
			case 1:
				return "img/triangle.png";
			case 2:
				return "img/square.png";
			case 3:
				return "img/star.png";
			}
	   case "select":
		   switch(imgNum){
		   case 0:
			   return "img/selected_circle.png";
		   case 1:
			   return "img/selected_triangle.png";
		   case 2:
			   return "img/selected_square.png";
		   case 3:
			   return "img/selected_star.png";
		   }		   
		}
		return "Fail";
	}
   
	//이미지 셋팅하기
	public void setImage(int width, int height, int imgNum){
		this.imgNum = imgNum;
		try {
			Image img = ImageIO.read(getClass().getResource(selectImage("set", imgNum)));
			this.setIcon(new ImageIcon(img.getScaledInstance(width,height,Image.SCALE_SMOOTH)));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//게임오브젝트 선택시 선택 이미지로 변경
	public void selectObject(){
		Game_Board.selectedObject = this;
		try {
			Image img = ImageIO.read(getClass().getResource(selectImage("select", imgNum)));
			this.setIcon(new ImageIcon(img.getScaledInstance(this.getIcon().getIconWidth(),this.getIcon().getIconHeight(),Image.SCALE_SMOOTH)));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
   
	//동서남북 체크 후 이동여부 결정
	public void moveObject(){
		GameObject selected = Game_Board.selectedObject;
		int N = this.ROW - 1;
		int S = this.ROW + 1;
		int W = this.COL - 1;
		int E = this.COL + 1;
		
		if((selected.ROW == N && selected.COL == this.COL) || (selected.ROW == S && selected.COL == this.COL) || (selected.ROW == this.ROW && selected.COL == W) || (selected.ROW == this.ROW && selected.COL == E)){
			int tmp = imgNum;
			setImage(selected.getIcon().getIconWidth(), selected.getIcon().getIconHeight(), selected.imgNum);
			selected.setImage(this.getIcon().getIconWidth(), this.getIcon().getIconHeight(), tmp);
		}
		else{
			selected.setImage(selected.getIcon().getIconWidth(), selected.getIcon().getIconHeight(), selected.imgNum);
		}
		Game_Board.selectedObject = null;
		
		while(upper.Check() == 0);
	}
   
	//버튼 클릭 이벤트
	private class MyActionLitener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(Game_Board.selectedObject == null){
				selectObject();
			}
			else{
				moveObject();
			}
		}
	}
}

class Game_Board extends JPanel{
	private final int width, height;
	private final int ROW = 8, COL = 6, GAP = 5;
	private Random random = new Random();
	private Calendar oCalendar = Calendar.getInstance( );
	
	private GameObject gameObject[][] = new GameObject[ROW][COL];
	public static GameObject selectedObject;
   
	public Game_Board(int width, int height){
		this.width = width;
		this.height = height;
		this.getPreferredSize();//사이즈 설정
		this.setBackground(new Color(219,231,251));
		this.setLayout(new GridLayout(ROW, COL, GAP, GAP));
      
		//Create GameObject
		for(int row = 0; row < ROW; row++){
			for(int col = 0; col < COL; col++){
				gameObject[row][col] = new GameObject(row, col, this);
				this.add(gameObject[row][col]);
				gameObject[row][col].setImage(width/COL - GAP*2, height/ROW - GAP*2, 
												random.nextInt(4*oCalendar.get(Calendar.MILLISECOND))%4);
			}
		}
		while(this.Check() == 0);//터지는게 없을 때까지 반복 체크
	}
	
	@Override //패널 크기 지정
	public Dimension getPreferredSize(){
		return new Dimension(width, height);
	}

	//패널 전체 검사 후 스텍에 저장 -> 저장된 오브젝트의 이미지 변경
	public int Check(){
		GameObject checkedObject[] = new GameObject[ROW*COL];
		int checkNum = 0, pointer, counter = 0;
		
		//horizon check
		for(int row = 0; row < ROW; row++){
			pointer = 0;
			counter = 0;
			for(int col = 0; col < COL; col++){
				if(gameObject[row][pointer].imgNum != gameObject[row][col].imgNum){
					if(counter >= 2){
						for(int i = pointer; i < col; i++){
							checkedObject[checkNum++] = gameObject[row][i];
						}						
					}
					pointer = col;
					counter = 0;
				}
				else{
					counter++;
				}
			}//end of line
			//last image check
			if(counter >= 2){
				for(int i = pointer; i < COL; i++){
					checkedObject[checkNum++] = gameObject[row][i];
				}						
			}
		}//end of horizon
		
		//vertical check
		for(int col = 0; col < COL; col++){
			pointer = 0;
			counter = 0;
			for(int row = 0; row < ROW; row++){
				if(gameObject[pointer][col].imgNum != gameObject[row][col].imgNum){
					if(counter >= 2){
						for(int i = pointer; i < row; i++){
							checkedObject[checkNum++] = gameObject[i][col];
						}						
					}
					pointer = row;
					counter = 0;
				}
				else{
					counter++;
				}
			}//end of line
			//last image check
			if(counter >= 2){
				for(int i = pointer; i < ROW; i++){
					checkedObject[checkNum++] = gameObject[i][col];
				}						
			}
		}
		//end of vertical
		

		if(checkNum == 0){
			return -1;
		}
		
		//change
		for(checkNum--; checkNum >= 0; checkNum--){
			checkedObject[checkNum].setImage(width/COL - GAP*2, height/ROW - GAP*2, random.nextInt(4*oCalendar.get(Calendar.MILLISECOND))%4);
		}
		return 0;
	}
}

public class Game extends javax.swing.JFrame {

    /**
     * Creates new form game
     */
    public Game() {
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
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        levelLabel = new JLabel();
        scoreLabel = new JLabel();
        movecntLabel = new JLabel();
        itempanel = new JPanel();
        Main m = new Main();
        ItemSelect item = new ItemSelect();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("BubblePop :: Play");


        //javax.swing.GroupLayout gameBoardLayout = new javax.swing.GroupLayout(gameBoard);
        //gameBoard.setLayout(gameBoardLayout);
       // gameBoardLayout.setHorizontalGroup(
       //     gameBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
       // );
       // gameBoardLayout.setVerticalGroup(
       //     gameBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
       // );

        jLabel1.setText("난이도 ");

        jLabel2.setText("점수");

        jLabel3.setText("남은 횟수");

        jLabel4.setText("아이템");
        
        //levelLabel.setText(m.level);
        levelLabel.setText(m.level);
        scoreLabel.setText("null");
        movecntLabel.setText("null");

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
        	}	
        });
       
        
///////////////////////////////////////////////////////////////////////////////////////////////////////
        /********************/
        if(item.item1 == true)
        {
        	iButton1 = new JButton("하나 지우기");
        	iButton1.addActionListener(new ActionListener() {
        		public void actionPerformed(ActionEvent e) {
        			JOptionPane.showMessageDialog(null, "아이템 사용");
        		}
        	});
        	itempanel.add(iButton1);
        }
        if(item.item2 == true)
  	    { 
        	iButton2 = new JButton("배열 재생성");
  	  		iButton2.addActionListener(new ActionListener() {
  	  			public void actionPerformed(ActionEvent e) {
  	  				JOptionPane.showMessageDialog(null, "아이템 사용");
  	  			}
  	  		});
  	  		itempanel.add(iButton2);
  	    }
        if(item.item3 == true)
        {
        	iButton3 = new JButton("이동회수 바꾸기");
        	iButton3.addActionListener(new ActionListener() {
        		public void actionPerformed(ActionEvent e) {
        			JOptionPane.showMessageDialog(null, "아이템 사용");
        		}
        	});
        	  
        	itempanel.add(iButton3);
        }
        if(item.item4 == true)
        {
        	iButton4 = new JButton("힌트 보기");
        	iButton4.addActionListener(new ActionListener() {
        		public void actionPerformed(ActionEvent e) {
        			JOptionPane.showMessageDialog(null, "아이템 사용");
        		}
        	});
        	itempanel.add(iButton4);
        }
        if(item.item5 == true)
        {
        	iButton5 = new JButton("하나 바꾸기");
        	iButton5.addActionListener(new ActionListener() {
        		public void actionPerformed(ActionEvent e) {
        			JOptionPane.showMessageDialog(null, "아이템 사용");
        		}
        	});
        	itempanel.add(iButton5);
        }
        
        /********************/
        
        
        
        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2Layout.setHorizontalGroup(
        	jPanel2Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel2Layout.createSequentialGroup()
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(jPanel2Layout.createSequentialGroup()
        					.addGap(36)
        					.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
        						.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING, false)
        							.addGroup(jPanel2Layout.createSequentialGroup()
        								.addComponent(jLabel3)
        								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        								.addComponent(movecntLabel))
        							.addGroup(jPanel2Layout.createSequentialGroup()
        								.addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
        								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        								.addComponent(scoreLabel))
        							.addGroup(jPanel2Layout.createSequentialGroup()
        								.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
        								.addGap(29)
        								.addComponent(levelLabel)))
        						.addComponent(jLabel4)))
        				.addGroup(Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
        					.addContainerGap()
        					.addComponent(itempanel, GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)))
        			.addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
        	jPanel2Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel2Layout.createSequentialGroup()
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel1)
        				.addComponent(levelLabel))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel2)
        				.addComponent(scoreLabel))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel3)
        				.addComponent(movecntLabel))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(jLabel4)
        			.addGap(18)
        			.addComponent(itempanel, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
        			.addContainerGap())
        );
     
        
      
       // }
        jPanel2.setLayout(jPanel2Layout);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(gameBoard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(gameBoard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        
        

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
    private javax.swing.JLabel jLabel4;
    private Game_Board gameBoard;
    private javax.swing.JPanel jPanel2;
    private JLabel levelLabel;
    private JLabel scoreLabel;
    private JLabel movecntLabel;
    private JButton iButton1;
    private JButton iButton2;
    private JButton iButton3;
    private JButton iButton4;
    private JButton iButton5;
    private JPanel itempanel;
    
    // End of variables declaration                   
}
