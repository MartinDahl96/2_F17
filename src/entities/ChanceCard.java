package entities;

public class ChanceCard {
	
	private int cardValue ;
	private  String cardText;
	
	
	public ChanceCard(int cardValue, String cardText) {
	
		this.cardValue = cardValue;
		this.cardText = cardText;
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


	@Override
	public String toString() {
		return "ChanceCard [cardText =" + cardText + "]";
	}




}
