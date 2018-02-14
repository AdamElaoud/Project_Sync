package gamestates;

import java.awt.Graphics2D;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import manager.GameStateManager;

public abstract class GameState implements MouseListener, MouseMotionListener {

	protected GameStateManager gsm;
	
	public GameState(GameStateManager gsm) {
		this.gsm = gsm;
	}
	
	public abstract void init();
	public abstract void tick();
	public abstract void render(Graphics2D g);
}
