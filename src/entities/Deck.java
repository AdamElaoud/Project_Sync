package entities;

import java.util.Random;

public class Deck {

	private Random r;
	private Card[] cards;
	
	public Deck() {
		cards = new Card[30];
		r = new Random();
	}
	
	public Card draw () {
		int random = r.nextInt(cards.length);
		return cards[random];
	}
}
