package game.objects;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.ImageBuffer;
import org.newdawn.slick.SlickException;

import game.math.NotInRangeException;
import main.Main;

public class Ball extends GameObject {
	
	public static final double SIZE = 20.0/1080.0;

	public Ball() throws SlickException, NotInRangeException {
		super(0.5, 0.5, new ImageBuffer(0, 0).getImage());
	}

	@Override
	public void draw(Graphics g) {
		g.fillOval((float) (Main.WIDTH * getPosition().getX() - SIZE / 2), (float) (Main.HEIGHT * getPosition().getY() - SIZE / 2),
				(int) (SIZE * Main.WIDTH), (int) (SIZE * Main.WIDTH));
	}

}
