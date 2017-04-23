package fieldEntities;

import java.awt.Color;

import entities.Board;
import entities.Player;
import mainControllers.MUI;

public class Street extends Ownable {

	// Attributes
	private int baseRent;
	private int houseRent_1;
	private int houseRent_2;
	private int houseRent_3;
	private int houseRent_4;
	private int hotelRent;
	private int numOfBuildings;
	private int buildPrice;
	private String color;
	private boolean buildable;

	/**
	 * Street constructor. Used to create a Street object.
	 * 
	 * @param fieldName
	 *            Determines the name of the field
	 * @param fieldInfo
	 *            Describes the information about the field (delete?)
	 * @param price
	 *            Determines the acquisition price
	 * @param baseRent
	 *            Determines the rent
	 * @param houseRent_1
	 *            Determines the rent when the field got a house
	 * @param houseRent_2
	 *            Determines the rent when the field got two houses
	 * @param houseRent_3
	 *            Determines the rent when the field got three houses
	 * @param houseRent_4
	 *            Determines the rent when the field got four houses
	 * @param hotelRent
	 *            Determines the rent when the field got a hotel
	 * @param mortgage
	 *            Determines the price of a possible mortgage
	 * @param buildPrice
	 *            Determines the price of expanding the Street field with extra
	 *            houses/ a hotel
	 * @param color
	 *            Determines the color of the field to categorize the streets
	 */
	public Street(int fieldID, String fieldName, String fieldInfo, int price, int baseRent, int houseRent_1,
			int houseRent_2, int houseRent_3, int houseRent_4, int hotelRent, int buildPrice, String color) {
		super(fieldID, fieldName, fieldInfo, price);
		this.baseRent = baseRent;
		this.houseRent_1 = houseRent_1;
		this.houseRent_2 = houseRent_2;
		this.houseRent_3 = houseRent_3;
		this.houseRent_4 = houseRent_4;
		this.hotelRent = hotelRent;
		this.numOfBuildings = 0;
		this.buildPrice = buildPrice;
		this.color = color;
		this.buildable = false;

	}

	/**
	 * Gets and returns the mortgage
	 * 
	 * @return mortgage price, which the player receives
	 */
	

	/**
	 * Sets the color-category of the field
	 */
	public String getColor() {
		return color;
	}
	public int getNumOfBuildings() {
		return numOfBuildings;
	}
	public int getBuildPrice() {
		return buildPrice;
	}
	public void setNumOfBuildings(int num) {
		this.numOfBuildings = num;
	}

	public boolean buildable(Player player) {

		int tempCounter3 = 0;
		int tempCounter2 = 0;

		for (Field field : Board.getFields()) {

			if (((Ownable) field).getOwner() == player) {

				if (((Street) field).getColor() == "purple" || ((Street) field).getColor() == "blue") {
					tempCounter2++;

				}

				else if (((Street) field).getColor() == this.color) {
					tempCounter3++;

				}

			}

			if (tempCounter3 == 3 || tempCounter2 == 2) {
				this.buildable = true;
			}

		}
		return buildable;

	}


	/**
	 * Gets and returns the rent for the player to pay the owner of the street
	 * field
	 */
	@Override
	public int getRent() {

		if (super.isPawned == true) {
			return 0;
		}

		else {

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
	}

	public int getNumOfBuildings() {
		return numOfBuildings;
	}

	public void setNumOfBuildings() {
		numOfBuildings++;
	}

	public boolean isBuildable() {
		return buildable;
	}

	public void setBuildablel(boolean b) {
		buildable = b;
	}

	public int getBuildPrice() {
		return buildPrice;
	}

	public void setBuildable(boolean b){
		buildable = b;
	}
	
	public boolean isBuildable(){
		return buildable;
	}
	
}
