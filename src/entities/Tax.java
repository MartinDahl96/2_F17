package entities;

public class Tax extends Field {
	
	/**
	 * Creating attributes for the class. 
	 * The integer revenueTax is the tax which withdraws a percentage of the players account.
	 * The integer fixedTax is used to withdraw a predetermined amount of the players account.
	 */
	private int revenueTax;
	private int fixedTax;
	
	/**
	 * A constructor for the Tax field, used to create a Tax object
	 * @param fieldName States the name of the field
	 * @param fieldInfo Describes the field
	 * @param fixedTax Determines the fixed tax
	 * @param revenueTax Determines a percentage of the players account as tax
	 */
	public Tax(String fieldName, String fieldInfo, int fixedTax, int revenueTax){
		super(fieldName, fieldInfo);
		this.fixedTax = fixedTax;
		this.revenueTax = revenueTax;
	}
	/**
	 * Sets the revenue Tax
	 * @param tax determines 10 % of the players account as tax
	 */
	public void setrevenueTax(int tax){
		this.revenueTax = tax;
	}
	/**
	 * Gets and returns the revenue tax
	 * @return 10 % of the players account
	 */
	public int getrevenueTax(){
		return revenueTax;
	}
	/**
	 * Sets the fixed Tax
	 * @param tax determines the fixed tax
	 */
	public void setfixedTax(int tax){
		this.fixedTax = tax;
	}
	/**
	 * Gets and returns the fixed tax
	 * @return either 2000 or 4000 depending on the Tax field
	 */
	public int getfixedTax(){
		return fixedTax;
	}
	
	/*
	 * (non-Javadoc)
	 * @see entities.Field#landOnField(entities.Player)
	 */
	@Override
	public void landOnField(Player player) {
		
		
		
	}
}
