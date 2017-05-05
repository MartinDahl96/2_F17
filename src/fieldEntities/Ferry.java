package fieldEntities;

import entities.Player;

public class Ferry extends Ownable {

	// Attributes
	private int rent_1;
	private int rent_2;
	private int rent_3;
	private int rent_4;
	private static boolean doubleRent; //used when player picks a specific ChanceCard
	
	/**
	 * Constructor for a ferry-field.
	 * @param fieldID is the position on the board.
	 * @param fieldName is the name of the field.
	 * @param fieldInfo is the text displayed on the field.
	 * @param price is the price of the field.
	 * @param rent_1 is the rent-price if the owner owns 1 ferry.
	 * @param rent_2 is the rent-price if the owner owns 2 ferries.
	 * @param rent_3 is the rent-price if the owner owns 3 ferries.
	 * @param rent_4 is the rent-price if the owner owns 4 ferries.
	 */
	public Ferry(int fieldID, String fieldName, String fieldInfo, int price, int rent_1, int rent_2, int rent_3,
			int rent_4) {
		super(fieldID, fieldName, fieldInfo, price);
		this.rent_1 = rent_1;
		this.rent_2 = rent_2;
		this.rent_3 = rent_3;
		this.rent_4 = rent_4;
		Ferry.doubleRent = false;
	}

	/**
	 * getRent method for ferry-fields. returns the rent which depends on the
	 * amount of ferries owned by the player.
	 */

	public int getRent() {
		
		if(super.isPawned) return 0;
		
		else if(doubleRent){
			
			switch (super.getOwner().getOwnedFerries()) {
			case 1:
				return this.rent_1*2;
			case 2:
				return this.rent_2*2;
			case 3:
				return this.rent_3*2;
			case 4:
				return this.rent_4*2;
			default:
				return -1;
			}
		}
		
		else{

			switch (super.getOwner().getOwnedFerries()) {
			case 1:
				return this.rent_1;
			case 2:
				return this.rent_2;
			case 3:
				return this.rent_3;
			case 4:
				return this.rent_4;
			default:
				return -1;

				}
		
			}
		
		}
	

	/**
	 * used to set the double rent (dependant on a chancecard).
	 * @param b is the boolean.
	 */
	public static void setDoubleRent(boolean b){
		doubleRent = b;
	
		
 	}

	
}