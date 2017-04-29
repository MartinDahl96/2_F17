 package fieldEntities;

//Tax class

import desktop_resources.GUI;
import entities.Player;
import fieldControllers.TaxController;
import mainControllers.MUI;

public class Tax extends Field {

	/**
	 * Creating attributes for the class. The integer revenueTax is the tax
	 * which withdraws a percentage of the players account. The integer fixedTax
	 * is used to withdraw a predetermined amount of the players account.
	 */
	private TaxController tc;
	private double revenueTax;
	private int fixedTax;

	/**
	 * A constructor for the Tax field, used to create a Tax object
	 * 
	 * @param fieldName
	 *            States the name of the field
	 * @param fieldInfo
	 *            Describes the field
	 * @param fixedTax
	 *            Determines the fixed tax
	 * @param revenueTax
	 *            Determines a percentage of the players account as tax
	 */
	public Tax(int fieldID, String fieldName, String fieldInfo, int fixedTax, double revenueTax) {
		super(fieldID, fieldName, fieldInfo);
		this.fixedTax = fixedTax;
		this.revenueTax = revenueTax;
		this.tc = new TaxController(this);
	}

	/**
	 * Sets the revenue Tax
	 * 
	 * @param tax
	 *            determines 10 % of the players account as tax
	 */
	public void setrevenueTax(int tax) {
		this.revenueTax = tax;
	}

	/**
	 * Gets and returns the revenue tax
	 * 
	 * @return 10 % of the players account
	 */
	public double getRevenueTax() {
		return revenueTax;
	}

	/**
	 * Sets the fixed Tax
	 * 
	 * @param tax
	 *            determines the fixed tax
	 */
	public void setFixedTax(int tax) {
		this.fixedTax = tax;
	}

	/**
	 * Gets and returns the fixed tax
	 * 
	 * @return either 2000 or 4000 depending on the Tax field
	 */
	public int getFixedTax() {
		return fixedTax;
	}

	public void landOnField(Player player){
		tc.landOnTax(player);
		
	}
	
}
