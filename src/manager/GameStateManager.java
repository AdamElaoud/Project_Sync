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
	
	// initialize the GSM
	public GameStateManager() {
		paused = false;
		
		gameStates = new GameState[NUM_STATES];
		
		// set initial state
		setState(STARTUP);
	}
	
	public void setState(int state) {
		// unload previous state and set current state
		previousState = currentState;
		unloadState(previousState);
		currentState = state;
		
		switch(state) {
			case STARTUP: 
				gameStates[state] = new StartupState(this);
				gameStates[state].init()
			case MENU: 
				gameStates[state] = new MenuState(this);
				gameStates[state].init()
			case SELECT:
				gameStates[state] = new SelectState(this);
				gameStates[state].init()
			case PLAYTURN:
				gameStates[state] = new PlayTurnState(this);
				gameStates[state].init()
			case ENDMATCH:
				gameStates[state] = new EndMatchState(this);
				gameStates[state].init()
		}
	}
	
	// sets state to null
	public void unloadState(int state) {
		gameStates[state] = null;
	}
	
}
