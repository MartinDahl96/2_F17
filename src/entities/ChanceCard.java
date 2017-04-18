package entities;

public class ChanceCard {

	private int cardValue;
	private String cardText;
	private int cardID;

	/**
	 * The constructor for a Chancecard.
	 * @param cardID the ID for the card. This is used to identify the card.
	 * @param cardValue the value of the card. This is used to determine the affection on the player.
	 * @param cardText the text on the card. This is used to display a text on the card.
	 */
	public ChanceCard(int cardID, int cardValue, String cardText) {

		this.cardValue = cardValue;
		this.cardText = cardText;
		this.cardID = cardID;
	}

	/**
	 * Used to return the cardID as an int.
	 * @return cardID
	 */
	public int getCardID() {
		return cardID;
	}

	/**
	 * Sets the cardID as an int.
	 * @param cardID
	 */
	public void setCardID(int cardID) {
		this.cardID = cardID;
	}
	
	/**
	 * Used to return the cardValue as an int. 
	 * @return cardValye
	 */
	public int getCardValue() {
		return cardValue;
	}
	
	/**
	 * Sets the cardValue as an int.
	 * @param cardValue
	 */
	public void setCardValue(int cardValue) {
		this.cardValue = cardValue;
	}

	/**
	 * Used to return the cardText as a string.
	 * @return cardText
	 */
	public String getCardText() {
		return cardText;
	}

	/**
	 * Sets the cardText as a string.
	 * @param cardText
	 */
	public void setCardText(String cardText) {
		this.cardText = cardText;
	}

	/**
	 * Method used to convert the cardID, cardText & cardValue to a string.
	 */
	public String toString() {
		return ("("+ cardID + " , " + cardText + " , " + cardValue + ")");
	}

}
