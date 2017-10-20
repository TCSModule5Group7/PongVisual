package game;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class PongGame extends StateBasedGame {
	
	// GameState IDs
	public static final int GAMESTATE_MENU = 0;
	public static final int GAMESTATE_IN_GAME = 1;
	
	// Application Settings
	public static final int MAX_FPS = 60;
	public static final String GAME_TITLE = "Pong";

	public PongGame() {
		super(GAME_TITLE);
	}

	@Override
	public void initStatesList(GameContainer gc) throws SlickException {
		//addState(new MenuState());
		addState(new InGameState());
	}

}
