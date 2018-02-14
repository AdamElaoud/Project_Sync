package entities;

import java.awt.Graphics2D;

public interface Card {
	
	public abstract void render(Graphics2D g);
	public abstract void mechanics();
}
