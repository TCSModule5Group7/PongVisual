package game.objects;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.ImageBuffer;
import org.newdawn.slick.SlickException;

import game.math.NotInRangeException;
import main.Main;

public class Score extends GameObject {

	public static final boolean LEFT = true;
	public static final boolean RIGHT = false;

	public static final int BLOCKSIZE = 5;

	private ImageBuffer imgBuf;
	private int score;

	public static final int[][][] numberRepresentations = {
			{ { 1, 1, 1 }, { 1, 0, 1 }, { 1, 0, 1 }, { 1, 0, 1 }, { 1, 1, 1 } }, // 0
			{ { 0, 0, 1 }, { 0, 0, 1 }, { 0, 0, 1 }, { 0, 0, 1 }, { 0, 0, 1 } }, // 1
			{ { 1, 1, 1 }, { 0, 0, 1 }, { 1, 1, 1 }, { 1, 0, 0 }, { 1, 1, 1 } }, // 2
			{ { 1, 1, 1 }, { 0, 0, 1 }, { 1, 1, 1 }, { 0, 0, 1 }, { 1, 1, 1 } }, // 3
			{ { 1, 0, 1 }, { 1, 0, 1 }, { 1, 1, 1 }, { 0, 0, 1 }, { 0, 0, 1 } }, // 4
			{ { 1, 1, 1 }, { 1, 0, 0 }, { 1, 1, 1 }, { 0, 0, 1 }, { 1, 1, 1 } }, // 5
			{ { 1, 1, 1 }, { 1, 0, 0 }, { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } }, // 6
			{ { 1, 1, 1 }, { 0, 0, 1 }, { 0, 0, 1 }, { 0, 0, 1 }, { 0, 0, 1 } }, // 7
			{ { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } }, // 8
			{ { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 }, { 0, 0, 1 }, { 1, 1, 1 } } // 9
	};

	public Score(boolean side) throws SlickException, NotInRangeException {
		super(0, 0, new ImageBuffer(0, 0).getImage());
		imgBuf = new ImageBuffer(11 * BLOCKSIZE, 5 * BLOCKSIZE);
		setScore(0);
		
		if (side == LEFT) {
			setPosition(BLOCKSIZE*11.0/1024,0.05);
		} else {
			setPosition(1.0-(2*BLOCKSIZE*11.0/1024),0.05);
		}
	}

	public void setScore(int sc) {
		score = sc % 1000; // discards thousands, millions, etc

		int hundreds = score / 100;
		int tens = (score - hundreds * 100) / 10;
		int ones = score - hundreds * 100 - tens * 10;

		// hundreds
		for (int x = 0; x < 3; x++) {
			for (int y = 0; y < 5; y++) {
				if (hundreds == 0 || numberRepresentations[hundreds][y][x] == 0) {
					fillBlock(x, y, 0, 0, 0);
				} else {
					fillBlock(x, y, 255, 255, 255);
				}
			}
		}

		// separator
		for (int y = 0; y < 5; y++) {
			fillBlock(3, y, 0, 0, 0);
		}

		// tens
		for (int x = 4, nr = 0; x < 7; x++, nr++) {
			for (int y = 0; y < 5; y++) {
				if ((hundreds == 0 && tens == 0) || numberRepresentations[tens][y][nr] == 0) {
					fillBlock(x, y, 0, 0, 0);
				} else {
					fillBlock(x, y, 255, 255, 255);
				}
			}
		}

		// separator
		for (int y = 0; y < 5; y++) {
			fillBlock(7, y, 0, 0, 0);
		}

		// ones
		for (int x = 8, nr = 0; x < 11; x++, nr++) {
			for (int y = 0; y < 5; y++) {
				if (numberRepresentations[ones][y][nr] == 0) {
					fillBlock(x, y, 0, 0, 0);
				} else {
					fillBlock(x, y, 255, 255, 255);
				}
			}
		}
	}

	public void draw(Graphics g) {
		int x = (int) (position.getX() * Main.WIDTH);
		int y = (int) (position.getY() * Main.HEIGHT);
		
		g.drawImage(imgBuf.getImage(), x, y);//,
				//x + 100, y + 50, 0, 0, imgBuf.getWidth(),
				//imgBuf.getHeight());
	}
	
	public void fill(int r, int g, int b) {
		for (int x = 0; x < imgBuf.getWidth(); x++) {
			for (int y = 0; y < imgBuf.getHeight(); y++) {
				imgBuf.setRGBA(x, y, r, g, b, 255);
			}
		}
	}
	
	private void fillBlock(int x, int y, int r, int g, int b) {
		for(int i = 0; i < BLOCKSIZE; i++) {
			for(int j = 0; j < BLOCKSIZE; j++) {
				imgBuf.setRGBA(x*BLOCKSIZE+i, y*BLOCKSIZE+j, r, g, b, 255);
			}
		}
	}

}
