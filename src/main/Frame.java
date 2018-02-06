package main;

import javax.swing.JFrame;

public class Frame {

	public void main (String args[]) {
		JFrame window = new JFrame("Project Sync");
		
		window.add(new Game());
		
		window.setResizable(false);
		window.pack();
		
		// generate window in center of screen
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		// closing window stops program
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
