package main;

import java.awt.Dimension;

import javax.swing.JPanel;

public class Game extends JPanel {
	
	// dimensions
	public static final int WIDTH = 1024;
	public static final int HEIGHT = 768;
	public static final int SCALE = 2;
	
	// game loop
	private Thread thread;
	private boolean running;

	public Game() {
		setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		// highlights the window without having to clicking on it
		setFocusable(true);
		requestFocus();
	}
}
