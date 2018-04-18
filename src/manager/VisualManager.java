package manager;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

import main.Game;

public class VisualManager {
	
	private Rectangle deckBox;
	
	// Scale Values
	private int WIDTH = Game.WIDTH;
	private int HEIGHT = Game.HEIGHT;
	private int SCALE = Game.SCALE;
	
	// Deck Box Scales
	public int dW = 256;
	public int dH = 384;
	public int dist = 150;
	
	// print exceeds width message once
	private static int count = 0;
	
	public VisualManager() {
		deckBox = new Rectangle(256, 384);
		
	}
	
	public Rectangle getDeckBox() {
		return deckBox;
	}
	
	public void centerText(Graphics g, String string, int x, int y, Rectangle rect) {
		FontMetrics fm = g.getFontMetrics();
		Rectangle2D stringBounds = fm.getStringBounds(string, g);
		
		if (rect.getWidth() < stringBounds.getWidth() && count < 1) {
			System.out.println("String width exceeds width of bounding box!");
			count++;
		}
		
		int newX = ((int)rect.getWidth() - (int)stringBounds.getWidth()) / 2;
		int newY = ((int)rect.getHeight() - (int)stringBounds.getHeight()) / 2 + fm.getAscent();
		
		// outline box
//		g.setColor(Color.green);
//		g.drawRect(x, y, (int)rect.getWidth(), (int)rect.getHeight());
					
		g.setColor(Color.white);
		g.drawString(string, x + newX, y + newY);

	}

}
