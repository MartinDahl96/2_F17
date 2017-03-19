package entities;

import entities.Field;
import entities.Player;

public class Ownable implements Field{

	//Attributes
	private int value;
	private int rent;
	private Player owner;
	
	
	
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public int getRent() {
		return rent;
	}
	public void setRent(int rent) {
		this.rent = rent;
	}
	public Player getOwner() {
		return owner;
	}
	public void setOwner(Player owner) {
		this.owner = owner;
	}
}