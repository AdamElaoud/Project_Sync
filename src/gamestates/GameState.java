package gamestates;

import java.awt.Graphics2D;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import manager.GameStateManager;
import manager.MouseManager;

public abstract class GameState implements MouseListener, MouseMotionListener {

	protected MouseManager mm;
	protected GameStateManager gsm;
	
	public GameState(GameStateManager gsm, MouseManager mm) {
		this.gsm = gsm;
		this.mm = mm;
	}
	
	public abstract void init();
	public abstract void tick();
	public abstract void render(Graphics2D g);
}
