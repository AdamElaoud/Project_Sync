package manager;

import java.awt.event.MouseEvent;

public class MouseManager {
	
	public static final int NUM_BUTTONS = 2;
	
	public static boolean mouseState[] = new boolean[NUM_BUTTONS];
	public static boolean prevMouseState[] = new boolean[NUM_BUTTONS];
	
	public static final int LMB = 0;
	public static final int RMB = 1;


	// save values from mouseState in prevMouseState
	public void tick() {
		for (int i = 0; i < NUM_BUTTONS; i++) {
			prevMouseState[i] = mouseState[i];
		}
	}
	
	// sets value of buttons in mouseState
	public void mouseSet(int button, boolean set) {
		if (button == MouseEvent.BUTTON1) mouseState[LMB] = set;
		else if (button == MouseEvent.BUTTON2) mouseState[RMB] = set;
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
}
