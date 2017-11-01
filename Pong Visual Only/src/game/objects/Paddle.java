package game.objects;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import game.math.NotInRangeException;
import main.Main;

public class Paddle extends GameObject {

	// stuff concerning side
	public final static boolean LEFT = true;
	public final static boolean RIGHT = false;
	private boolean side;

	// stuff concerning positioning
	public static final double OFFSET = 0.1;

	public Paddle(boolean side) throws SlickException, NotInRangeException {
		super(0, 0, new Image("paddle.png"));
		this.side = side;
		this.setPosition(0.4);
	}

	public void setPosition(double y) {
		if (side == LEFT) {
			super.setPosition(OFFSET, y);
		} else {
			super.setPosition(1.0 - OFFSET - 50 / Main.WIDTH, y);
		}
	}

	public boolean getSide() {
		return side;
	}
}
