package main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

import gamestates.GameState;
import manager.GameStateManager;
import manager.MouseManager;

public class Game extends Canvas implements Runnable {
	
	// serialization
	private static final long serialVersionUID = -3286350852356844220L;
	
	// dimensions
	public static final int WIDTH = 1024;
	public static final int HEIGHT = 768;
	public static final int SCALE = 2;
	
	// game loop
	private Thread thread;
	private boolean running;
	private final int FPS = 30;
	private final int TARGET_TIME = 1000 / FPS;
	private GameState currentState;
	
	// render
	BufferStrategy bs;
	Graphics2D g;
	
	// managers
	GameStateManager gsm;
	MouseManager mm;

	public Game() {
		setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		// highlights the window without having to clicking on it
		setFocusable(true);
		requestFocus();
	}
	
	// launch
	public void addNotify() {
		super.addNotify();
		
		if (thread == null) {
			thread = new Thread(this);
			thread.start();
		}
	}

	@Override
	public void run() {
		init();
		
		long start;
		long elapsed;
		long wait;
		
		// game loop
		while(running) {
			
			start = System.nanoTime();
			
			// setup input
			if (currentState == null || currentState != gsm.getCurrentState()) {
				addMouseListener(gsm.getCurrentState());
				addMouseMotionListener(gsm.getCurrentState());
			}

			// process
			tick();
			render();
			
			elapsed = System.nanoTime() - start;
			
			wait = TARGET_TIME - elapsed / 1000000;
			if(wait < 0) wait = TARGET_TIME;
			
			try {
				Thread.sleep(wait);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
		}
	}
	
	// initialize fields
	private void init() {
		running = true;
		gsm = new GameStateManager();
		mm = new MouseManager();
	}
	
	private void tick() {
		gsm.tick();
		mm.tick();
	}
	
	private void render() {
		bs = getBufferStrategy();

		if (bs == null) {
			//Loads 3 frames at a time for smoother viewing, more buffered frames decreases performance, too few and graphics will appear choppy
			createBufferStrategy(3);
			return;
		}
		
		g = (Graphics2D) bs.getDrawGraphics();
		
		// set screen as black
		g.setColor(Color.black);
		// x and y coordinates are for displacement where top left corner is the origin
		g.fillRect(0, 0, WIDTH * SCALE, HEIGHT * SCALE);		
		
		gsm.render(g);
		
		// releases system resources being used
		g.dispose();
		// makes next available buffer visible
		bs.show();
	}
	
}
