package entities;

import java.awt.Graphics2D;

public interface Card {
	
	public int numCopies();
	public void render(Graphics2D g);
	public void mechanics();
}
