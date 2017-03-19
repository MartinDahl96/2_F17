package entities;

import entities.Field;
import entities.Player;

public class Ownable implements Field{

	//Attributes
	private int value;
	private int rent;
	private Player owner;
	
	
	/*
	 * gets the value of the ownable field
	 */
	public int getValue() {
		return value;
	}
	
	/*
	 * sets the value of the ownable field
	 */
	public void setValue(int value) {
		this.value = value;
	}
	
	/*
	 * gets the rent of the ownable field
	 */
	public int getRent() {
		return rent;
	}
	
	/*
	 * sets the rent of the ownable field
	 */
	public void setRent(int rent) {
		this.rent = rent;
	}
	
	/*
	 * gets the owner of the ownable field
	 */
	public Player getOwner() {
		return owner;
	}
	
	/*
	 * sets the owner of the ownable field
	 */
	public void setOwner(Player owner) {
		this.owner = owner;
	}
	
	@Override
	public void setFieldName(String text) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String getFieldName() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setFieldInfo(String text) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String getFieldInfo() {
		// TODO Auto-generated method stub
		return null;
	}
}