package gamestates;

import java.awt.Graphics2D;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import data.DataStorage;
import main.Game;
import manager.GameStateManager;
import manager.MouseManager;

public abstract class GameState implements MouseListener, MouseMotionListener {
	
	protected final int WIDTH = Game.WIDTH;
	protected final int HEIGHT = Game.HEIGHT;
	protected final int SCALE = Game.SCALE;

	protected MouseManager mm;
	protected GameStateManager gsm;
	protected DataStorage storage;
	
	public GameState(GameStateManager gsm, MouseManager mm, DataStorage storage) {
		this.gsm = gsm;
		this.mm = mm;
		this.storage = storage;
	}
	
	public abstract void init();
	public abstract void tick();
	public abstract void render(Graphics2D g);
}
