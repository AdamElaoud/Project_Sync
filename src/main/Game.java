package main;

import java.awt.Dimension;

import javax.swing.JPanel;

public class Game extends JPanel {
	
	public final int WIDTH = 1024;
	public final int HEIGHT = 768;
	public final int SCALE = 1;

	public Game() {
		setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		// highlights the window without having to clicking on it
		setFocusable(true);
		requestFocus();
	}
}
