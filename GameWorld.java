import greenfoot.*;

public class GameWorld extends World {
	private static final int CHEESE_INTERVAL = 1000;
	private SimpleTimer timer;

	public GameWorld() {
		// Create a new world with 600x400 cells with a cell size of 1x1 pixels.
		super(600, 400, 1);
		addObject(new Canvas(600, 400), 300, 200);

		timer = new SimpleTimer();
		addCheese();
	}

	private void addCheese() {
		int x = Greenfoot.getRandomNumber(600);
		int y = Greenfoot.getRandomNumber(400);
		addObject(new Cheese(), x, y);
		timer.mark();
	}

	public void act() {
		if (timer.millisElapsed() > CHEESE_INTERVAL) {
			addCheese();
		}
	}

	public void collectCheese(java.awt.geom.Path2D.Float path) {
		for (Cheese cheese : getObjects(Cheese.class)) {
			if (path.contains(cheese.getX(), cheese.getY())) {
				removeObject(cheese);
			}
		}
	}
}
