package game;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class MenuState extends BasicGameState {
	
	@Override
	public void init(GameContainer gc, StateBasedGame game) throws SlickException {
		
	}

	@Override
	public void render(GameContainer gc, StateBasedGame game, Graphics g) throws SlickException {
		g.drawString("Press SPACE to start game", 100, 100);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame game, int timedelta) throws SlickException {
		if (gc.getInput().isKeyDown(Input.KEY_SPACE)) {
			game.enterState(PongGame.GAMESTATE_IN_GAME);
		}
	}

	@Override
	public int getID() {
		return PongGame.GAMESTATE_MENU;
	}

}
