import greenfoot.*;
import java.util.ArrayList;

public class GameWorld extends World {
	private static final int CHEESE_INTERVAL = 1000;
	private SimpleTimer timer;
	private Label scoreLabel;
	private int score = 0;
	private int lives = 3;
	private ArrayList<Heart> hearts;

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
		hearts = new ArrayList<Heart>();
		addHearts();
	}

	private void updateScore(int addition) {
		score += addition;
		scoreLabel.setValue(score);
	}

	private void loseLife() {
		lives--;
		if (lives <= 0) {
			Greenfoot.setWorld(new GameOverWorld());
		}
		removeObjects(hearts);
		hearts.clear();
		addHearts();
	}

	private void addHearts() {
		for (int i = 0; i < lives; i++) {
			Heart heart = new Heart();
			hearts.add(heart);
			addObject(heart, 450 + i * 50, 50);
		}
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
		for (Cheese cheese: getObjects(Cheese.class)) {
			if (path.contains(cheese.getX(), cheese.getY())) {
				removeObject(cheese);
				updateScore(1);
			}
		}
		for (Mouse mouse : getObjects(Mouse.class)) {
			if (path.contains(mouse.getX(), mouse.getY())) {
				loseLife();
			}
		}
		for (Ant ant : getObjects(Ant.class)) {
			if (path.contains(ant.getX(), ant.getY())) {
				loseLife();
			}
		}
	}
}
