import java.awt.Color;
import java.awt.Graphics;

public class Projectile extends GameObject{
	int speed;
 public Projectile(int x, int y, int width, int height) {
	super(x, y, width, height);
	speed = 10;
 }
 void update(){

	 
	 }
	  void draw(Graphics g) {
	 	 g.setColor(Color.RED);
	 	 g.fillRect(x, y, width, height);
	  }
	 }


