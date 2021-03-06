package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import entities.Board;
import entities.Player;
import fieldEntities.Field;
import fieldEntities.Ownable;
import fieldEntities.Street;

/**
 * Unittest of the class Street, aswell as the property controller.
 * @author janus
 *
 */

public class TestStreetField {

	Player p;
	StreetControllerMockup sc;
	Board b; 

	@Before
	/**
	 * Creates the objects/instances needed to perform the tests:
	 * These are being created before each @Test
	 * @throws Exception
	 */
	public void setUp() throws Exception {
		this.p = new Player(1, "Test Player");
		this.sc = new StreetControllerMockup();
		b = new Board();
	}

	@After
	public void tearDown() throws Exception {
		this.p = new Player(1, "Test Player");
		this.sc = new StreetControllerMockup();
		b = new Board();
		
	}

	@Test
	/**
	 * Test that the player is a instance of the player class and that the player has values.
	 */
	public void testEntities() {
		assertNotNull(p);
		assertTrue(p instanceof Player);
		
	}
	
	@Test
	/**
	 * Tests the rent of a street is correct with 0 houses:
	 */
	public void testGetRent0Houses() {
		int actual, expected;
		((Ownable) Board.getFields().get(2)).setOwner(p);
		expected = 50;
		actual = ((Street) Board.getFields().get(2)).getRent();
		assertEquals(actual,expected);
		
		
	}
	@Test
	/**
	 * Tests the rent of a street is correct with 1 house:
	 */
	public void testGetRent1House() {
		int actual, expected;
		((Ownable) Board.getFields().get(2)).setOwner(p);
		((Ownable) Board.getFields().get(4)).setOwner(p);
		
		assertEquals(((Ownable) Board.getFields().get(2)).getOwner(), p);
		assertTrue(sc.checkIfBuildable(((Street) Board.getFields().get(2)),p));
		
		((Street) Board.getFields().get(2)).setBuildable(true);
		((Street) Board.getFields().get(4)).setBuildable(true);
		sc.buildProperty(((Street) Board.getFields().get(2)), p, true);


		expected = 29000;
		actual = p.getFortune();
		assertEquals(expected,actual);
		
		expected = 250;
		actual = ((Street) Board.getFields().get(2)).getRent();
		assertEquals(expected,actual);
	}
	@Test
	/**
	 * Tests the rent of a street is correct with 2 houses:
	 */
	public void testGetRent2Houses() {
		int expected, actual;
		((Ownable) Board.getFields().get(2)).setOwner(p);
		((Ownable) Board.getFields().get(4)).setOwner(p);
		
		assertEquals(((Ownable) Board.getFields().get(2)).getOwner(), p);
		assertTrue(sc.checkIfBuildable(((Street) Board.getFields().get(2)),p));
		assertTrue(((Street) Board.getFields().get(2)).getNumOfBuildings() == 0);
		
		//Building two houses on field 2:
		sc.buildProperty(((Street) Board.getFields().get(2)), p, true);
		sc.buildProperty(((Street) Board.getFields().get(2)), p, true);
		
		//Checking if the player has been billed for the houses: 
		expected = 28000;
		actual = p.getFortune();
		assertEquals(expected,actual);
		
		//Checking that the rent is correct:
		expected = 750;
		actual = ((Street) Board.getFields().get(2)).getRent();
		assertEquals(expected,actual);
		
	}
	@Test
	/**
	 * Tests the rent of a street is correct with 3 houses:
	 */
	public void testGetRent3Houses() {
		int expected, actual;
		((Ownable) Board.getFields().get(2)).setOwner(p);
		((Ownable) Board.getFields().get(4)).setOwner(p);
		
		assertEquals(((Ownable) Board.getFields().get(2)).getOwner(), p);
		assertTrue(sc.checkIfBuildable(((Street) Board.getFields().get(2)),p));
		assertTrue(((Street) Board.getFields().get(2)).getNumOfBuildings() == 0);
		
		//Building two houses on field 2:
		sc.buildProperty(((Street) Board.getFields().get(2)), p, true);
		sc.buildProperty(((Street) Board.getFields().get(2)), p, true);
		sc.buildProperty(((Street) Board.getFields().get(2)), p, true);
		
		//Checking if the player has been billed for the houses: 
		expected = 27000;
		actual = p.getFortune();
		assertEquals(expected,actual);
		
		//Checking that the rent is correct:
		expected = 2250;
		actual = ((Street) Board.getFields().get(2)).getRent();
		assertEquals(expected,actual);
	}
	@Test
	/**
	 * Tests the rent of a street is correct with 4 houses:
	 */
	public void testGetRent4Houses() {
		int expected, actual;
		((Ownable) Board.getFields().get(2)).setOwner(p);
		((Ownable) Board.getFields().get(4)).setOwner(p);
		
		assertEquals(((Ownable) Board.getFields().get(2)).getOwner(), p);
		assertTrue(sc.checkIfBuildable(((Street) Board.getFields().get(2)),p));
		assertTrue(((Street) Board.getFields().get(2)).getNumOfBuildings() == 0);
		
		//Building two houses on field 2:
		sc.buildProperty(((Street) Board.getFields().get(2)), p, true);
		sc.buildProperty(((Street) Board.getFields().get(2)), p, true);
		sc.buildProperty(((Street) Board.getFields().get(2)), p, true);
		sc.buildProperty(((Street) Board.getFields().get(2)), p, true);
		
		//Checking if the player has been billed for the houses: 
		expected = 26000;
		actual = p.getFortune();
		assertEquals(expected,actual);
		
		//Checking that the rent is correct:
		expected = 4000;
		actual = ((Street) Board.getFields().get(2)).getRent();
		assertEquals(expected,actual);
		
	}
	@Test
	/**
	 * Tests the rent of a street is correct a hotel:
	 */
	public void testGetRentHotel() {
		int expected, actual;
		((Ownable) Board.getFields().get(2)).setOwner(p);
		((Ownable) Board.getFields().get(4)).setOwner(p);
		
		assertEquals(((Ownable) Board.getFields().get(2)).getOwner(), p);
		assertTrue(sc.checkIfBuildable(((Street) Board.getFields().get(2)),p));
		assertTrue(((Street) Board.getFields().get(2)).getNumOfBuildings() == 0);
		
		//Building two houses on field 2:
		sc.buildProperty(((Street) Board.getFields().get(2)), p, true);
		sc.buildProperty(((Street) Board.getFields().get(2)), p, true);
		sc.buildProperty(((Street) Board.getFields().get(2)), p, true);
		sc.buildProperty(((Street) Board.getFields().get(2)), p, true);
		sc.buildProperty(((Street) Board.getFields().get(2)), p, true);
		
		//Checking if the player has been billed for the houses: 
		expected = 25000;
		actual = p.getFortune();
		assertEquals(expected,actual);
		
		//Checking that the rent is correct:
		expected = 6000;
		actual = ((Street) Board.getFields().get(2)).getRent();
		assertEquals(expected,actual);
		
		
	}
	@Test
	/**
	 * Tests that a player is able to sell a house, and that the streets rent is affected accordingly:
	 **/
	public void testSellHouseAndGetRent() {
		int expected, actual;
		((Ownable) Board.getFields().get(2)).setOwner(p);
		((Ownable) Board.getFields().get(4)).setOwner(p);
		
		assertEquals(((Ownable) Board.getFields().get(2)).getOwner(), p);
		assertTrue(sc.checkIfBuildable(((Street) Board.getFields().get(2)),p));
		assertTrue(((Street) Board.getFields().get(2)).getNumOfBuildings() == 0);
		
		//Building two houses on field 2:
		sc.buildProperty(((Street) Board.getFields().get(2)), p, true);
		
		//Selling the house again. 
		sc.sellHouse(p,((Street) Board.getFields().get(2)));
		
		//Checking if the there's 0 buildings on Field 2:
		assertTrue(((Street) Board.getFields().get(2)).getNumOfBuildings() == 0);
		
		//Checking if the player has been billed 1000 when building the house, and has been paid 500 for the sale of the house:
		expected = 29500;
		actual = p.getFortune();
		assertEquals(expected,actual);
		
		
	}
	@Test
	/**
	 * Tests that a player is able to sell a hotel, and that the streets rent is affected accordingly:
	 **/
	public void testSellHotelAndGetRent() {
		int expected, actual;
		((Ownable) Board.getFields().get(2)).setOwner(p);
		((Ownable) Board.getFields().get(4)).setOwner(p);
		
		assertEquals(((Ownable) Board.getFields().get(2)).getOwner(), p);
		assertTrue(sc.checkIfBuildable(((Street) Board.getFields().get(2)),p));
		assertTrue(((Street) Board.getFields().get(2)).getNumOfBuildings() == 0);
		
		//Building a hotel (5 houses):
		sc.buildProperty(((Street) Board.getFields().get(2)), p, true);
		sc.buildProperty(((Street) Board.getFields().get(2)), p, true);
		sc.buildProperty(((Street) Board.getFields().get(2)), p, true);
		sc.buildProperty(((Street) Board.getFields().get(2)), p, true);
		sc.buildProperty(((Street) Board.getFields().get(2)), p, true);
		
		//Using the sellHotel() to sell a "house". 
		sc.sellHotel(p, ((Street) Board.getFields().get(2)));
		
		//Checking that there's still 4 houses on the Field: 
		assertTrue(((Street) Board.getFields().get(2)).getNumOfBuildings() == 4);
		
		expected = 25500;
		actual = p.getFortune();
		assertEquals(expected,actual);
		
		 
	}
}