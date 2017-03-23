package entities;

public class Ferry extends Ownable {

	// Attributes
	private int rent_1 = 500;
	private int rent_2 = 1000;
	private int rent_3 = 2000;
	private int rent_4 = 4000;

	/*
	 * Constructor created for a Ferry field.
	 */
	public Ferry(String fieldName, String fieldInfo, int price) {
		super(fieldName, fieldInfo, price);
	}

	public int getRent() {
		switch (super.getOwner().getOwnedFerries()) {
		case 1:
			return this.rent_1;
		case 2:
			return this.rent_1;
		case 3:
			return this.rent_1;
		case 4:
			return this.rent_1;
		default:
			return 0;

		}

	}

}
