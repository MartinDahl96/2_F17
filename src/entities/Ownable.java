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
	 * Constructor for a ownable field.
	 */
	public Ownable(String fieldName, String fieldInfo, int price) {
		super(fieldName, fieldInfo);
		this.price = price;
		this.isOwned = false;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int newPrice) {
		this.price = newPrice;
	}

	public Player getOwner() {
		return owner;
	}

	public void setOwner(Player newOwner) {
		this.owner = newOwner;
	}
	
	public void buyProperty(Player buyer){
		boolean property = GUI.getUserLeftButtonPressed("Do you want to buy this property?", "Yes", "No");
		if (property){
			buyer.setFortune(-getPrice());
			setOwner(buyer);
			//GUI.setOwner(null, null);		
		}
	}
		
	
	
	public abstract int getRent();
	
	public void landOnField(Player player){
		if (getOwner() == null){
			
		}
	}

}