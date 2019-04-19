import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ZeroCross extends Thread{
	JFrame f;
	JFrame aboutFrame;
	JMenuBar menuBar;
	boolean keyColor;
	JMenu menu = new JMenu("Menu"), help = new JMenu("Help");
	JMenuItem newGame, quit, about;
	JTextField tf1, tf2;
	JPanel p1;
	int cnt=1, co=1;
	//String str = ":::::: :::: :::::     :::::: :::::: :::::     :::::: ::::::  ::::::\n  ::    ::  ::          ::   ::  :: ::          ::   ::  ::  ::\n  ::    ::  ::    :::   ::   :::::: ::    :::   ::   ::  ::  :::::\n  ::    ::  ::          ::   ::  :: ::          ::   ::  ::  ::\n  ::   :::: :::::       ::   ::  :: :::::       ::   ::::::  ::::::";
	boolean flag=false, threadKey;
	JLabel label, t1, t2, t3, t4, t5, xScore, oScore, design;
	JLabel w1, w2, w3, w4;
	JButton b1, b2, b3, b4, b5, b6, b7, b8, b9;
	Button reset, playAgain, exit;
	public ZeroCross() {
		
		threadKey = true;
		keyColor = true;
		///design___________
		design = new JLabel(".               .               .               .               .");
		design.setBounds(223, 320, 300, 80);
		design.setForeground(Color.green);
		//design.setFont(new Font("Sans Serif", Font.BOLD, 13));
		
		
		
		//:::::::::Winnnnnnn___Label:::::::::::
		w1 = new JLabel("");
		w2 = new JLabel("");
		w3 = new JLabel("");
		w4 = new JLabel("");
		
		//label.setBounds(240, 400, 300, 80);
		//label.setForeground(Color.red);
		//label.setFont(new Font("Sans Serif", Font.BOLD, 22));
		
		w1.setBounds(273, 400, 300, 20);
		w2.setBounds(273, 410, 300, 20);
		w3.setBounds(273, 420, 300, 20);
		w4.setBounds(273, 430, 300, 20);		
		
		w1.setForeground(Color.yellow);
		w2.setForeground(Color.orange);
		w3.setForeground(Color.magenta);
		w4.setForeground(Color.red);
		
		w1.setVisible(false);
		w2.setVisible(false);
		w3.setVisible(false);
		w4.setVisible(false);

		//"""""""""""""exitttttttttttt:""""""""""""""""""
		exit = new Button("Quit");
		exit.setBounds(285, 545, 70, 40);
		exit.setForeground(Color.white);
		exit.setBackground(Color.black);
		exit.setVisible(false);
		
		exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
				
			}
		});
		
		//:_:_:_:_:_:_:scores_:_::_:_:_:_:_:__:_:_:___:_:_:_:
		tf1 = new JTextField();
		tf1.setBounds(60, 150, 70, 30);
		tf1.setText("0");
		tf1.setEditable(false);
		tf1.setForeground(Color.black);
		
		tf2 = new JTextField();
		tf2.setBounds(510, 150, 70, 30);
		tf2.setText("0");
		tf2.setEditable(false);
		tf2.setForeground(Color.black);
		
		tf1.setFont(new Font("Sans Serif", Font.BOLD, 15));
		tf2.setFont(new Font("Sans Serif", Font.BOLD, 15));
		
		tf1.setBackground(Color.ORANGE);
		tf2.setBackground(Color.ORANGE);
		
		xScore = new JLabel("X's Score :");
		oScore = new JLabel("0's Score :");
		xScore.setBounds(60, 117, 120, 35);
		oScore.setBounds(510, 117, 120, 35);
		
		xScore.setForeground(Color.white);
		oScore.setForeground(Color.white);
		
		xScore.setFont(new Font("Sans Serif", Font.ITALIC, 15));
		oScore.setFont(new Font("Sans Serif", Font.ITALIC, 15));
		
		xScore.setVisible(false);
		oScore.setVisible(false);
		tf1.setVisible(false);
		tf2.setVisible(false);
		
		
		///Tic-tac-toe design.....
		t1 = new JLabel(":::::: :::: :::::     :::::: :::::: :::::     :::::: ::::::  ::::::");
		t1.setBounds(185, -220, 500, 500);
		t1.setFont(new Font("Sans Serif", Font.BOLD, 15));
		t1.setForeground(Color.orange);
		
		t2 = new JLabel("  ::    ::  ::          ::   ::  :: ::          ::   ::  ::  ::");
		t2.setBounds(185, -210, 500, 500);
		t2.setFont(new Font("Sans Serif", Font.BOLD, 15));
		t2.setForeground(Color.MAGENTA);
		
		t3 = new JLabel("  ::    ::  ::    :::   ::   :::::: ::    :::   ::   ::  ::  :::::");
		t3.setBounds(185, -200, 500, 500);
		t3.setFont(new Font("Sans Serif", Font.BOLD, 15));
		t3.setForeground(Color.orange);
		
		t4 = new JLabel("  ::    ::  ::          ::   ::  :: ::          ::   ::  ::  ::");
		t4.setBounds(185, -190, 500, 500);
		t4.setFont(new Font("Sans Serif", Font.BOLD, 15));
		t4.setForeground(Color.red);
		
		t5 = new JLabel("  ::   :::: :::::       ::   ::  :: :::::       ::   ::::::  ::::::");
		t5.setBounds(185, -180, 500, 500);
		t5.setFont(new Font("Sans Serif", Font.BOLD, 15));
		t5.setForeground(Color.gray);
		
		menuBar = new JMenuBar();
		newGame = new JMenuItem("New Game");
		quit = new JMenuItem("Quit");
		about = new JMenuItem("About");
		
		// add menu items to Menu
		menu.add(newGame); menu.add(quit); menu.add(about);
		menuBar.add(menu); menuBar.add(help);
		
		
		label  = new JLabel("              Start");
		b1 = new JButton("");
		b2 = new JButton("");
		b3 = new JButton("");
		b4 = new JButton("");
		b5 = new JButton("");
		b6 = new JButton("");
		b7 = new JButton("");
		b8 = new JButton("");
		b9 = new JButton("");
		reset = new Button("Restart");
		reset.setVisible(false);
		reset.setFont(new Font("Sans Serif", Font.BOLD, 20));
		reset.setBackground(Color.black);
		reset.setForeground(Color.red);
		
		playAgain = new Button("Play Again");
		playAgain.setBounds(270, 480, 100, 45);
		playAgain.setVisible(false);
		playAgain.setFont(new Font("Sans Serif", Font.BOLD, 15));
		playAgain.setBackground(Color.black);
		playAgain.setForeground(Color.lightGray);
		
		label.setBounds(210, 375, 200, 50);
		label.setFont(new Font("Sans Serif", Font.BOLD, 23));
		label.setForeground(Color.blue);
		
		b1.setBackground(Color.LIGHT_GRAY);
		b2.setBackground(Color.LIGHT_GRAY);
		b3.setBackground(Color.LIGHT_GRAY);
		b4.setBackground(Color.LIGHT_GRAY);
		b5.setBackground(Color.LIGHT_GRAY);
		b6.setBackground(Color.LIGHT_GRAY);
		b7.setBackground(Color.LIGHT_GRAY);
		b8.setBackground(Color.LIGHT_GRAY);
		b9.setBackground(Color.LIGHT_GRAY);
		
		b1.setForeground(Color.black);
		b2.setForeground(Color.black);
		b3.setForeground(Color.black);
		b4.setForeground(Color.black);
		b5.setForeground(Color.black);
		b6.setForeground(Color.black);
		b7.setForeground(Color.black);
		b8.setForeground(Color.black);
		b9.setForeground(Color.black);
		
		///Button 1111111111111111
		b1.setBounds(200, 100, 80, 85);
		b1.setFont(new Font("Sans Serif", Font.BOLD, 40));
		b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(b1.getText().equals("") && flag==false)
				{
					reset.setVisible(true);
					if(cnt%2==1){
						label.setText("        Xero's Turn");
						b1.setText("X");
					}
					else{
						label.setText("       Cross's Turn");
						b1.setText("0");
					}
					checkWin();
					makeTrue(); // show Score
				}
			}
		});
		//BUTTON 2222222222222
		b2.setBounds(280, 100, 80, 85);
		b2.setFont(new Font("Sans Serif", Font.BOLD, 40));
		b2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(b2.getText().equals("") && flag==false)
				{
					reset.setVisible(true);
					if(cnt%2==1){
						label.setText("        Xero's Turn");
						b2.setText("X");
					}
					else{
						label.setText("       Cross's Turn");
						b2.setText("0");
					}
					checkWin();
					makeTrue(); // show Score
				}
				
			}
		});
		///BUTTON 3333333333333333333
		b3.setBounds(360, 100, 80, 85);
		b3.setFont(new Font("Sans Serif", Font.BOLD, 40));
		b3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(b3.getText().equals("") && flag==false)
				{
					reset.setVisible(true);
					if(cnt%2==1){
						label.setText("        Xero's Turn");
						b3.setText("X");
					}
					else{
						label.setText("       Cross's Turn");
						b3.setText("0");
					}
					checkWin();
					makeTrue(); // show Score
				}
				
			}
		});
		//BUTTON 44444444444444444444
		b4.setBounds(200, 185, 80, 85);
		b4.setFont(new Font("Sans Serif", Font.BOLD, 40));
		b4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(b4.getText().equals("") && flag==false)
				{
					reset.setVisible(true);
					if(cnt%2==1){
						label.setText("        Xero's Turn");
						b4.setText("X");
					}
					else{
						label.setText("       Cross's Turn");
						b4.setText("0");
					}
					checkWin();
					makeTrue(); // show Score
				}
				
			}
		});
		//BUTTON 555555555555555555555555
		b5.setBounds(280, 185, 80, 85);
		b5.setFont(new Font("Sans Serif", Font.BOLD, 40));
		b5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(b5.getText().equals("") && flag==false)
				{
					reset.setVisible(true);
					if(cnt%2==1){
						label.setText("        Xero's Turn");
						b5.setText("X");
					}
					else{
						label.setText("       Cross's Turn");
						b5.setText("0");
					}
					checkWin();
					makeTrue(); // show Score
				}
				
			}
		});
		// BUTTON 6666666666666666666
		b6.setBounds(360, 185, 80, 85);
		b6.setFont(new Font("Sans Serif", Font.BOLD, 40));
		b6.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(b6.getText().equals("") && flag==false)
				{
					reset.setVisible(true);
					if(cnt%2==1){
						label.setText("        Xero's Turn");
						b6.setText("X");
					}
					else{
						label.setText("       Cross's Turn");
						b6.setText("0");
					}
					checkWin();
					makeTrue(); // show Score
				}
				
			}
		});
		///BUTTON 777777777777777777777
		b7.setBounds(200, 270, 80, 85);
		b7.setFont(new Font("Sans Serif", Font.BOLD, 40));
		b7.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(b7.getText().equals("") && flag==false)
				{
					reset.setVisible(true);
					if(cnt%2==1){
						label.setText("        Xero's Turn");
						b7.setText("X");
					}
					else{
						label.setText("       Cross's Turn");
						b7.setText("0");
					}
					checkWin();
					makeTrue(); // show Score
				}
				
			}
		});
		//BUTTON 88888888888888888
		b8.setBounds(280, 270, 80, 85);
		b8.setFont(new Font("Sans Serif", Font.BOLD, 40));
		b8.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(b8.getText().equals("") && flag==false)
				{
					reset.setVisible(true);
					if(cnt%2==1){
						label.setText("        Xero's Turn");
						b8.setText("X");
					}
					else{
						label.setText("       Cross's Turn");
						b8.setText("0");
					}
					checkWin();
					makeTrue(); // show Score
				}
				
			}
		});
		//BUTTON 9999999999999999999999
		b9.setBounds(360, 270, 80, 85);
		b9.setFont(new Font("Sans Serif", Font.BOLD, 40));
		b9.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(b9.getText().equals("") && flag==false)
				{
					reset.setVisible(true);
					if(cnt%2==1){
						label.setText("        Xero's Turn");
						b9.setText("X");
					}
					else{
						label.setText("       Cross's Turn");
						b9.setText("0");
					}
					checkWin();
					makeTrue(); // show Score
				}
				
			}
		});
		
		///:::::::::::::::New Game :::::::::::::::::::::: 
		newGame.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setAll();
				reset.setVisible(false);
				playAgain.setVisible(false);
				exit.setVisible(false);
				tf1.setText("0");
				tf2.setText("0");
				
				xScore.setVisible(false);
				oScore.setVisible(false);
				tf1.setVisible(false);
				tf2.setVisible(false);
				
			}
		});
		
		
		//////////________________Quit::::::::
		quit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		playAgain.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setAll();
				playAgain.setVisible(false);
				exit.setVisible(false);
				
			}
		});
		/////***********RESET-BUTTON*********
		reset.setBounds(270, 480, 100, 45);
		reset.setFont(new Font("Sans Serif", Font.PLAIN, 15));
		reset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setAll();
			}
		});
		
		
		f = new JFrame("Tic-Tac-Toe");
		f.add(b1); f.add(b2); f.add(b3);
		f.add(b4); f.add(b5); f.add(b6);
		f.add(b7); f.add(b8); f.add(b9);
		f.add(label);
		f.add(reset);
		f.setSize(660, 665);
		f.setJMenuBar(menuBar);
		f.setLayout(null);
		f.setResizable(false);
		//f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		f.setVisible(true);
		f.add(playAgain);
		f.add(t1);
		f.add(t2);
		f.add(t3);
		f.add(t4);
		f.add(t5);
		f.add(tf1); f.add(tf2);
		f.add(xScore); f.add(oScore);
		f.getContentPane().setBackground(Color.black);
		f.add(exit);
		f.add(w1); f.add(w2); f.add(w3); f.add(w4);
		f.add(design);
		
		f.addWindowListener(new WindowAdapter() {
		    @Override
		    public void windowClosing(WindowEvent e) {
		       threadKey=false;
		       System.exit(0);
		    }
		});
	}
	
	private void setAll(){
		b1.setText("");
		b2.setText("");
		b3.setText("");
		b4.setText("");
		b5.setText("");
		b6.setText("");
		b7.setText("");
		b8.setText("");
		b9.setText("");
		keyColor = false;
		cnt=1;flag=false;
		label.setBounds(210, 375, 200, 50);
		label.setFont(new Font("Sans Serif", Font.BOLD, 23));
		label.setForeground(Color.blue);
		label.setText("              Start");
		label.setVisible(true);
		
		b1.setBackground(Color.LIGHT_GRAY);
		b2.setBackground(Color.LIGHT_GRAY);
		b3.setBackground(Color.LIGHT_GRAY);
		b4.setBackground(Color.LIGHT_GRAY);
		b5.setBackground(Color.LIGHT_GRAY);
		b6.setBackground(Color.LIGHT_GRAY);
		b7.setBackground(Color.LIGHT_GRAY);
		b8.setBackground(Color.LIGHT_GRAY);
		b9.setBackground(Color.LIGHT_GRAY);
		
		b1.setForeground(Color.black);
		b2.setForeground(Color.black);
		b3.setForeground(Color.black);
		b4.setForeground(Color.black);
		b5.setForeground(Color.black);
		b6.setForeground(Color.black);
		b7.setForeground(Color.black);
		b8.setForeground(Color.black);
		b9.setForeground(Color.black);
		
		w1.setVisible(false);
		w2.setVisible(false);
		w3.setVisible(false);
		w4.setVisible(false);
	}
	
	private void checkWin(){
		if(b1.getText().equals("X") && b2.getText().equals("X") && b3.getText().equals("X"))
		{
			checkPrint(); // print the winner
			
			b1.setBackground(Color.green);
			b2.setBackground(Color.green);
			b3.setBackground(Color.green);
			
			b1.setForeground(Color.red);
			b2.setForeground(Color.red);
			b3.setForeground(Color.red);
		}
		else if(b4.getText().equals("X") && b5.getText().equals("X") && b6.getText().equals("X"))
		{
			checkPrint(); // print the winner
				
			b4.setBackground(Color.green);
			b5.setBackground(Color.green);
			b6.setBackground(Color.green);
			
			b4.setForeground(Color.red);
			b5.setForeground(Color.red);
			b6.setForeground(Color.red);
		}
		else if(b7.getText().equals("X") && b8.getText().equals("X") && b9.getText().equals("X"))
		{
			checkPrint(); // print the winner
			
			b7.setBackground(Color.green);
			b8.setBackground(Color.green);
			b9.setBackground(Color.green);
			
			b7.setForeground(Color.red);
			b8.setForeground(Color.red);
			b9.setForeground(Color.red);
		}
		else if(b1.getText().equals("X") && b4.getText().equals("X") && b7.getText().equals("X"))
		{
			checkPrint(); // print the winner
			
			b1.setBackground(Color.green);
			b4.setBackground(Color.green);
			b7.setBackground(Color.green);
			
			b1.setForeground(Color.red);
			b4.setForeground(Color.red);
			b7.setForeground(Color.red);
		}
		else if(b2.getText().equals("X") && b5.getText().equals("X") && b8.getText().equals("X"))
		{
			checkPrint(); // print the winner
			
			b2.setBackground(Color.green);
			b5.setBackground(Color.green);
			b8.setBackground(Color.green);
			
			b2.setForeground(Color.red);
			b5.setForeground(Color.red);
			b8.setForeground(Color.red);
		}
		else if(b3.getText().equals("X") && b6.getText().equals("X") && b9.getText().equals("X"))
		{

			checkPrint(); // print the winner
			
			b3.setBackground(Color.green);
			b6.setBackground(Color.green);
			b9.setBackground(Color.green);
			
			b3.setForeground(Color.red);
			b6.setForeground(Color.red);
			b9.setForeground(Color.red);
		}
		else if(b1.getText().equals("X") && b5.getText().equals("X") && b9.getText().equals("X"))
		{
			checkPrint(); // print the winner
			
			b1.setBackground(Color.green);
			b5.setBackground(Color.green);
			b9.setBackground(Color.green);
			
			b1.setForeground(Color.red);
			b5.setForeground(Color.red);
			b9.setForeground(Color.red);
		}
		else if(b3.getText().equals("X") && b5.getText().equals("X") && b7.getText().equals("X"))
		{
			checkPrint(); // print the winner
			
			b3.setBackground(Color.green);
			b5.setBackground(Color.green);
			b7.setBackground(Color.green);
			
			b3.setForeground(Color.red);
			b5.setForeground(Color.red);
			b7.setForeground(Color.red);
		}
		
		//******check with Zero 0*********
		if(b1.getText().equals("0") && b2.getText().equals("0") && b3.getText().equals("0"))
		{
			checkPrint(); // print the winner
			
			b1.setBackground(Color.green);
			b2.setBackground(Color.green);
			b3.setBackground(Color.green);
			
			b1.setForeground(Color.red);
			b2.setForeground(Color.red);
			b3.setForeground(Color.red);
		}
		else if(b4.getText().equals("0") && b5.getText().equals("0") && b6.getText().equals("0"))
		{
			checkPrint(); // print the winner
			
			b4.setBackground(Color.green);
			b5.setBackground(Color.green);
			b6.setBackground(Color.green);
			
			b4.setForeground(Color.red);
			b5.setForeground(Color.red);
			b6.setForeground(Color.red);
		}
		else if(b7.getText().equals("0") && b8.getText().equals("0") && b9.getText().equals("0"))
		{
			checkPrint(); // print the winner
			
			b7.setBackground(Color.green);
			b8.setBackground(Color.green);
			b9.setBackground(Color.green);
			
			b7.setForeground(Color.red);
			b8.setForeground(Color.red);
			b9.setForeground(Color.red);
		}
		else if(b1.getText().equals("0") && b4.getText().equals("0") && b7.getText().equals("0"))
		{
			checkPrint(); // print the winner
			
			b1.setBackground(Color.green);
			b4.setBackground(Color.green);
			b7.setBackground(Color.green);
			
			b1.setForeground(Color.red);
			b4.setForeground(Color.red);
			b7.setForeground(Color.red);
		}
		else if(b2.getText().equals("0") && b5.getText().equals("0") && b8.getText().equals("0"))
		{
			checkPrint(); // print the winner
			
			b2.setBackground(Color.green);
			b5.setBackground(Color.green);
			b8.setBackground(Color.green);
			
			b2.setForeground(Color.red);
			b5.setForeground(Color.red);
			b8.setForeground(Color.red);
		}
		else if(b3.getText().equals("0") && b6.getText().equals("0") && b9.getText().equals("0"))
		{
			checkPrint(); // print the winner
			
			b3.setBackground(Color.green);
			b6.setBackground(Color.green);
			b9.setBackground(Color.green);
			
			b3.setForeground(Color.red);
			b6.setForeground(Color.red);
			b9.setForeground(Color.red);
		}
		else if(b1.getText().equals("0") && b5.getText().equals("0") && b9.getText().equals("0"))
		{
			checkPrint(); // print the winner
			
			b1.setBackground(Color.green);
			b5.setBackground(Color.green);
			b9.setBackground(Color.green);
			
			b1.setForeground(Color.red);
			b5.setForeground(Color.red);
			b9.setForeground(Color.red);
		}
		else if(b3.getText().equals("0") && b5.getText().equals("0") && b7.getText().equals("0"))
		{
			checkPrint(); // print the winner
			
			b3.setBackground(Color.green);
			b5.setBackground(Color.green);
			b7.setBackground(Color.green);
			
			b3.setForeground(Color.red);
			b5.setForeground(Color.red);
			b7.setForeground(Color.red);
		}
		else if(cnt==9 && flag==false){
			label.setBounds(238, 400, 300, 80);
			label.setForeground(Color.red);
			label.setFont(new Font("Sans Serif", Font.BOLD, 22));
			label.setText("Draw, Try Again!");
			reset.setVisible(false);
			playAgain.setVisible(true);
			exit.setVisible(true);
		}
		cnt++;
	}
	
	@Override
	public void run()
	{
		while(threadKey){
			try {
				fit();
				sleep(500);
				design.setVisible(false);
				t1.setBounds(175, -220, 500, 500);
				t2.setBounds(175, -210, 500, 500);
				t3.setBounds(175, -200, 500, 500);
				t4.setBounds(175, -190, 500, 500);
				t5.setBounds(175, -180, 500, 500);
				
				
				t1.setForeground(Color.magenta);
				t2.setForeground(Color.orange);
				t3.setForeground(Color.red);
				t4.setForeground(Color.gray);
				t5.setForeground(Color.green);
				
				unfit();
				sleep(500);
				design.setVisible(true);
				
				t1.setBounds(185, -220, 500, 500);
				t2.setBounds(185, -210, 500, 500);
				t3.setBounds(185, -200, 500, 500);
				t4.setBounds(185, -190, 500, 500);
				t5.setBounds(185, -180, 500, 500);
				
				t1.setForeground(Color.green);
				t2.setForeground(Color.magenta);
				t3.setForeground(Color.orange);
				t4.setForeground(Color.red);
				t5.setForeground(Color.gray);
				
				fit();
				sleep(500);
				design.setVisible(false);
				
				
				t1.setBounds(195, -220, 500, 500);
				t2.setBounds(195, -210, 500, 500);
				t3.setBounds(195, -200, 500, 500);
				t4.setBounds(195, -190, 500, 500);
				t5.setBounds(195, -180, 500, 500);
				
				t1.setForeground(Color.gray);
				t2.setForeground(Color.green);
				t3.setForeground(Color.magenta);
				t4.setForeground(Color.orange);
				t5.setForeground(Color.red);
				
				unfit();
				sleep(500);
				design.setVisible(true);
				
				
				t1.setBounds(185, -220, 500, 500);
				t2.setBounds(185, -210, 500, 500);
				t3.setBounds(185, -200, 500, 500);
				t4.setBounds(185, -190, 500, 500);
				t5.setBounds(185, -180, 500, 500);
				
				t1.setForeground(Color.red);
				t2.setForeground(Color.gray);
				t3.setForeground(Color.green);
				t4.setForeground(Color.magenta);
				t5.setForeground(Color.orange);
				
				fit();
				sleep(500);
				design.setVisible(false);
				
				t1.setForeground(Color.orange);
				t2.setForeground(Color.red);
				t3.setForeground(Color.gray);
				t4.setForeground(Color.green);
				t5.setForeground(Color.magenta);
				
				
			} catch (InterruptedException e) {
				//e.printStackTrace();
			}
		}
	}
	
	public void makeTrue()
	{
		xScore.setVisible(true);
		oScore.setVisible(true);
		tf1.setVisible(true);
		tf2.setVisible(true);
	}
	
	public void checkPrint()
	{
		keyColor=true;
		reset.setVisible(false);
		playAgain.setVisible(true);
		exit.setVisible(true);
		
		w1.setVisible(true);
		w2.setVisible(true);
		w3.setVisible(true);
		w4.setVisible(true);
		
//		label.setBounds(240, 400, 300, 80);
//		label.setForeground(Color.red);
		label.setVisible(false);
		label.setFont(new Font("Sans Serif", Font.BOLD, 22));
		if(cnt%2==1)
		{
			int temp= Integer.parseInt(tf1.getText());
			temp++;
			tf1.setText(String.valueOf(temp));
			//label.setText("      X   Wins!!");
			
			w1.setText(":   :    :     :   :::   :    :");
			w2.setText("  :      :  :  :  :   :  : :  :");
			w3.setText("  :      : : : :  :   :  :  : :");
			w4.setText(":   :     :   :    :::   :    :");
			
		}
		else
		{
			int temp= Integer.parseInt(tf2.getText());
			temp++;
			tf2.setText(String.valueOf(temp));
			//label.setText("      0   Wins!!");
			
			w1.setText(":::::    :     :   :::   :    :");
			w2.setText(":   :    :  :  :  :   :  : :  :");
			w3.setText(":   :    : : : :  :   :  :  : :");
			w4.setText(":::::     :   :    :::   :    :");
		}
		flag=true;
	}
	
	public void fit(){
		b1.setBounds(200, 100, 80, 85);
		b2.setBounds(280, 100, 80, 85);
		b3.setBounds(360, 100, 80, 85);
		b4.setBounds(200, 185, 80, 85);
		b5.setBounds(280, 185, 80, 85);
		b6.setBounds(360, 185, 80, 85);
		b7.setBounds(200, 270, 80, 85);
		b8.setBounds(280, 270, 80, 85);
		b9.setBounds(360, 270, 80, 85);
	}
	
	public void unfit(){
		b1.setBounds(199, 99, 80, 85);
		b2.setBounds(280, 99, 80, 85);
		b3.setBounds(361, 99, 80, 85);
		b4.setBounds(199, 185, 80, 85);
		b5.setBounds(280, 185, 80, 85);
		b6.setBounds(361, 185, 80, 85);
		b7.setBounds(199, 271, 80, 85);
		b8.setBounds(280, 271, 80, 85);
		b9.setBounds(361, 271, 80, 85);
	}
	
	public static void main(String[] args) {
		ZeroCross z = new ZeroCross();
		z.start();
	}
}