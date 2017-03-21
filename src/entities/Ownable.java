package entities;

import entities.Field;
import entities.Player;

public abstract class Ownable implements Field{

	//Attributes
	private int value;
	private int rent;
	private Player owner;
	private String fieldName;
	private String fieldInfo;
	
	
	
	/*
	 * gets the value of the ownable field
	 */
	public int getValue(){
		return value;
	}
	
	/*
	 * Constructor for a ownable field.
	 */
	public Ownable(String name, String info, int price, Player player){
		fieldName = name;
		fieldInfo = info;
		value = price;
		owner = player;
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
	
	/*
	 * Metode til at købe et felt. Denne skal have nogle parametre som vi skal have snakket om.
	 */
	public void buyProperty(){
		
	}
	/*
	 * Metode til at betale rent. Denne skal have nogle parametre som vi skal have snakket om.
	 */
	public void payRent(){
		
	}
	/*
	 * Metode til at modtage rent. Denne skal have nogle parametre som vi skal have snakket om.
	 */
	public void receiveRent(){
		
	}
}