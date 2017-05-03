package fieldEntities;

import entities.Player;
import fieldControllers.OwnableController;

public abstract class Ownable extends Field {

	// Attributes
	private int price;
	private Player owner;
	protected boolean isPawned; // mortgage
	private int mortgage;
	private OwnableController o;
	
	/*
	 * Constructor for an ownable field.
	 */
	public Ownable(int fieldID, String fieldName, String fieldInfo, int price) {
		super(fieldID, fieldName, fieldInfo);
		this.price = price;
		this.isPawned = false;
		this.mortgage = this.getPrice() / 2;
		this.o = new OwnableController(this);
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

	
	public int getMortgage() {
		return mortgage;
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
	
	public boolean isPawned() {
		return isPawned;
	}

	public void setPawned(boolean isPawned) {
		this.isPawned = isPawned;
	}
	
	
		
	public void landOnField(Player player){
		o.landOnOwnable(player);

	}
	
	
	

}