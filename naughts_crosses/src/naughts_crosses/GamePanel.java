package naughts_crosses;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;


public class GamePanel extends JPanel implements ActionListener{
	
	static final int SCREEN_WIDTH = 600;
	static final int SCREEN_HEIGHT = 600;
	static final int DELAY = 75;
	final int x[] = new int[9];
	final int o[] = new int[9];
	ArrayList<String>  xList = new ArrayList<>();
	ArrayList<String>  oList = new ArrayList<>();
	boolean running = false;
	Timer timer;
	Random random;
	boolean topLeft = false;
	boolean topMid = false;
	boolean topRight = false;
	boolean midLeft = false;
	boolean middle = false;
	boolean midRight = false;
	boolean botLeft = false;
	boolean botMid = false;
	boolean botRight = false;
	boolean player1 = true;
	String winner;
	boolean isGameOver = false;
	
	GamePanel() {
		random = new Random();
		this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
		this.setBackground(Color.black);
		this.setFocusable(true);
		this.addKeyListener(new MyKeyAdapter());
		startGame();
	}

	public void startGame() {
		running = true;
		timer = new Timer(DELAY, this);
		timer.start();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		draw(g);
	}
	
	public void draw(Graphics g) {
		if (running) {
			for (int i = 1; i < SCREEN_HEIGHT/3; i++) {
				g.setColor(Color.white);
				g.drawLine(i*SCREEN_HEIGHT/3, 0, i*SCREEN_HEIGHT/3, SCREEN_HEIGHT);
				g.drawLine(0, i*SCREEN_HEIGHT/3, SCREEN_WIDTH, i*SCREEN_HEIGHT/3);
				
			for (int i1 = 0; i1 < xList.size(); i1++) {
				String element = xList.get(i1);
				g.setColor(Color.green);
				g.setFont(new Font("Ink Free", Font.BOLD, 200));
				FontMetrics metrics = getFontMetrics(g.getFont());
				switch (element) {
				case "TopLeft":
					g.drawString("X", 100 - metrics.stringWidth("X")/2, 160);
					break;
				case "TopMid":
					g.drawString("X", 300 - metrics.stringWidth("X")/2, 160);
					break;
				case "TopRight":
					g.drawString("X", 500 - metrics.stringWidth("X")/2, 160);
					break;
				case "MidLeft":
					g.drawString("X", 100 - metrics.stringWidth("X")/2, 360);
					break;
				case "Middle":
					g.drawString("X", 300 - metrics.stringWidth("X")/2, 360);
					break;
				case "MidRight":
					g.drawString("X", 500 - metrics.stringWidth("X")/2, 360);
					break;
				case "BotLeft":
					g.drawString("X", 100 - metrics.stringWidth("X")/2, 560);
					break;
				case "BotMid":
					g.drawString("X", 300 - metrics.stringWidth("X")/2, 560);
					break;
				case "BotRight":
					g.drawString("X", 500 - metrics.stringWidth("X")/2, 560);
					break;
				}
			}
			
			for (int i1 = 0; i1 < oList.size(); i1++) {
				String element = oList.get(i1);
				g.setColor(Color.red);
				g.setFont(new Font("Ink Free", Font.BOLD, 200));
				FontMetrics metrics = getFontMetrics(g.getFont());
				switch (element) {
				case "TopLeft":
					g.drawString("O", 100 - metrics.stringWidth("O")/2, 160);
					break;
				case "TopMid":
					g.drawString("O", 300 - metrics.stringWidth("O")/2, 160);
					break;
				case "TopRight":
				    g.drawString("O", 500 - metrics.stringWidth("O")/2, 160);
				    break;
				case "MidLeft":
				    g.drawString("O", 100 - metrics.stringWidth("O")/2, 360);
				    break;
				case "Middle":
				    g.drawString("O", 300 - metrics.stringWidth("O")/2, 360);
				    break;
				case "MidRight":
				    g.drawString("O", 500 - metrics.stringWidth("O")/2, 360);
				    break;
				case "BotLeft":
				    g.drawString("O", 100 - metrics.stringWidth("O")/2, 560);
				    break;
				case "BotMid":
				    g.drawString("O", 300 - metrics.stringWidth("O")/2, 560);
				    break;
				case "BotRight":
				    g.drawString("O", 500 - metrics.stringWidth("O")/2, 560);
				    break;
				    
					}
				
				}

			}
		}
		else {
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			gameOver(g);
		}
		
		if (isGameOver) {
			running = false;
		}

	}
	public void checkWinner() {
		// Player x winning combinations
	    if (xList.contains("TopLeft") && xList.contains("TopMid") && xList.contains("TopRight")) {
	        winner = "Player X wins!";
	        isGameOver = true;
	    } else if (xList.contains("MidLeft") && xList.contains("Middle") && xList.contains("MidRight")) {
	        winner = "Player X wins!";
	        isGameOver = true;
	    } else if (xList.contains("BotLeft") && xList.contains("BotMid") && xList.contains("BotRight")) {
	        winner = "Player X wins!";
	        isGameOver = true;
	    } else if (xList.contains("TopLeft") && xList.contains("MidLeft") && xList.contains("BotLeft")) {
	        winner = "Player X wins!";
	        isGameOver = true;
	    } else if (xList.contains("TopMid") && xList.contains("Middle") && xList.contains("BotMid")) {
	        winner = "Player X wins!";
	        isGameOver = true;
	    } else if (xList.contains("TopRight") && xList.contains("MidRight") && xList.contains("BotRight")) {
	        winner = "Player X wins!";
	        isGameOver = true;
	    } else if (xList.contains("TopLeft") && xList.contains("Middle") && xList.contains("BotRight")) {
	        winner = "Player X wins!";
	        isGameOver = true;
	    } else if (xList.contains("TopRight") && xList.contains("Middle") && xList.contains("BotLeft")) {
	        winner = "Player X wins!";
	        isGameOver = true;
	    }
	    
	    // Player O winning combinations
	    if (oList.contains("TopLeft") && oList.contains("TopMid") && oList.contains("TopRight")) {
	        winner = "Player O wins!";
	        isGameOver = true;
	    } else if (oList.contains("MidLeft") && oList.contains("Middle") && oList.contains("MidRight")) {
	        winner = "Player O wins!";
	        isGameOver = true;
	    } else if (oList.contains("BotLeft") && oList.contains("BotMid") && oList.contains("BotRight")) {
	        winner = "Player O wins!";
	        isGameOver = true;
	    } else if (oList.contains("TopLeft") && oList.contains("MidLeft") && oList.contains("BotLeft")) {
	        winner = "Player O wins!";
	        isGameOver = true;
	    } else if (oList.contains("TopMid") && oList.contains("Middle") && oList.contains("BotMid")) {
	        winner = "Player O wins!";
	        isGameOver = true;
	    } else if (oList.contains("TopRight") && oList.contains("MidRight") && oList.contains("BotRight")) {
	        winner = "Player O wins!";
	        isGameOver = true;
	    } else if (oList.contains("TopLeft") && oList.contains("Middle") && oList.contains("BotRight")) {
	        winner = "Player O wins!";
	        isGameOver = true;
	    } else if (oList.contains("TopRight") && oList.contains("Middle") && oList.contains("BotLeft")) {
	        winner = "Player O wins!";
	        isGameOver = true;
	    }
	    
	    if (xList.size() + oList.size() == 9) {
	    	winner = "It's a draw!";
	        isGameOver = true;
	    }
	    
	    if (!running) {
			timer.stop();
		}
	}
	
	public void gameOver(Graphics g) {
		g.setColor(Color.red);
		g.setFont(new Font("Ink Free", Font.BOLD, 60));
		FontMetrics metrics = getFontMetrics(g.getFont());
		g.drawString(winner, (SCREEN_WIDTH - metrics.stringWidth(winner))/2, SCREEN_HEIGHT/2);
	}

		
		
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (running) {
			checkWinner();
		}
		repaint();
	}
	
	public class MyKeyAdapter extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			switch(e.getKeyCode()) {
			case KeyEvent.VK_Q:
				if (topLeft == false) {
					topLeft = true;
					if (player1) {
						xList.add("TopLeft");	
					}
					else {
						oList.add("TopLeft");	
					}
					player1 = !player1;
				}
				break;
			case KeyEvent.VK_W:
				if (topMid == false) {
					topMid = true;
					if (player1) {
						xList.add("TopMid");	
					}
					else {
						oList.add("TopMid");	
					}
					player1 = !player1;
				}
				break;
			case KeyEvent.VK_E:
				if (topRight == false) {
					topRight = true;
					if (player1) {
						xList.add("TopRight");	
					}
					else {
						oList.add("TopRight");	
					}
					player1 = !player1;
				}
				break;
			case KeyEvent.VK_A:
				if (midLeft == false) {
					midLeft = true;
					if (player1) {
						xList.add("MidLeft");	
					}
					else {
						oList.add("MidLeft");	
					}
					player1 = !player1;
				}
				break;
			case KeyEvent.VK_S:
				if (middle == false) {
					middle = true;
					if (player1) {
						xList.add("Middle");	
					}
					else {
						oList.add("Middle");	
					}
					player1 = !player1;
				}
				break;
			case KeyEvent.VK_D:
				if (midRight == false) {
					midRight = true;
					if (player1) {
						xList.add("MidRight");	
					}
					else {
						oList.add("MidRight");	
					}
					player1 = !player1;
				}
				break;
			case KeyEvent.VK_Z:
				if (botLeft == false) {
					botLeft = true;
					if (player1) {
						xList.add("BotLeft");	
					}
					else {
						oList.add("BotLeft");	
					}
					player1 = !player1;
				}
				break;
			case KeyEvent.VK_X:
				if (botMid == false) {
					botMid = true;
					if (player1) {
						xList.add("BotMid");	
					}
					else {
						oList.add("BotMid");	
					}
					player1 = !player1;
				}
				break;
			case KeyEvent.VK_C:
				if (botRight == false) {
					botRight = true;
					if (player1) {
						xList.add("BotRight");	
					}
					else {
						oList.add("BotRight");	
					}
					player1 = !player1;
				}
				break;
				

			}
		}
	}

}
