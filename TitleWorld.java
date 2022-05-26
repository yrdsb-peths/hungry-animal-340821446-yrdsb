import greenfoot.*;

public class TitleWorld extends World {
	public TitleWorld() {
		// Create a new world with 600x400 cells with a cell size of 1x1 pixels.
		super(600, 400, 1);
		addObject(new Label("Cheese Hunt", 100), 300, 200);
		addObject(new Label("Click to begin", 20), 300, 300);
	}

	public void act() {
		if (Greenfoot.mouseClicked(this)) {
			Greenfoot.setWorld(new GameWorld());
		}
	}
}
