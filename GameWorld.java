import greenfoot.*;

public class GameWorld extends World {
	public GameWorld() {
		// Create a new world with 600x400 cells with a cell size of 1x1 pixels.
		super(600, 400, 1);
		addObject(new Canvas(600, 400), 300, 200);
	}
}
