package fieldEntities;

//Parking Class

import entities.Player;
import fieldControllers.ParkingController;

public class Parking extends Field {
	
	ParkingController p;

	/**
	 * Constructor of the Parking-field.
	 * @param fieldName used as the name of the field.
	 * @param fieldInfo used to give information about the field.
	 */
	public Parking(int fieldID, String fieldName, String fieldInfo) {
		super(fieldID, fieldName, fieldInfo);
		this.p = new ParkingController(this);
	}

	@Override
	public void landOnField(Player player) {
		// TODO Auto-generated method stub
		
	}


}
