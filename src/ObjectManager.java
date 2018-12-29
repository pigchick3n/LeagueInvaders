
public class ObjectManager {
Rocketship ship;
public ObjectManager(Rocketship bob){
	ship = bob;
}

void update() {
	ship.update();
}
}
