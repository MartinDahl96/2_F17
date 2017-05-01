package fieldEntities;

import entities.Player;
import fieldControllers.JailController;

//Jail Class

public class Jail extends Field {
	
	JailController j;

	/**
	 * Constructor for a Jail-field.
	 * @param fieldName is used as a name for the field.
	 * @param fieldInfo is used to give info about the field.
	 */
	public Jail(int fieldID, String fieldName, String fieldInfo) {
		super(fieldID, fieldName, fieldInfo);
		this.j = new JailController(this);

	}

	@Override
	public void landOnField(Player player) {
		j.landOnJail(player);
		
	}
}




