import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	Timer t;
	Rocketship rs;
	ObjectManager om;
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	int currentState = 0;
	Font titleFont;
	Font enterFont;
	Font instrucFont;
	int enemies = 0;

	public GamePanel() {
		t = new Timer(1000 / 60, this);
		rs = new Rocketship(250,700,50,50);
		om = new ObjectManager(rs);
		titleFont = new Font("Arial", Font.PLAIN, 48);
		enterFont = new Font("Arial", Font.PLAIN, 25);
		instrucFont = new Font("Arial", Font.PLAIN, 25);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (currentState == MENU_STATE) {
			updateMenuState();
		} else if (currentState == GAME_STATE) {
			updateGameState(5);
		} else if (currentState == END_STATE) {
			updateEndState();
		}
		repaint();

	}

	void startGame() {
		t.start();
	}

	@Override

	public void paintComponent(Graphics g) {
		if (currentState == MENU_STATE) {
			drawMenuState(g);
		} else if (currentState == GAME_STATE) {
			drawGameState(g);
		} else if (currentState == END_STATE) {
			drawEndState(g);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("sup");
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int keycode = e.getKeyCode();
		// TODO Auto-generated method stub
		System.out.println(keycode);
		if ((keycode == 10) && (currentState == MENU_STATE)) {
			currentState = GAME_STATE;
		} else if ((keycode == 10) && (currentState == GAME_STATE)) {
			currentState = END_STATE;

		} else if ((keycode == 10) && (currentState == END_STATE)) {
			currentState = MENU_STATE;
		}
		
		if((currentState == GAME_STATE)&&(keycode == 37)) {
			updateGameState(1);
		}else if((currentState == GAME_STATE)&&(keycode == 39)) {
			updateGameState(2);
		}else if((currentState == GAME_STATE)&&(keycode == 38)) {
			updateGameState(3);
		}else if((currentState == GAME_STATE)&&(keycode == 40)) {
			updateGameState(4);
		}
		if((currentState == GAME_STATE)&&(keycode == 32)) {
			om.addProjectile(new Projectile(rs.x+25, rs.y, 10, 10));
	}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("oof");
	}

	void updateMenuState() {

	}

	void updateGameState(int arrow) {
		
		om.update(arrow);
		
	}

	void updateEndState() {

	}

	void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, LeagueInvaders.width, LeagueInvaders.height);
		g.setColor(Color.YELLOW);
		g.setFont(titleFont);
		g.drawString("LEAGUE INVADERS", 25, 200);
		g.setFont(enterFont);
		g.drawString("Press ENTER to start", 120, 350);
		g.setFont(instrucFont);
		g.drawString("Press SPACE for instructions", 75, 600);

	}

	void drawGameState(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, LeagueInvaders.width, LeagueInvaders.height);
		om.draw(g);
	}

	void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, LeagueInvaders.width, LeagueInvaders.height);
		g.setColor(Color.BLACK);
		g.setFont(titleFont);
		g.drawString("GAME OVER", 25, 200);
		g.setFont(enterFont);
		g.drawString("You killed " + enemies + " enemies", 120, 350);
		g.setFont(instrucFont);
		g.drawString("Press ENTER to start", 75, 600);
	}
}
