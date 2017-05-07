package fieldEntities;

import entities.Player;
import fieldControllers.JailController;


public class Jail extends Field {
	
	//attributes
	JailController j;

	/**
	 * Constructor for a Jail-field.
	 * @param fieldID is the id/position of the field.
	 * @param fieldName is used as a name for the field.
	 * @param fieldInfo is used to give info about the field.
	 */
	public Jail(int fieldID, String fieldName, String fieldInfo) {
		super(fieldID, fieldName, fieldInfo);
		this.j = new JailController(this);
	}

	/**
	 * landOnField method inherited from the Field-class.
	 */
	@Override
	public void landOnField(Player player) {
		j.landOnJail(player);
		
	}
}




