package fieldEntities;

import entities.Player;

public class Start extends Field {

	// Attributes

	private int startBonus;

	/**
	 * A constructor for the Start field, used to create a Tax object
	 * 
	 * @param fieldName
	 *            Determines the name of the field
	 * @param fieldInfo
	 *            Describes the field
	 * @param startBonus
	 *            Adds 4000 to the players account when landing or passing this
	 *            field
	 */
	public Start(int fieldID, String fieldName, String fieldInfo, int startBonus) {
		super(fieldID, fieldName, fieldInfo);
		this.startBonus = startBonus;

	}

	@Override
	public String toString() {
		return super.toString() + ", value=" + this.startBonus;
	}
	/**
	 * toString method
	 */

}
