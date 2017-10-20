package game;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import networking.ReceivingServer;
import networking.SharedGameState;

public class InGameState extends BasicGameState {

	private SharedGameState sharedGS;
	
	@Override
	public void init(GameContainer gc, StateBasedGame game) throws SlickException {
		sharedGS = new SharedGameState();
		new Thread(new ReceivingServer(sharedGS)).start();
	}

	@Override
	public void render(GameContainer gc, StateBasedGame game, Graphics g) throws SlickException {
		g.drawString("Player 1: " + sharedGS.getLeftScore() + " | Player 2: " + sharedGS.getRightScore(), 700, 50);
		sharedGS.getBall().draw(g, gc.getScreenWidth(), gc.getScreenHeight());
		sharedGS.getLeftPaddle().draw(g, gc.getScreenWidth(), gc.getScreenHeight());
		sharedGS.getRightPaddle().draw(g, gc.getScreenWidth(), gc.getScreenHeight());
	}

	@Override
	public void update(GameContainer gc, StateBasedGame game, int timedelta) throws SlickException {
	}

	@Override
	public int getID() {
		return PongGame.GAMESTATE_IN_GAME;
	}
}
