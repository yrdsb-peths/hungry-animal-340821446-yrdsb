import greenfoot.*;

public class Canvas extends Actor {
	private static java.awt.Color COLOR_FILL = new java.awt.Color(0, 255, 0, 64);
	private static java.awt.Color COLOR_STROKE = java.awt.Color.BLACK;

	private GreenfootImage image;
	private java.awt.Graphics2D graphics;
	private java.awt.geom.Path2D.Float path;
	private boolean isDrawing = false;

	public Canvas(int width, int height) {
		image = new GreenfootImage(width, height);
		setImage(image);
		graphics = image.getAwtImage().createGraphics();
		graphics.setBackground(new java.awt.Color(0, 0, 0, 0));
		graphics.setStroke(new java.awt.BasicStroke(
			10.0f,
			java.awt.BasicStroke.CAP_ROUND,
			java.awt.BasicStroke.JOIN_ROUND
		));
		path = new java.awt.geom.Path2D.Float();
	}

	private void drawPath() {
		graphics.clearRect(0, 0, 600, 400);
		graphics.setColor(COLOR_FILL);
		graphics.fill(path);
		graphics.setColor(COLOR_STROKE);
		graphics.draw(path);
	}

	public void act() {
		if (Greenfoot.mouseDragged(null)) {
			MouseInfo mouse = Greenfoot.getMouseInfo();
			int x = mouse.getX();
			int y = mouse.getY();
			if (isDrawing) {
				path.lineTo(x, y);
			} else {
				// If just starting to draw, set initial point with moveTo
				path.moveTo(x, y);
				isDrawing = true;
			}
			drawPath();
		}
		if (Greenfoot.mouseDragEnded(null)) {
			isDrawing = false;
			path.reset();
			graphics.clearRect(0, 0, 600, 400);
		}
	}
}
