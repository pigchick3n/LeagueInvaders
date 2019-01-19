import java.awt.Color;
import java.awt.Graphics;

public class Rocketship extends GameObject{
int speed;
	public Rocketship(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
		speed = 20;
	}
 void update(int arrow){
	 super.update();
if (arrow == 1) {
	x-=speed;
}else if (arrow == 2) {
	x+=speed;
}else if (arrow == 3) {
	y-=speed;
}else if (arrow == 4) {
	y+=speed;
}
}
 void draw(Graphics g) {
	 g.setColor(Color.BLUE);
	 g.fillRect(x, y, width, height);
 }
}
