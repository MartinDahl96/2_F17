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
			Scanner s = new Scanner(new File("chanceCards"));

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

}