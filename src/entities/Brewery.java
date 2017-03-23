package entities;


public class Brewery extends Ownable {
	
	int multiplier;
	int cupSum;
	

	/*
	 * Constructor for a Brewery field.
	 */
	public Brewery(String fieldName, String fieldInfo, int price, int multiplier) {
		super(fieldName, fieldInfo, price);
		
	}

	@Override
	public int getRent() {
		Cup cup = new Cup();
		int rent = cup.getCupValue() * this.multiplier;
		return rent;
	}
	
}

		
	
	

