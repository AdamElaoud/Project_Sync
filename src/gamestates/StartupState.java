package gamestates;

import java.awt.Graphics2D;

import manager.GameStateManager;

public class StartupState extends GameState {

	public StartupState(GameStateManager gsm) {
		super(gsm);
	}

	public void init() {
		// Will load logo in this method
	}

	public void tick() {
		// Will fade in logo in this method
		gsm.setState(GameStateManager.MENU);
	}

	public void render(Graphics2D g) {
		// Will display logo in this method
	}

	public void handleInput() {
		
	}

}
