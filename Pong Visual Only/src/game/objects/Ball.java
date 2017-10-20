package game.objects;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.ImageBuffer;
import org.newdawn.slick.SlickException;

import game.math.NotInRangeException;

public class Ball extends GameObject {

	public static final double SIZE = 0.03;

	public Ball() throws SlickException, NotInRangeException {
		super(0.5, 0.5, new ImageBuffer(0, 0).getImage());
	}

	@Override
	public void draw(Graphics g, int screenWidth, int screenHeight) {
		g.fillOval((float) (screenWidth * getPosition().getX()), (float) (screenHeight * getPosition().getY()), (int) (screenWidth * SIZE), (int) (screenWidth * SIZE));
	}

}
