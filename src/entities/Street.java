package entities;

import java.awt.Color;

import controllers.MUI;

public class Street extends Ownable {

	//Attributes
	private int baseRent;
	private int houseRent_1;
	private int houseRent_2;
	private int houseRent_3;
	private int houseRent_4;
	private int hotelRent;
	private int mortgage;
	private int numOfBuildings;
	private int buildPrice;
	private Color color;
	private boolean buildable;
	private String[] test = {"Do you want to buy this property?", "Yes", "No", "You bought this property: ","for the price of: ", "You dont have enough money to buy this field"," has paid rent to "};

	/**
	 * Street constructor.
	 * Used to create a Street object.
	 * @param fieldName Determines the name of the field
	 * @param fieldInfo Describes the information about the field (delete?)
	 * @param price Determines the acquisition price
	 * @param baseRent Determines the rent
	 * @param houseRent_1 Determines the rent when the field got a house
	 * @param houseRent_2 Determines the rent when the field got two houses
	 * @param houseRent_3 Determines the rent when the field got three houses
	 * @param houseRent_4 Determines the rent when the field got four houses
	 * @param hotelRent Determines the rent when the field got a hotel
	 * @param mortgage Determines the price of a possible mortgage
	 * @param buildPrice Determines the price of expanding the Street field with extra houses/ a hotel
	 * @param color Determines the color of the field to categorize the streets
	 */
	public Street(int fieldID, String fieldName, String fieldInfo, int price, int baseRent, int houseRent_1, int houseRent_2,
			int houseRent_3, int houseRent_4, int hotelRent, int buildPrice, Color color) {
		super(fieldID, fieldName, fieldInfo, price);
		this.baseRent = baseRent;
		this.houseRent_1 = houseRent_1;
		this.houseRent_2 = houseRent_2;
		this.houseRent_3 = houseRent_3;
		this.houseRent_4 = houseRent_4;
		this.hotelRent = hotelRent;
		this.mortgage = this.getPrice()/2;
		this.numOfBuildings = 0;
		this.buildPrice = buildPrice;
		this.color = color;

	}
	/**
	 * Gets and returns the mortgage
	 * @return mortgage price, which the player receives
	 */
	public int getMortgage() {
		return mortgage;
	}
	
	/*public void buildProperty(Player player){
	if(super.getOwner() == player){
		if(this.color)
		
	}
		
	}*/
	
	
	/**
	 * Gets and returns the rent for the player to pay the owner of the street field
	 */
	@Override
	public int getRent() {
		
		int rent;

		switch (numOfBuildings) {

		case 1:
			rent = houseRent_1;
			break;

		case 2:
			rent = houseRent_2;
			break;

		case 3:
			rent = houseRent_3;
			break;

		case 4:
			rent = houseRent_4;
			break;

		case 5:
			rent = hotelRent;
			break;
			
		default:
			rent = baseRent;
			
		}
		return rent;
	}
	/**
	 * Run through of landing on a street field
	 */
	
	public void landOnField(Player player){
		
		if(super.getOwner() == null){
			
			if(player.getFortune() < this.getPrice()){
				MUI.showMessage(test[5]);
			}
			
			boolean choice = MUI.getTwoButtons(test[0], test[1], test[2]);
			if(choice == true){
				MUI.showMessage(test[3]+this.getFieldName()+test[4]+this.getPrice());
				player.setFortune(-this.getPrice());
				super.setOwner(player);
				MUI.setOwner(this.fieldID, player.getplayerName());
			}
			
			else if(choice == false){
				//temp: Kan denne holdes tomt?
			}
			
		}
		
		if(super.getOwner() != null){
			player.setFortune(-getRent());
			super.getOwner().setFortune(getRent());
			MUI.showMessage(player.getplayerName()+test[6]+super.getOwner().getplayerName());
		}
		
		
	}
	
	
}