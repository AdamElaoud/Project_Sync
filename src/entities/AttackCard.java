package entities;

public abstract class AttackCard implements Card {

	// DoT damage stored in array, each unit is a turn
	protected int[] damage;
	// represents last array element used from damage
	protected int turnsRemaining;
	
	public abstract int dealDamage();
}
