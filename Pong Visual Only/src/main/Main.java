package main;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

import game.PongGame;

public class Main {
	
	public static final int WIDTH = 1024;
	public static final int HEIGHT = 768;
	
	public static void main(String[] args) {
		try {
			AppGameContainer appgc;
			appgc = new AppGameContainer(new PongGame());
			appgc.setDisplayMode(WIDTH, HEIGHT, false);
			appgc.setShowFPS(false);
			appgc.setTargetFrameRate(PongGame.MAX_FPS);
			appgc.start();
		} catch (SlickException ex) {
			ex.printStackTrace();
		}
	}
}