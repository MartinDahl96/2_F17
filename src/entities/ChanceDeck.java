package entities;

import java.util.*;
import java.io.FileNotFoundException;
import java.io.File;

public class ChanceDeck {

	/**
	 * Creates a stack of ChanceCards called deck.
	 */
	private static Stack<ChanceCard> deck;

	/**
	 * Constructor used to create a stack pf ChanceCards.
	 */
	public ChanceDeck() {
		ChanceDeck.deck = new Stack<ChanceCard>();
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
		Collections.shuffle(ChanceDeck.deck);
		
	}

	/**
	 * Used to display the deck.
	 * @return deck.
	 */
	public static Stack<ChanceCard> getDeck() {
		return deck;
	}
	/**
	 * used to get a card from the stack at a given index.
	 * @param index is the index of the card.
	 * @return is the card at the given index.
	 */
	public ChanceCard getCard(int index){
		return deck.get(index);
	}
	

	

}