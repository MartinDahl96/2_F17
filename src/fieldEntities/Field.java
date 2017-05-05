package fieldEntities;

import entities.Player;

public abstract class Field {

	//attributes
	protected int fieldID;
	protected String fieldName;
	protected String fieldInfo;

	/**
	 * Constructor for any field in the game.
	 * @param fieldID is the position of the field on the board.
	 * @param fieldName is the name of the field.
	 * @param fieldInfo is the text displayed on the field.
	 */
	public Field(int fieldID, String fieldName, String fieldInfo) {
		this.fieldName = fieldName;
		this.fieldInfo = fieldInfo;
		this.fieldID = fieldID;
	}

	/**
	 * used to get the fieldID.
	 * @return fieldID is the ID of the field.
	 */
	public int getFieldID() {
		return fieldID;
	}

	/**
	 * used to set the name of a field.
	 * @param newFieldName is the name of the field.
	 */
	public void setFieldName(String newFieldName) {
		this.fieldName = newFieldName;
	}

	/**
	 * used to get the fieldname of a field.
	 * @return fieldName is the name of the field.
	 */
	public String getFieldName() {
		return this.fieldName;
	}

	/**
	 * used to set the field info.
	 * @param newFieldInfo is the new info on the field.
	 */
	public void setFieldInfo(String newFieldInfo) {
		this.fieldInfo = newFieldInfo;

	}

	/**
	 * used to get the info of the field.
	 * @return fieldInfo is the info of the field.
	 */
	public String getFieldInfo() {
		return this.fieldInfo;
	}
	
	/**
	 * abstract method for the landOnField-methods in the fields.
	 * @param player is the player landing on the field.
	 */
	public abstract void landOnField(Player player);

	/**
	 * toString method.
	 */
	@Override
	public String toString() {
		return "fieldID=" + fieldID + ", fieldName=" + fieldName + ", fieldInfo=" + fieldInfo;
	}

}
