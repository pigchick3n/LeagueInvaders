import java.awt.Dimension;

import javax.swing.JFrame;

public class LeagueInvaders {
	JFrame frame;
	static int height = 800;
	static int width = 500;
	GamePanel gp;
public static void main(String[] args) {
	LeagueInvaders li = new LeagueInvaders();
	li.setup();
}
public LeagueInvaders(){
	frame = new JFrame();
	gp = new GamePanel();
}
void setup() {
	frame.addKeyListener(gp);
	frame.add(gp);
	frame.setVisible(true);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().setPreferredSize(new Dimension(width, height));
	frame.pack();
	gp.startGame();
}
}

