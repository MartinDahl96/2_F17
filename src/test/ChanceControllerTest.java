package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entities.Board;
import entities.ChanceCard;
import entities.ChanceDeck;
import entities.Player;
import fieldEntities.Chance;

public class ChanceControllerTest {

	Player p;
	Board b;
	ChanceContollerMockup cc;
	ChanceDeck cd;
	ChanceCard cCard;
	Chance c;
	
	@Before
	public void setUp() throws Exception {
		p = new Player(1, "Test Player");
		b = new Board();
		c = new Chance(3, "Chance", "C-description");
		cc = new ChanceContollerMockup(c);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testLandOnChance() {
		int expected, actual;
		cc.drawCard(p);
		
		expected = 32; 
		actual = cc.sizeOfStack();
		assertEquals(expected,actual);
	}

	@Test
	public void testDrawCard() {
		int expected, actual;
		cc.drawCard(p);
		
		expected = 32; 
		actual = cc.sizeOfStack();
		assertEquals(expected,actual);
	}

	@Test
	public void testRecreateIfEmpty() {
		int expected, actual, i;
		
		for(i = 0; i < 33; i++){
		cc.drawCard(p);
		}
		// Emptying the stack by drawing all the chance cards.
		// Note the chancecard deck uses the method recreateIfEmpty() once a player lands on a CC Field and the stacksize is = 0:
		expected = 0; 
		actual = cc.sizeOfStack();
		assertEquals(expected,actual);
		
		// Recreating the new deck, note that the deck will have 31 cards since the two jail cards have been taken out of the deck:
		cc.recreateIfEmpty();
		expected = 31; 
		actual = cc.sizeOfStack();
		assertEquals(expected,actual);
		
		
	}

}
