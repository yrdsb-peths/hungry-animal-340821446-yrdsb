import greenfoot.*;

public class Mouse extends Actor {
	private int velX = 2;
	private int velY = 1;

	public void act() {
		// Get change in position, 4x if Space bar held
		int dx = velX;
		int dy = velY;
		if (Greenfoot.isKeyDown("space")) {
			dx *= 4;
			dy *= 4;
		}
		int newX = getX() + dx;
		int newY = getY() + dy;
		setLocation(newX, newY);
		// Bounce off of the edges of the world
		World world = getWorld();
		if (newX <= 0 || newX >= world.getWidth() - 1)
			velX = -velX;
		if (newY <= 0 || newY >= world.getHeight() - 1)
			velY = -velY;
		// Eat Dots
		world.removeObjects(getObjectsInRange(50, Dot.class));
	}
}
