import java.awt.Graphics;

public class ObjectManager {
Rocketship ship;
public ObjectManager(Rocketship bob){
	ship = bob;
}

void update(int arrow) {
	ship.update(arrow);
}
void draw(Graphics g) {
ship.draw(g);
}
}
