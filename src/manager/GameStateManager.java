package manager;

import gamestates.*;

public class GameStateManager {

	// PauseState
	private boolean paused;
	private PauseState pauseState;
	
	// GSM Setup
	private GameState[] gameStates;
	private int currentState;
	private int previousState;
	
	public static final int NUM_STATES = 5;
	public static final int STARTUP = 0;
	public static final int MENU = 1;
	public static final int SELECT = 2;
	public static final int PLAYTURN = 3;
	public static final int ENDMATCH = 4;
	
	
}
