 package entities;

//Die class


public class Die {

	private int sides;
	private int faceValue;
	
	
	/**
	 * @Param Die Constructor. Used to create a Die object.
	 * @Param faceValue. Used to set the faceValue to 0 at first.
	 */
	
	public Die(){
		this.sides = 6;
		this.faceValue = 0;
	}
	
	/**
	 * Sets the faceValue to a random number between 1 and 6.
	 */
	
	public void roll(){
		faceValue = (int)(Math.random()*sides) + 1;
	}
	
	/**
	 * Returns the faceValue / the number on the die.
	 */
	
	public int getRoll(){
		return faceValue;
	}
	
	/**
	 * Converts the faceValue integer to a string.
	 */
	
	public String toString(){
		return Integer.toString(faceValue);
	}
	
	
	
	
}
