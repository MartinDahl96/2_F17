package entities;

public class ChanceCard {

	private int cardValue;
	private String cardText;
	private int cardID;

	public ChanceCard(int cardID, int cardValue, String cardText) {

		this.cardValue = cardValue;
		this.cardText = cardText;
		this.cardID = cardID;
	}

	public int getCardID() {
		return cardID;
	}

	public void setCardID(int cardID) {
		this.cardID = cardID;
	}

	public int getCardValue() {
		return cardValue;
	}

	public void setCardValue(int cardValue) {
		this.cardValue = cardValue;
	}

	public String getCardText() {
		return cardText;
	}

	public void setCardText(String cardText) {
		this.cardText = cardText;
	}

	public String toString() {
		return ("("+ cardID + " , " + cardText + " , " + cardValue + ")");
	}

}
