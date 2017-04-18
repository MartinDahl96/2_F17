package entities;

import controllers.MUI;
import desktop_resources.GUI;
import entities.Field;
import entities.Player;

public abstract class Ownable extends Field {

	// Attributes
	private int price;
	private Player owner;
	private boolean isPawned; //mortgage
	

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


		if (buyer.getFortune() < this.getPrice()) {
			MUI.showMessage("Du har ikke penge nok, til at købe dette uejede felt!");
		}

		boolean choice = MUI.getTwoButtons("Vil du købe denne grund?", "Ja", "Nej");
		if (choice == true) {
			MUI.showMessage("Du har købt denne grund: " + this.getFieldName() + " for kr. " + this.getPrice());
			buyer.setFortune(-this.getPrice());
			MUI.setFortune(buyer.getplayerName(), buyer.getFortune());
			setOwner(buyer);
			MUI.setOwner(this.fieldID, buyer.getplayerName());
			
		}

	
		}
	
	public void payRent(Player payer){
System.out.println("her til");
		MUI.showMessage(payer.getplayerName() + " har betalt leje til " + getOwner().getplayerName());
		payer.setFortune(-getRent());
		MUI.setFortune(payer.getplayerName(), payer.getFortune());

		getOwner().setFortune(getRent());
		MUI.setFortune(getOwner().getplayerName(), getOwner().getFortune());

		System.out.println(payer.getFortune());
	
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
		if (getOwner() == null) {
			buyProperty(player);
		}

		if (getOwner() != null && player != getOwner()) {
			payRent(player);
		}
	}
	
	public void pawnField(Player player){
		player.setFortune(this.price/2);
		this.isPawned = true;
		
	}
	
	public void buyBackField(Player player){
		player.setFortune(-this.price/2);
		this.isPawned = false;
	}

}