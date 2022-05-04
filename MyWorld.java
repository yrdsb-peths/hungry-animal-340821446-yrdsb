import greenfoot.*;

public class MyWorld extends World {
	private static final int DOT_INTERVAL = 100;

	private int dotCountdown = DOT_INTERVAL;

	public MyWorld() {
		// Create a new world with 600x400 cells with a cell size of 1x1 pixels.
		super(600, 400, 1);
		setPaintOrder(Text.class, Fly.class, Mouse.class, Dot.class);
		addObject(new Text("Click to add dots"), 300, 20);
		addObject(new Text("Hold the Space bar for turbo mouse"), 300, 40);
		addObject(new Mouse(), 300, 200);
		addObject(new Fly(), 20, 20);
		for (int i = 0; i < 6; i++)
			addDot();
	}

	private void addDot() {
		addObject(new Dot(), Greenfoot.getRandomNumber(600), Greenfoot.getRandomNumber(400));
	}

	public void act() {
		if (dotCountdown == 0) {
			addDot();
			dotCountdown = DOT_INTERVAL;
		} else {
			dotCountdown--;
		}
		if (Greenfoot.mouseClicked(null)) {
			MouseInfo mouse = Greenfoot.getMouseInfo();
			Dot dot = new Dot();
			addObject(dot, mouse.getX(), mouse.getY());
		}
	}
}
