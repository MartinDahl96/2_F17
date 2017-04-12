package entities;

import java.util.*;
import java.io.FileNotFoundException;
import java.io.File;

public class ChanceDeck {

	/**
	 * Creates a stack of ChanceCards called deck.
	 */
	private Stack<ChanceCard> deck;

	/**
	 * Constructor used to create a stack pf ChanceCards.
	 */
	public ChanceDeck() {
		this.deck = new Stack<ChanceCard>();
		createDeck();
		shuffleDeck();
	}

	/**
	 * Method used for creating a deck of ChanceCards.
	 * Also throws an exception if the file "chanceCards" cannot be found.
	 */
	public void createDeck() {

		try {
			Scanner s = new Scanner(new File("txtfiles/chanceCards.txt"));

			int tempID = 0;

			while (s.hasNext()) {

				String tempText = s.nextLine();
				int tempValue = Integer.parseInt(s.nextLine());
				deck.push(new ChanceCard(++tempID, tempValue, tempText));

			}
			s.close();
		}

		catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Shuffles the created deck in order to randomize it.
	 */
	public void shuffleDeck() {
		Collections.shuffle(this.deck);

	}

	/**
	 * Used to display the deck.
	 * @return deck.
	 */
	public Stack<ChanceCard> getDeck() {
		return deck;
	}
	

	public void drawCard(Player player){
		
		ChanceCard c = getDeck().pop();
		
		switch(c.getCardID()){
		
		case 1:
			player.setFortune(c.getCardValue());
			break;
		case 2:
			player.changePosition(c.getCardValue());
			break;
		case 3:
			player.changePosition(c.getCardValue());
			break;
		case 4:
			player.changePosition(c.getCardValue());
			break;
		case 5:
			player.setFortune(c.getCardValue());
			break;
		case 6:
			player.setFortune(c.getCardValue());
			break;
		case 7:
			player.setFortune(c.getCardValue());
			break;
		case 8:
			player.setFortune(c.getCardValue());
			break;
		case 9:
			player.setFortune(c.getCardValue());
			break;
		case 10:
			//Mangler
			break;
		case 11:
			player.setFortune(c.getCardValue());
			break;
		case 12:
			player.setFortune(c.getCardValue());
			break;
		case 13:
			//Mangler
			break;
		case 14:
			player.changePosition(25);
			break;
		case 15:
			//Mangler
			break;
		case 16:
			//Mangler
			break;
		case 17:
			player.changePosition(c.getCardValue());
			break;
		case 18:
			player.setJailToken();
			player.setTotalAssets(c.getCardValue());
			break;
		case 19:
			player.setJailToken();
			player.setTotalAssets(c.getCardValue());
			break;
		case 20:
			player.setFortune(c.getCardValue());
			break;
		case 21:
			player.changePosition(c.getCardValue());
			break;
		case 22:
			player.setFortune(c.getCardValue());
			break;
		case 23:
			player.changePosition(40);
			break;
		case 24:
			player.setCurrentPosition(c.getCardValue());
			break;
		case 25:
			//Mangler
			break;
		case 26:
			player.setFortune(c.getCardValue());
			break;
		case 27:
			player.setFortune(c.getCardValue());
			break;
		case 28:
			if(player.getTotalAssets() <= 15000){
				player.setFortune(c.getCardValue());
			}
			break;
		case 29:
			player.setFortune(c.getCardValue());
			break;
		case 30:
			player.setFortune(c.getCardValue());
			break;
		case 31:
			player.setFortune(c.getCardValue());
			break;
		case 32:
			player.setFortune(c.getCardValue());
			break;
		case 33:
			player.setFortune(c.getCardValue());
			break;
		
		
		}
		
	}
	
	
	public static void main(String[] args){
		ChanceDeck c = new ChanceDeck();
		
		System.out.println(c.getDeck());
	}

}