package entities;

//Cup class

public class Cup {

	/**
	 * Creates the value of the cup and two instances of the Die class.
	 */
	private int cupValue;
	private Die Die1 = new Die();
	private Die Die2 = new Die();
	
	/**
	 * Creates the cup constructor.
	 */
	
	public Cup(){
		this.Die1 = new Die();
		this.Die2 = new Die();
	}
	
	
	/**
	 * used to get the value of the cup.
	 * @return cupValue is the value of the cup.
	 */
	public int getCupValue(){
		cupValue = Die1.getRoll()+Die2.getRoll();
		return cupValue;
	}
	
	/**
	 * Returns the value of Die1.
	 * @return Die1.
	 */
	public int getFaceValue1(){
		return Die1.getRoll();
	}
	
	/**
	 * Returns the value of Die2.
	 * @return Die2.
	 */
	public int getFaceValue2(){
		return Die2.getRoll();
	}
	
	/**
	 * Method created for testing purposes.
	 * @param value is the determined value.
	 * @return cupValue is the value of the cup.
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
	
	/**
	 * method used to roll the dice inside of the cup.
	 */
	public void useCup() {
		Die1.roll();
		Die2.roll();
	}
	
}

