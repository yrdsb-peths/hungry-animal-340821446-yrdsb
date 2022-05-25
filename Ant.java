import greenfoot.*;

public class Ant extends Actor {
	private SimpleTimer timer;
	private int speed;

	public Ant() {
		timer = new SimpleTimer();
		setSpeed();
	}

	private void setSpeed() {
		speed = Greenfoot.getRandomNumber(2) + 1;
		timer.mark();
	}

	public void act() {
		MouseInfo mouse = Greenfoot.getMouseInfo();
		if (mouse != null) {
			turnTowards(mouse.getX(), mouse.getY());
		}

		if (timer.millisElapsed() > 5000) {
			setSpeed();
		}
		move(speed);
	}
}
