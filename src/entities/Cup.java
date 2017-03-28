package entities;

/**
 * @Author Martin
 * This class will be responsible for the cup holding the dice, and also rolling them.
 */

public class Cup {

	/**
	 * Creates the value of the cup and two instances of the Die class.
	 */
	private int cupValue;
	private Die Die1;
	private Die Die2;
	
	/**
	 * Creates the cup constructor.
	 * @Param cup used to roll the dice.
	 */
	
	public Cup(){
		
	}
	
	
	/**
	 * Returns the value of the rolled dice.
	 */
	
	public int getCupValue(){
		cupValue = Die1.getRoll()+Die2.getRoll();
		return cupValue;
	}
	
	/**
	 * Returns the value of Die1.
	 * @return Die1.
	 */
	public Die getDie1(){
		return Die1;
	}
	
	/**
	 * Returns the value of Die2.
	 * @return Die2.
	 */
	public Die getDie2(){
		return Die2;
	}
	
	/**
	 * Method created for testing purposes.
	 * @param value
	 * @return cupValue
	 */
	public int setCup(int value){
		cupValue = value;
		return cupValue;
	}
	
	/**
	 * Converts the cupValue int into a string.
	 */
	public String toString(){
		return Integer.toString(cupValue);
	}
	
	public void useCup() {
		Die1.roll();
		Die2.roll();
	}
	
}

