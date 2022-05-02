import greenfoot.*;

public class Fly extends Actor {
	public void act() {
		MouseInfo mouse = Greenfoot.getMouseInfo();
		if (mouse == null)
			return;
		turnTowards(mouse.getX(), mouse.getY());
		move(3);
	}
}
