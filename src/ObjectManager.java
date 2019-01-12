import java.awt.Graphics;
import java.util.ArrayList;

public class ObjectManager {
Rocketship ship;
ArrayList<Projectile> projectiles;
public ObjectManager(Rocketship bob){
	ship = bob;
	projectiles = new ArrayList<Projectile>();
}

void update(int arrow) {
	ship.update(arrow);
	for (int i = 0; i < projectiles.size(); i++) {
		projectiles.get(i).update();
	}
}
void draw(Graphics g) {
ship.draw(g);
for (int i = 0; i < projectiles.size(); i++) {
	projectiles.get(i).draw(g);
}
}
void addProjectile(Projectile p) {
	projectiles.add(p);
}
}
