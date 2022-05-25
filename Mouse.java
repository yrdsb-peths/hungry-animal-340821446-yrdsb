import greenfoot.*;

public class Mouse extends Actor {
	private SimpleTimer timer;
	private double x;
	private double y;
	private double speedX;
	private double speedY;

	public Mouse() {
		timer = new SimpleTimer();
	}

	protected void addedToWorld(World world) {
		x = (double) getX();
		y = (double) getY();
		reorient();
	}

	private void reorient() {
		speedX = (double) (Greenfoot.getRandomNumber(40) - 20) / 10.0;
		speedY = (double) (Greenfoot.getRandomNumber(40) - 20) / 10.0;
		timer.mark();
	}

	public void act() {
		if (timer.millisElapsed() > 3000) {
			reorient();
		} else if (isAtEdge()) {
			speedX = -speedX;
			speedY = -speedY;
		}
		x += speedX;
		y += speedY;
		setLocation((int) x, (int) y);
	}
}
