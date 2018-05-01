package entities;

import java.io.Serializable;
import java.util.Random;

import entities.runes.MinorRune;
import entities.runes.Rune;

public class Deck implements Serializable {

	private static final long serialVersionUID = -2789526004895896331L;
	
	private Random r;
	private Card[] cards;
	
	private int id;
	private static int idCount = 0;
	
	private String name;
	
	private Element primary;
	private Element secondary;
	private Element tertiary;
	
	private Rune majorRune;
	private Rune minorRune;
	
	private static final int PRIMARY = 0;
	private static final int SECONDARY = 1;
	private static final int TERTIARY = 2;
	
	public Deck() {
		cards = new Card[40];
		r = new Random();
	}
	
	public Deck(String name) {
		incrementId();
		id = idCount;
		
		cards = new Card[40];
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
	
	public void addCard(String card) {
		Card add = parseCard(card);
		
		for (int i = 0; i < cards.length; i++) {
			if (cards[i] == null) {
				cards[i] = add;
				return;
			}
		}
	}
	
	public void removeCard(String card) {
		Card remove = parseCard(card);
		
		for (int i = 0; i < cards.length; i++) {
			if (cards[i] == remove) {
				// include num copies field
				cards[i] = null;
				return;
			}
		}
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		if (name == null)
			return "null";
		else
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
	
	public void incrementId() {
		idCount++;
	}
	
	public static void setIdCount(int count) {
		idCount = count;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Card parseCard(String card) {
		switch (card) {
			case "Stockpile":
				break;
		}
		
		return null;
	}
	
	public void setMinorRune(MinorRune rune ) {
		minorRune = rune;
	}
	
	public Rune getMinorRune() {
		return minorRune;
	}
	
	public void setMajorRune(Rune rune) {
		majorRune = rune;
	}
	
	public Rune getMajorRune() {
		return majorRune;
	}
}
