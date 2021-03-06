package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entities.Board;
import entities.Cup;
import entities.Player;
import fieldEntities.Brewery;
import fieldEntities.Ferry;
import fieldEntities.Ownable;
import test.OwnableControllerMockup;
/**
 * JUnit test of OwnableController.
 * @author janus
 *
 */
public class OwnableControllerTest {
	Player p1,p2; 
	Board b;
	OwnableControllerMockup oc;
	Ownable o;
	Cup cup; 

	@Before
	/**
	 * Instanciates class objects needed to preform tests.
	 * the setUp method is used before each @Test
	 * @throws Exception
	 */
	public void setUp() throws Exception {
		this.p1 = new Player(1,"Test - Player");
		this.p2 = new Player(2,"Test - Player2");
		this.b = new Board();
		this.oc = new OwnableControllerMockup();
	}

	@After
	/**
	 * Sets the instanciaded objects to the default after each test. 
	 * @throws Exception
	 */
	public void tearDown() throws Exception {
		this.p1 = new Player(1,"Test - Player");
		this.p2 = new Player(2,"Test - Player2");
		this.b = new Board();
		this.oc = new OwnableControllerMockup();
	}

	@Test
	/**
	 * Tests that when a player lands on a field the player is able to purchase the field, as long it's a ownable field.
	 */
	public void testLandOnOwnable() {
		oc.landOnOwnable(p1, ((Brewery) Board.getFields().get(13)));
		assertTrue(((Brewery) Board.getFields().get(13)).getOwner() == p1);
		

	}

	@Test
	/*
	 * Tests that the player is able to buy a property, the BuyProperty method is called in the LandOnOwnable method.
	 */
	public void testBuyProperty() {
		oc.buyProperty(p1, true, ((Brewery) Board.getFields().get(29)));
		assertTrue(((Brewery) Board.getFields().get(29)).getOwner() == p1);
	}

	@Test
	/**
	 * Testing if the PayRentFerries method works as intended.
	 * One player owns two Ferry fields, another player lands on the owned field, and has to pay rent to the owner:
	 */
	public void testPayRentFerries(){
		int expected, actual;
		((Ferry) Board.getFields().get(6)).setOwner(p1);
		((Ferry) Board.getFields().get(26)).setOwner(p1);
		p1.setOwnedFerries(2);
		
		oc.payRent(p2, ((Ferry) Board.getFields().get(26)));
		
		expected = 31000;
		actual = p1.getFortune();
		assertEquals(expected,actual);
		
		expected = 29000;
		actual = p2.getFortune();
		assertEquals(expected,actual);
		
	}
	
	@Test
	/**
	 * Testing rent on breweries when two breweries is owned by a player 
	 */
	public void testCalcBrewRent() {
		((Brewery) Board.getFields().get(13)).setOwner(p1);
		((Brewery) Board.getFields().get(29)).setOwner(p1);
		p1.setOwnedBreweries(2);
		//Making p2, pay rent to p1: 
		oc.calcBrewRent(p2,((Brewery) Board.getFields().get(13)));
		
		//Since the rent i calculated by dicesum * 200, the expected interval of outcome is as follows:
		assertTrue(30400 <= p1.getFortune() && p1.getFortune() <= 32400);
		System.out.println(p1.getFortune()-30000); 
		
	}

}
