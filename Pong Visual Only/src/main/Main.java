package main;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

import game.PongGame;

public class Main {
	public static void main(String[] args) {
		try {
			AppGameContainer appgc;
			appgc = new AppGameContainer(new PongGame());
			appgc.setDisplayMode(appgc.getScreenWidth(), appgc.getScreenHeight(), true);
			appgc.setShowFPS(false);
			appgc.setTargetFrameRate(PongGame.MAX_FPS);
			appgc.start();
		} catch (SlickException ex) {
			ex.printStackTrace();
		}
	}
}