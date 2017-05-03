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


public class TestRules {

	Player p;
	Rule r;
	Board b;
	StreetControllerMockup sc;
	
	
	@Before
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
	public void testEntities () {
		assertTrue(this.p instanceof Player);
		assertNotNull(this.p);
	}
	
	@Test
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
