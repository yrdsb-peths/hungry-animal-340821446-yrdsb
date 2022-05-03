import greenfoot.*;

public class MyWorld extends World {
	public MyWorld() {
		// Create a new world with 600x400 cells with a cell size of 1x1 pixels.
		super(600, 400, 1);
		Mouse mouse = new Mouse();
		addObject(mouse, 300, 200);
		Fly fly = new Fly();
		addObject(fly, 20, 20);
	}
	
	public void act() {
		if (Greenfoot.mouseClicked(null)) {
			MouseInfo mouse = Greenfoot.getMouseInfo();
			Dot dot = new Dot();
			addObject(dot, mouse.getX(), mouse.getY());
		}
	}
}
