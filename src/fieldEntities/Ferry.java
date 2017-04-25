package fieldEntities;

import entities.Player;

public class Ferry extends Ownable {

	// Attributes
	private int rent_1;
	private int rent_2;
	private int rent_3;
	private int rent_4;
	private boolean doubleRent; //used when player picks a specific ChanceCard
	
	/*
	 * Constructor created for a Ferry field.
	 */
	public Ferry(int fieldID, String fieldName, String fieldInfo, int price, int rent_1, int rent_2, int rent_3,
			int rent_4) {
		super(fieldID, fieldName, fieldInfo, price);
		this.rent_1 = rent_1;
		this.rent_2 = rent_2;
		this.rent_3 = rent_3;
		this.rent_4 = rent_4;
	}

	/**
	 * getRent method for ferry-fields. returns the rent which depends on the
	 * amount of ferries owned by the player.
	 */
	@Override
	
	
	
	public int getRent() {
		
		if(super.isPawned == true){
			return 0;
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
				return 0;

				}
			}
		}
	}
