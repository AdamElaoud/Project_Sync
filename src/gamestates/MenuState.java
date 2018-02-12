package gamestates;

import java.awt.Graphics2D;

import manager.GameStateManager;
import manager.MouseManager;

public class MenuState extends GameState {
	
	private MouseManager mm;	
	private String[] options = {
			"Play",
			"Deck Builder",
			"Quit"
	};

	public MenuState(GameStateManager gsm, MouseManager mm) {
		super(gsm);
		
		this.mm = mm;
	}

	public void init() {
		
	}

	public void tick() {
		
	}

	public void render(Graphics2D g) {
		
		
		
	}

	public void handleInput() {
		
	}

}
