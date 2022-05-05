import greenfoot.*;

public class Mouse extends Actor {
	private int velX = 2;
	private int velY = 1;

	private boolean manualControl = false;

	public void act() {
		// Toggle manual control if m pressed
		String key = Greenfoot.getKey();
		if (key != null && key.equals("m"))
			manualControl = !manualControl;
		// Get change in position
		int dx = 0;
		int dy = 0;
		if (manualControl) {
			if (Greenfoot.isKeyDown("up") || Greenfoot.isKeyDown("w"))
				dy -= 2;
			if (Greenfoot.isKeyDown("down") || Greenfoot.isKeyDown("s"))
				dy += 2;
			if (Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("a"))
				dx -= 2;
			if (Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("d"))
				dx += 2;
		} else {
			dx = velX;
			dy = velY;
		}
		// Turbo mouse: 4x speed if Space bar held
		if (Greenfoot.isKeyDown("space")) {
			dx *= 4;
			dy *= 4;
		}
		int newX = getX() + dx;
		int newY = getY() + dy;
		setLocation(newX, newY);
		World world = getWorld();
		if (!manualControl) {
			// Bounce off of the edges of the world
			if (newX <= 0 || newX >= world.getWidth() - 1)
				velX = -velX;
			if (newY <= 0 || newY >= world.getHeight() - 1)
				velY = -velY;
		}
		// Eat Dots
		world.removeObjects(getObjectsInRange(50, Dot.class));
	}
}
