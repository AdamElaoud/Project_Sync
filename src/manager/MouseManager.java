package manager;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;

public class MouseManager {
	
	// some fields are static due to existence of 2 instances (Game.class and GameStateManager.class)
	public static final int NUM_BUTTONS = 2;
	
	public static boolean mouseState[] = new boolean[NUM_BUTTONS];
	public static boolean prevMouseState[] = new boolean[NUM_BUTTONS];
	
	public static final int LMB = 0;
	public static final int RMB = 1;
	
	private int mX;
	private int mY;


	// save values from mouseState in prevMouseState
	public void tick() {
		for (int i = 0; i < NUM_BUTTONS; i++) {
			prevMouseState[i] = mouseState[i];
		}
		
	}
	
	// sets value of buttons in mouseState
	public void mouseSet(int button, boolean set) {
		if (button == MouseEvent.BUTTON1) mouseState[LMB] = set;
		else if (button == MouseEvent.BUTTON3) mouseState[RMB] = set;
	}
	
	// currently up but was down
	public boolean isClicked(int button) {
		return !mouseState[button] && prevMouseState[button];
	}

	// currently down
	public boolean isDown(int button) {
		return mouseState[button];
	}

	// currently up
	public boolean isUp(int button) {
		return !mouseState[button];
	}
	
	// boundary check
	public boolean within(int mX, int mY, int x, int y, int width, int height) {
		if (mX >= x && mX <= x + width) {
			if (mY >= y && mY <= y + height) {
				return true;
			}
		}
		
		return false;
	}
	
	// Setters
	public void setMX(int mX) {
		this.mX = mX;
	}

	public void setMY(int mY) {
		this.mY = mY;
	}
	
	// Getters
	public int getMX() {
		return mX;
	}
	
	public int getmY() {
		return mY;
	}
	
}
