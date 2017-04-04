package entities;

public class Start extends Field {
	
	//Attributes
	
	private int startBonus;
	

	/**
	 * A constructor for the Start field, used to create a Tax object
	 * @param fieldName Determines the name of the field
	 * @param fieldInfo Describes the field
	 * @param startBonus Adds 4000 to the players account when landing or passing this field
	 */
	public Start(int fieldID, String fieldName, String fieldInfo, int startBonus) {
		super(fieldID, fieldName, fieldInfo);
		this.startBonus = startBonus;

	}
	/**
	 * Determines the name of the field
	 */
	@Override
	public void setFieldName(String fieldName) {

	}
	/**
	 * gets and returns the name of the field
	 */
	@Override
	public String getFieldName() {
		return fieldName;
	}
	/**
	 * Determines the information about the field
	 */
	@Override
	public void setFieldInfo(String fieldInfo) {

	}
	/**
	 * Gets and returns the information about the field
	 */
	@Override
	public String getFieldInfo() {
		return this.fieldInfo;
	}
	/**
	 * Run through of landing on the field
	 * The player will receive a start bonus which will be deposited in his account
	 */
	public void landOnField(Player player) {
		player.setFortune(this.startBonus);

	}
	@Override
	public String toString() {
		return "("+super.toString()+", value=" +this.startBonus+")";
	}
	/**
	 * toString method
	 */
	
	
	

}
