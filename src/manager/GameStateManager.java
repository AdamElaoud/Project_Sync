package manager;

import java.awt.Graphics2D;

import data.DataStorage;
import gamestates.*;

public class GameStateManager {

	// PauseState
	private boolean paused;
	private PauseState pauseState;
	
	// Managers
	MouseManager mm;
	DataStorage storage;
	VisualManager vm;
	
	// GSM Setup
	private GameState[] gameStates;
	private int currentState;
	private int previousState;
	
	public static final int NUM_STATES = 11;
	public static final int STARTUP = 0;
	public static final int MENU = 1;
	public static final int SELECTCARD = 2;
	public static final int PLAYTURN = 3;
	public static final int ENDMATCH = 4;
	public static final int STARTMATCH = 5;
	public static final int SELECTDECK = 6;
	public static final int BUILDDECK = 7;
	public static final int SELECTELEMENTS = 8;
	public static final int SELECTRUNES = 9;
	public static final int FILLDECK = 10;
	
	// initialize the GSM
	public GameStateManager() {
		paused = false;
		pauseState = new PauseState(this, mm, storage, vm);
		
		mm = new MouseManager();
		storage = new DataStorage();
		vm = new VisualManager();		
		
		gameStates = new GameState[NUM_STATES];
		
		// set initial state
		setState(STARTUP);
	}
	
	public void setState(int state) {
		// unload previous state and set current state
		previousState = currentState;
		unloadState(previousState);
		currentState = state;
		
		System.out.println("Changed to state: " + state);
		
		switch(state) {
			case STARTUP: 
				gameStates[state] = new StartupState(this, mm, storage, vm);
				gameStates[state].init();
				break;
			case MENU: 
				gameStates[state] = new MenuState(this, mm, storage, vm);
				gameStates[state].init();
				break;
			case SELECTCARD:
				gameStates[state] = new SelectCardState(this, mm, storage, vm);
				gameStates[state].init();
				break;
			case PLAYTURN:
				gameStates[state] = new PlayTurnState(this, mm, storage, vm);
				gameStates[state].init();
				break;
			case ENDMATCH:
				gameStates[state] = new EndMatchState(this, mm, storage, vm);
				gameStates[state].init();
				break;
			case STARTMATCH:
				gameStates[state] = new StartMatchState(this, mm, storage, vm);
				gameStates[state].init();
				break;
			case SELECTDECK:
				gameStates[state] = new SelectDeckState(this, mm, storage, vm);
				gameStates[state].init();
				break;
			case BUILDDECK:
				gameStates[state] = new BuildDeckState(this, mm, storage, vm);
				gameStates[state].init();
				break;
			case SELECTELEMENTS:
				gameStates[state] = new SelectElementsState(this, mm, storage, vm);
				gameStates[state].init();
				break;
			case SELECTRUNES:
				gameStates[state] = new SelectRunesState(this, mm, storage, vm);
				gameStates[state].init();
			case FILLDECK:
				gameStates[state] = new FillDeckState(this, mm, storage, vm);
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
	
	// if paused, tick pauseState, otherwise tick currentState
	public void tick() {
		if (paused) {
			pauseState.tick();
		} else if (gameStates[currentState] != null) {
			gameStates[currentState].tick();
		}
	}
	
	// if paused, render pauseState, otherwise render currentState
	public void render(Graphics2D g) {
		if (paused) {
			pauseState.render(g);
		} else if (gameStates[currentState] != null) {
			gameStates[currentState].render(g);
		}
	}
	
	public GameState getCurrentState() {
		return gameStates[currentState];
	}
	
}
