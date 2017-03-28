package entities;

import desktop_codebehind.Player;

public class Street extends Ownable {

	// Attributes
	private int baseRent;
	private int houseRent_1;
	private int houseRent_2;
	private int houseRent_3;
	private int houseRent_4;
	private int hotelRent;
	private int mortgage;
	private int numOfBuildings;
	private String color;

	public Street(String fieldName, String fieldInfo, int price, int baseRent, int houseRent_1, int houseRent_2,
			int houseRent_3, int houseRent_4, int hotelRent, int mortgage, String color) {
		super(fieldName, fieldInfo, price);
		this.baseRent = baseRent;
		this.houseRent_1 = houseRent_1;
		this.houseRent_2 = houseRent_2;
		this.houseRent_3 = houseRent_3;
		this.houseRent_4 = houseRent_4;
		this.hotelRent = hotelRent;
		this.mortgage = mortgage;
		this.numOfBuildings = 0;
		this.color = color;

	}

	public int getMortgage() {
		return mortgage;
	}

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

}