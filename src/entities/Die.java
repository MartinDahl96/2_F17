package entities;

/**
 * @Author Martin
 * This class will be responsible for the individual dice.
 */
public class Die {

	private int faceValue;
	
	/**
	 * @Param Die Constructor. Used to create a Die object.
	 * @Param faceValue. Used to set the faceValue to 0 at first.
	 */
	
	public Die(){
		faceValue = 0;
	}
	
	
	/**
	 * Sets the faceValue to a random number between 1 and 6.
	 */
	
	public void setRoll(){
		faceValue = (int)(Math.random()*6);
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
