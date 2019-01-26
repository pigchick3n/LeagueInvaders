import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
Rocketship ship;
ArrayList<Projectile> projectiles;
ArrayList<Alien> aliens;
long enemyTimer = 0;
int enemySpawnTime = 1000;
int score;
public ObjectManager(Rocketship bob){
	ship = bob;
	projectiles = new ArrayList<Projectile>();
	aliens  = new ArrayList<Alien>();
	score = 0;
}

void update(int arrow) {
	ship.update(arrow);
	for (int i = 0; i < projectiles.size(); i++) {
		projectiles.get(i).update();
	}
	for (int i = 0; i < aliens.size(); i++) {
		aliens.get(i).update();
	}
}
void draw(Graphics g) {
ship.draw(g);
for (int i = 0; i < projectiles.size(); i++) {
	projectiles.get(i).draw(g);
}
for (int i = 0; i < aliens.size(); i++) {
	aliens.get(i).draw(g);
}
}
void addProjectile(Projectile p) {
	projectiles.add(p);
}
void addAlien(Alien a) {
	aliens.add(a);
}
void manageEnemies() {
    if(System.currentTimeMillis() - enemyTimer >= enemySpawnTime){
        addAlien(new Alien(new Random().nextInt(LeagueInvaders.width), 0, 50, 50));

enemyTimer = System.currentTimeMillis();
}	
}
void purgeObjects() {
	for (int i = 0; i < projectiles.size(); i++) {
		if (projectiles.get(i).isAlive == false) {
			projectiles.remove(i);
		}
	}
	for (int i = 0; i < aliens.size(); i++) {
		if (aliens.get(i).isAlive == false) {
			aliens.remove(i);
		}
}
}
	void checkCollision(){

for(Alien a : aliens){
        if(ship.collisionBox.intersects(a.collisionBox)){
                ship.isAlive = false;
        }
        for (int i = 0; i < projectiles.size(); i++) {
			if(projectiles.get(i).collisionBox.intersects(a.collisionBox)){
				projectiles.get(i).isAlive = false;
				a.isAlive = false;
				score+=1;
			}
		}
       

}	

}
	
public int getScore() {
    return score;
}

}
