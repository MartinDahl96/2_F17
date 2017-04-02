package entities;

import desktop_resources.GUI;
import entities.Field;
import entities.Player;

public abstract class Ownable extends Field {

	// Attributes
	private int price;
	private Player owner;
	boolean isOwned;

	/*
	 * Constructor for an ownable field.
	 */
	public Ownable(String fieldName, String fieldInfo, int price) {
		super(fieldName, fieldInfo);
		this.price = price;
		this.isOwned = false;
	}

	/**
	 * Used to get the price of an ownable field.
	 * @return price
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * Sets the price of the ownable field.
	 * @param newPrice
	 */
	public void setPrice(int newPrice) {
		this.price = newPrice;
	}

	/**
	 * Used to get the owner of the field.
	 * @return owner
	 */
	public Player getOwner() {
		return owner;
	}

	/**
	 * Sets the owner of the field.
	 * @param newOwner
	 */
	public void setOwner(Player newOwner) {
		this.owner = newOwner;
	}
	/**
	 * Method used for buying a propoerty.
	 * The method will first check to see if the player wants to buy the property.
	 * If the player presses "true" the boolean property will return "true".
	 * This will cause the value of the field to be withdrawn from the player's fortune,
	 * and set him as the owner of the field.
	 * @param buyer
	 */
	public void buyProperty(Player buyer){
		boolean property = GUI.getUserLeftButtonPressed("Do you want to buy this property?", "Yes", "No");
		if (property){
			buyer.setFortune(-getPrice());
			setOwner(buyer);
			//GUI.setOwner(null, null);		
		}
	}
		
	
	/**
	 * abstract method for getting the rent of a field.
	 * This is abstract due to the fact that there will be multiple methods for deciding the rent of certain fields.
	 * @return
	 */
	public abstract int getRent();
	
	/**
	 * The method of landing on a field.
	 * This will be different depending on the field, but they will all perform the check to see if the field is owned by someone or not.
	 */
	public void landOnField(Player player){
		if (getOwner() == null){
			
		}
	}

}