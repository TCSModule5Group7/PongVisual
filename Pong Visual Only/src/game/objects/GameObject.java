package game.objects;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import game.math.NormalizedPosition;
import game.math.NotInRangeException;
import main.Main;

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

	public void draw(Graphics g) {
		if (image != null) {
			float width  = (float) (20 * Main.WIDTH / 1600);
			float height = (float) (200 * Main.HEIGHT / 900);
			float posX = (float) (Main.WIDTH * position.getX() - width / 2);
			float posY = (float) (Main.HEIGHT * position.getY() - height / 2);
			g.drawImage(image, posX, posY, posX + width, posY + height, 0, 0, image.getWidth(), image.getHeight());
		}
	}
}
