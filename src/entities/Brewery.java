package entities;


public class Brewery extends Ownable {
	//Attributes
	int multiplier;
	int cupSum;
	

	/*
	 * Constructor for a Brewery field.
	 */
	public Brewery(String fieldName, String fieldInfo, int price, int multiplier) {
		super(fieldName, fieldInfo, price);
		
	}

	/**
	 * Method to determine the rent 
	 * If both brewery fields are owned by the same player the rent is determined be multiplying 200
	 * with the sum of eyes from a new through
	 * Else the sum of eyes from a new through is multiplied by 100 
	 */
	@Override
	public int getRent() {
		switch (super.getOwner().getOwnedBreweries()) {
		case 1: this.multiplier = 1;
				break;
		case 2: this.multiplier = 2;
				break;
		}
		Cup cup = new Cup();
		int rent = cup.getCupValue() * this.multiplier;
		return rent;
	}
	
}

		
	
	

