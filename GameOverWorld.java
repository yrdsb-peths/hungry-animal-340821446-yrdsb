import greenfoot.*;

public class GameOverWorld extends World {
	public GameOverWorld() {
		// Create a new world with 600x400 cells with a cell size of 1x1 pixels.
		super(600, 400, 1);
		addObject(new Label("Game Over", 100), 300, 200);
		Greenfoot.stop();
	}
}
