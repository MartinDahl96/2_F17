package entities;

import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;


public class ChanceDeck {
	
	private Stack <ChanceCard> cardDeck;

	public ChanceDeck() {
		
		this.cardDeck = new Stack <ChanceCard> ();
		createDeck();
		
	}
	
	
	public void createDeck(){
		
		
		ChanceCard c1 = new ChanceCard(1,"lol");
		cardDeck.push(c1);
		
		ChanceCard c2 = new ChanceCard(2,"lol2");
		cardDeck.push(c2);
		
		ChanceCard c3 = new ChanceCard(3,"lol3");
		cardDeck.push(c3);
		
		
	
		
		
		
		
		
		
		
	}
	
	
	

}
