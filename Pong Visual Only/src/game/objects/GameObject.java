package game.objects;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import game.math.NormalizedPosition;
import game.math.NotInRangeException;

public abstract class GameObject {

	protected NormalizedPosition position;
	protected Image image;

	public GameObject(double x, double y, Image img) throws SlickException, NotInRangeException {
		position = new NormalizedPosition(x, y);
		image = img;
	}

	public void setPosition(double x, double y) {
		position.set(x, y);
	}

	public NormalizedPosition getPosition() {
		return position;
	}

	public Image getImage() {
		return image;
	}

	public void draw(Graphics g, int screenWidth, int screenHeight) {
		if (image != null) {
			g.drawImage(image, (float) (screenWidth * position.getX()), (float) (screenHeight * position.getY()));
		}
	}
}
