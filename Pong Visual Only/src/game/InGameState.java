package game;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import game.gui.ControlFrame;
import networking.ReceivingServer;
import networking.SharedGameState;

public class InGameState extends BasicGameState {

	private SharedGameState sharedGS;
	
	@Override
	public void init(GameContainer gc, StateBasedGame game) throws SlickException {
		sharedGS = new SharedGameState();
		ReceivingServer server = new ReceivingServer(sharedGS);
		new ControlFrame(server).setVisible(true);
		new Thread(server).start();
	}

	@Override
	public void render(GameContainer gc, StateBasedGame game, Graphics g) throws SlickException {
		sharedGS.getBall().draw(g);
		sharedGS.getLeftPaddle().draw(g);
		sharedGS.getRightPaddle().draw(g);
		sharedGS.getLeftScore().draw(g);
		sharedGS.getRightScore().draw(g);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame game, int timedelta) throws SlickException {
	}

	@Override
	public int getID() {
		return PongGame.GAMESTATE_IN_GAME;
	}
}
