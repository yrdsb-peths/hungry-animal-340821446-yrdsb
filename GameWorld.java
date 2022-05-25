import greenfoot.*;

public class GameWorld extends World {
	private static final int CHEESE_INTERVAL = 1000;
	private SimpleTimer timer;
	private Label scoreLabel;
	private int score = 0;

	public GameWorld() {
		// Create a new world with 600x400 cells with a cell size of 1x1 pixels.
		super(600, 400, 1);
		addObject(new Mouse(), 100, 100);
		addObject(new Ant(), 100, 100);
		addObject(new Canvas(600, 400), 300, 200);

		timer = new SimpleTimer();
		addCheese();

		scoreLabel = new Label(score, 50);
		addObject(scoreLabel, 50, 50);
	}

	private void updateScore(int addition) {
		score += addition;
		scoreLabel.setValue(score);
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

	public void capture(java.awt.geom.Path2D.Float path) {
		for (Object object : getObjects(null)) {
			Actor actor = (Actor) object;
			if (path.contains(actor.getX(), actor.getY())) {
				if (Cheese.class.isInstance(actor)) {
					removeObject(actor);
					updateScore(1);
				} else if (Mouse.class.isInstance(actor) || Ant.class.isInstance(actor)) {
					updateScore(-10);
				}
			}
		}
	}
}
