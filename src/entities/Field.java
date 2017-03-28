package entities;

public abstract class Field {

	protected String fieldName;
	protected String fieldInfo;

	/**
	 * Constructor for any field in the game.
	 */
	public Field(String fieldName, String fieldInfo) {
		this.fieldName = fieldName;
		this.fieldName = fieldInfo;
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
	String getFieldInfo() {
		return this.fieldInfo;
	}

	/**
	 * An abstract method for landing on a field. This will be different depending on the type of field.
	 * @param player
	 */
	public abstract void landOnField(Player player);

}