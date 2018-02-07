package gamestates;

import java.awt.Graphics2D;

import manager.GameStateManager;

public abstract class GameState {

	protected GameStateManager gsm;
	
	public GameState(GameStateManager gsm) {
		this.gsm = gsm;
	}
	
	public abstract void init();
	public abstract void tick();
	public abstract void render(Graphics2D g);
	public abstract void handleInput();
}
