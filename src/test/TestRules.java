package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import entities.Board;
import entities.Player;
import fieldEntities.Ferry;
import fieldEntities.Ownable;
import fieldEntities.Street;
import mainControllers.Rule;

/**
 * JUnittest of the rules class, which evaluates when a player is bankrupt. 
 * @author janus
 *
 */
public class TestRules {

	Player p;
	Rule r;
	Board b;
	StreetControllerMockup sc;
	
	
	@Before
	/**
	 * Created the needed instances/objects needed in the tests.
	 * @throws Exception
	 */
	public void setUp() throws Exception {
		this.p = new Player(1, "Test Player");
		this.r = new Rule();
		this.b = new Board();
		this.sc = new StreetControllerMockup();
	}

	@After
	public void tearDown() throws Exception {
		this.p = new Player(1, "Test Player");
	}

	@Test
	/**
	 * Checks that the Player p is a instance of the Player class, and checks that the player isn't a null object.
	 */
	public void testEntities () {
		assertTrue(this.p instanceof Player);
		assertNotNull(this.p);
	}
	
	@Test
	/**
	 * Testing the method to calculate total assets for a player, used to determine wether or not a player is bankrupt.
	 * The test provides a player with three fields, a ferry field (6), two streets field 2 and 4. 
	 * Builds a house on field 2, and calculates the total assets of the player. 
	 */
	public void testCalcTotalAssets() {
			int expected, actual;
		//Sets Player to own two street fields and a ferry field provides one house on field 2:
		((Ferry) Board.getFields().get(6)).setOwner(p);
		p.setOwnedFerries(1);
		((Ownable) Board.getFields().get(2)).setOwner(p);
		((Ownable) Board.getFields().get(4)).setOwner(p);
		
		((Street) Board.getFields().get(2)).setBuildable(true);
		((Street) Board.getFields().get(4)).setBuildable(true);
		sc.buildProperty(((Street) Board.getFields().get(2)), p, true);
		
		//Checks that the player has been billed for the house purchase. 
		expected = 29000;
		actual = p.getFortune();
		assertEquals(expected,actual); 
		
		//Calculates total assets, which is the value of player fortune + the values of the players properties and houses (sell value):
		//Checks that the calculation for total assets functions correctly
		r.calcTotalAssets(p);
		expected = 32700;
		actual = p.getTotalAssets();
		assertEquals(expected, actual);
	}
	
	@Test
	/**
	 * Checks that the Bankrupt method works as intended. 
	 * A player who's account balance is 0, but has additional assets shall not go bankrupt. 
	 * Provided that a player has 0 assets and a account balance of 0, the player is bankrupt.
	 * This test checks the above statements. 
	 */
	public void testBankrupt() {
		// Sets the playerfortune to 0, with 0 assets and checks if the player is bankrupt:
		p.setFortune(-30000);
		r.calcTotalAssets(p);
		assertTrue(p.isBankRupt());
		
		// Grants the player a Ferry field, the playerfortune is still 0, the test checks if the player is no longer considered bankrupt, since he now has assets of 2k:
		((Ferry) Board.getFields().get(6)).setOwner(p);
		p.setOwnedFerries(1);
		
		r.calcTotalAssets(p);
		assertTrue(!p.isBankRupt());
		
	}
}
