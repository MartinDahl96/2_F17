package entities;

import java.util.*;
import java.io.FileNotFoundException;
import java.io.File;

public class ChanceDeck {

	private Stack<ChanceCard> deck;

	public ChanceDeck() {
		this.deck = new Stack<ChanceCard>();
		createDeck();
		shuffleDeck();
	}

	public void createDeck() {

		try {
			Scanner s = new Scanner(new File("chanceCards"));
			while (s.hasNext()) {

				String tempText = s.nextLine();
				int tempValue = Integer.parseInt(s.nextLine());
				deck.push(new ChanceCard(tempValue, tempText));

			}
			s.close();
		}

		catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	public void shuffleDeck() {
		Collections.shuffle(this.deck);

	}

	public Stack<ChanceCard> getDeck() {
		return deck;
	}	


public static void main (String[] args){
	
	ChanceDeck cd = new ChanceDeck();
	
	System.out.println(cd.getDeck());

	
	
}

}