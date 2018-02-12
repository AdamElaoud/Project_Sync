package manager;

import java.awt.Graphics2D;

import gamestates.EndMatchState;
import gamestates.GameState;
import gamestates.MenuState;
import gamestates.PauseState;
import gamestates.PlayTurnState;
import gamestates.SelectState;
import gamestates.StartupState;

public class GameStateManager {

	// PauseState
	private boolean paused;
	private PauseState pauseState;
	private MouseManager mm;
	
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
		pauseState = new PauseState(this);
		mm = new MouseManager();
		
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
				gameStates[state].init();
			case MENU: 
				gameStates[state] = new MenuState(this, mm);
				gameStates[state].init();
			case SELECT:
				gameStates[state] = new SelectState(this);
				gameStates[state].init();
			case PLAYTURN:
				gameStates[state] = new PlayTurnState(this);
				gameStates[state].init();
			case ENDMATCH:
				gameStates[state] = new EndMatchState(this);
				gameStates[state].init();
		}
	}
	
	// sets state to null
	public void unloadState(int state) {
		gameStates[state] = null;
	}
	
	//set paused
	public void setPaused(boolean set) {
		paused = set;
	}
	
	// if paused tick pauseState, otherwise tick currentState
	public void tick() {
		if (paused) {
			pauseState.tick();
		} else {
			if (gameStates[currentState] != null) {
				gameStates[currentState].tick();
			}
		}
	}
	
	// if paused render pauseState, otherwise render currentState
	public void render(Graphics2D g) {
		if (paused) {
			pauseState.render(g);
		} else {
			if (gameStates[currentState] != null) {
				gameStates[currentState].render(g);
			}
		}
	}
	
}
