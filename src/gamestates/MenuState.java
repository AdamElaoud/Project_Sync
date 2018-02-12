package gamestates;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import main.Game;
import manager.GameStateManager;

public class MenuState extends GameState {
	
	private String[] options = {
			"Play",
			"Deck Builder",
			"Quit"
	};

	public MenuState(GameStateManager gsm) {
		super(gsm);
		
	}

	public void init() {
	}

	public void tick() {
		
	}

	public void render(Graphics2D g) {
		g.setColor(Color.white);
		g.drawRect(Game.WIDTH / 2 - 50, Game.HEIGHT / 2 - 25, 100, 50);
		
		
	}

	public void handleInput() {
		
	}

}
