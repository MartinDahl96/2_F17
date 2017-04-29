 package fieldEntities;

import entities.Player;
import fieldControllers.ParkingController;

public class Parking extends Field {
	
	private ParkingController p;
	private int parkingBonus;

	/**
	 * Constructor of the Parking-field.
	 * @param fieldName used as the name of the field.
	 * @param fieldInfo used to give information about the field.
	 */
	public Parking(int fieldID, String fieldName, String fieldInfo, int parkingBonus) {
		super(fieldID, fieldName, fieldInfo);
		this.p = new ParkingController(this);
		this.parkingBonus = parkingBonus;
	}
	
	public int getParkingBonus() {
		return this.parkingBonus;
	}

	@Override
	public void landOnField(Player player) {
		p.landOnParking(player);
		
	}
	
}
