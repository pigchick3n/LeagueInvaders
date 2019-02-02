import java.awt.Color;
import java.awt.Graphics;

public class Alien extends GameObject{
	int speed;
public Alien(int x, int y, int width, int height) {
	super(x,y,width,height);
	speed=10;
}
void update() {
	super.update();
	y+=speed;
}
void draw(Graphics g) {
    g.drawImage(GamePanel.alienImg, x, y, width, height, null);
}
}
