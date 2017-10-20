package game.objects;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import game.math.NotInRangeException;

public class Paddle extends GameObject {
	
	// stuff concerning side
	public final static boolean LEFT = true;
	public final static boolean RIGHT = false;
	private boolean side;
	
	// stuff concerning positioning
	public final static double OFFSET = 0.03125;

	public Paddle(boolean side) throws SlickException, NotInRangeException {
		super(0, 0, new Image("paddle.png"));
		this.side = side;
	}
	
	public void setPosition(double y) {
		if (side == LEFT) {
		super.setPosition(OFFSET, y);
		} else {
			super.setPosition(1.0-2*OFFSET, y);
		}
	}

	public boolean getSide() {
		return side;
	}
}
