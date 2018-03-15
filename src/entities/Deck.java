package entities;

import java.io.Serializable;
import java.util.Random;

public class Deck implements Serializable {

	private static final long serialVersionUID = -2789526004895896331L;
	
	private Random r;
	private Card[] cards;
	
	private String name;
	
	private Element primary;
	private Element secondary;
	private Element tertiary;
	
	private static final int PRIMARY = 0;
	private static final int SECONDARY = 1;
	private static final int TERTIARY = 2;
	
	public Deck() {
		cards = new Card[30];
		r = new Random();
	}
	
	public Deck(String name) {
		cards = new Card[30];
		r = new Random();
		
		this.name = name;
	}
	
	public Card draw () {
		int random = r.nextInt(cards.length);
		return cards[random];
	}
	
	public Card[] getCards() {
		return cards;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setElement(int selection, Element ele) {
		switch (selection) {
			case PRIMARY: 
				primary = ele;
				break;
			case SECONDARY: 
				secondary = ele;
				break;
			case TERTIARY:
				tertiary = ele;
				break;
		}
		
	}
	
	public Element getElement(int selection) {
		switch (selection) {
			case PRIMARY:
				return primary;
			case SECONDARY:
				return secondary;
			case TERTIARY:
				return tertiary;
		}
		
		return null;
	}
}
