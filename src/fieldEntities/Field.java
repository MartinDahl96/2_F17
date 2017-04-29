 package fieldEntities;

import entities.Player;

public abstract class Field {

	protected int fieldID;
	protected String fieldName;
	protected String fieldInfo;

	/**
	 * Constructor for any field in the game.
	 */
	public Field(int fieldID, String fieldName, String fieldInfo) {
		this.fieldName = fieldName;
		this.fieldInfo = fieldInfo;
		this.fieldID = fieldID;
	}

	public int getFieldID() {
		return fieldID;
	}

	/*
	 * sets the name of the field
	 */
	public void setFieldName(String newFieldName) {
		this.fieldName = newFieldName;
	}

	/*
	 * gets the name of the field
	 */
	public String getFieldName() {
		return this.fieldName;
	}

	/*
	 * sets the information about the field
	 */
	public void setFieldInfo(String newFieldInfo) {
		this.fieldInfo = newFieldInfo;

	}

	/*
	 * gets the information about the field
	 */
	public String getFieldInfo() {
		return this.fieldInfo;
	}
	
	
	public abstract void landOnField(Player player);

	@Override
	public String toString() {
		return "fieldID=" + fieldID + ", fieldName=" + fieldName + ", fieldInfo=" + fieldInfo;
	}

}
