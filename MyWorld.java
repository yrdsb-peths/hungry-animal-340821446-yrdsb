import greenfoot.*;

public class MyWorld extends World {
	public MyWorld() {
		// Create a new world with 600x400 cells with a cell size of 1x1 pixels.
		super(600, 400, 1);
		setPaintOrder(Fly.class, Mouse.class, Dot.class);
		addObject(new Mouse(), 300, 200);
		addObject(new Fly(), 20, 20);
		addObject(new Dot(), 50, 50);
		addObject(new Dot(), 550, 50);
		addObject(new Dot(), 50, 350);
		addObject(new Dot(), 550, 350);
	}
	
	public void act() {
		if (Greenfoot.mouseClicked(null)) {
			MouseInfo mouse = Greenfoot.getMouseInfo();
			Dot dot = new Dot();
			addObject(dot, mouse.getX(), mouse.getY());
		}
	}
}
