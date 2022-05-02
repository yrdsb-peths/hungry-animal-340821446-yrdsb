import greenfoot.*;

public class Mouse extends Actor {
	private int velX = 2;
	private int velY = 1;

	public void act() {
		int newX = getX() + velX;
		int newY = getY() + velY;
		setLocation(newX, newY);
		World world = getWorld();
		if (newX <= 0 || newX >= world.getWidth() - 1)
			velX = -velX;
		if (newY <= 0 || newY >= world.getHeight() - 1)
			velY = -velY;
	}
}
