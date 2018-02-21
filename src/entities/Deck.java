package entities;

import java.io.Serializable;
import java.util.Random;

public class Deck implements Serializable {

	private static final long serialVersionUID = -2789526004895896331L;
	
	private Random r;
	private Card[] cards;
	private Element primary;
	private Element secondary;
	private Element tertiary;
	
	public Deck() {
		cards = new Card[30];
		r = new Random();
	}
	
	public Card draw () {
		int random = r.nextInt(cards.length);
		return cards[random];
	}
}
