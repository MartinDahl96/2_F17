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
 * JUnit test on PropertyController.
 * @author janus
 *
 */

public class PropertyControllerTest {
	
	Ownable o;
	Street street;
	Field field;
	Player p; 
	Board b;
	PropertyControllerMockup pc;
	
	@Before
	/**
	 * Instanciates objects of the classes needed to perform the test. 
	 * @throws Exception
	 */
	public void setUp() throws Exception {
		this.p = new Player(1,"Test Player");
		this.b = new Board();
		pc = new PropertyControllerMockup();
		
	}

	@After
	public void tearDown() throws Exception {
		this.p = new Player(1,"Test Player");
	}
	
	@Test
	/**
	 * Test which confirms that the player object isn't null, and that p is a instance of the player class. 
	 */
	public void testEntities() {
		assertNotNull(p);
		assertTrue(p instanceof Player);
		
	}

	@Test
	/**
	 * Testing the SellProperty method:
	 * Supplies a player with two Sreet fields. 
	 * Checks that the owner is indeed the player.
	 * 
	 * Using the property controller to test the SellProperty().
	 */
	public void testSellProperty() {
	
		((Ownable) Board.getFields().get(2)).setOwner(p);
		((Ownable) Board.getFields().get(4)).setOwner(p);
		assertEquals(((Ownable) Board.getFields().get(2)).getOwner(), p);

		pc.sellProperty(p, 2);
		
		assertEquals(((Ownable) Board.getFields().get(2)).getOwner(), null);
		
	}

	@Test
	/**
	 * Testing PawnProperty method.
	 * Supplies a player with two properties. 
	 * Pawns one of the properties.
	 * Checks if the field is indeed pawned. 
	 */
	public void testPawnProperty() {
		((Ownable) Board.getFields().get(2)).setOwner(p);
		((Ownable) Board.getFields().get(4)).setOwner(p);
		assertEquals(((Ownable) Board.getFields().get(2)).getOwner(), p);
		
		pc.pawnProperty(p, 2);
		assertEquals(((Ownable) Board.getFields().get(2)).isPawned(),true);
		
	}

	@Test
	/**
	 * Tests UnPawnProperty():
	 * Supplies a player with two properties. 
	 * Pawns a property, and checks if the property is indeed pawned. 
	 * Unpawns the property, and checks if the property is indeed unpawned.  
	 */
	public void testUnPawnProperty() {
		((Ownable) Board.getFields().get(2)).setOwner(p);
		((Ownable) Board.getFields().get(4)).setOwner(p);
		assertEquals(((Ownable) Board.getFields().get(2)).getOwner(), p);
		
		pc.pawnProperty(p, 2);
		assertEquals(((Ownable) Board.getFields().get(2)).isPawned(),true);
		pc.unPawnProperty(p, 2);
		assertEquals(((Ownable) Board.getFields().get(2)).isPawned(),false);
	}

}