import greenfoot.*;

public class MyWorld extends World {
	public MyWorld() {
		// Create a new world with 600x400 cells with a cell size of 1x1 pixels.
		super(600, 400, 1);
		Mouse mouse = new Mouse();
		addObject(mouse, 300, 200);
	}
}
