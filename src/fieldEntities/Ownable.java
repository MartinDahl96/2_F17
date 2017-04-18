package fieldEntities;

import entities.Player;

public abstract class Ownable extends Field {

	// Attributes
	private int price;
	private Player owner;
	private boolean isPawned; // mortgage

	/*
	 * Constructor for an ownable field.
	 */
	public Ownable(int fieldID, String fieldName, String fieldInfo, int price) {
		super(fieldID, fieldName, fieldInfo);
		this.price = price;
		this.isPawned = false;
	}

	/**
	 * Used to get the price of an ownable field.
	 * 
	 * @return price
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * Sets the price of the ownable field.
	 * 
	 * @param newPrice
	 */
	public void setPrice(int newPrice) {
		this.price = newPrice;
	}

	/**
	 * Used to get the owner of the field.
	 * 
	 * @return owner
	 */
	public Player getOwner() {
		return owner;
	}

	/**
	 * Sets the owner of the field.
	 * 
	 * @param newOwner
	 */
	public void setOwner(Player newOwner) {
		this.owner = newOwner;
	}

	/**
	 * abstract method for getting the rent of a field. This is abstract due to
	 * the fact that there will be multiple methods for deciding the rent of
	 * certain fields.
	 * 
	 * @return
	 */
	public abstract int getRent();

	/**
	 * The method of landing on a field. This will be different depending on the
	 * field, but they will all perform the check to see if the field is owned
	 * by someone or not.
	 */

	public void pawnField(Player player) {
		player.setFortune(this.price / 2);
		this.isPawned = true;

	}

	public void unPawnField(Player player) {
		player.setFortune(-this.price / 2);
		this.isPawned = false;
	}
	
	

}