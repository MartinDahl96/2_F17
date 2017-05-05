package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entities.Board;
import entities.Player;
import fieldEntities.Jail;
/**
 * Unittest for the JailToken (from Chance card), the Jail menu, the use of the JailToken and a test of the PayBill method:
 * @author janus
 *
 */
public class TestJailToken {

	Board b;
	Player p;
	JailControllerMockup jc;
	Jail j;

	@Before
	/**
	 * Creates objects/instances needed for the tests:
	 * These are created before each test.
	 * @throws Exception
	 */
	public void setUp() throws Exception {
		this.b = new Board();
		this.p = new Player(1, "Test Player");
		this.jc = new JailControllerMockup();
		this.j = new Jail(11, "Jail", "JailDescription");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	/**
	 * Testing the objects to make sure that they have a value, hence is not null. 
	 * And testing that the objects are instances of the correct classes. 
	 */
	public void testEntities() {
		assertNotNull(p);
		assertNotNull(j);
		assertTrue(p instanceof Player);
		assertTrue(j instanceof Jail);
	}

	@Test
	/**
	 * Testing the jail menu choice 2 and 3:
	 * Checks that when a player chooses to pay 1000 to get our of jail (JailRounds set to 0).
	 * The test also checks that the player has been billed for 1000. 
	 * 
	 * the 2nd test in the jail menu, checks that the player is able to choose to pay with a JailToken
	 * to get out of Jail.
	 */
	public void testJailMenu() {
		//Choice 3 in jailmenu - Paying 1000 to get out of jail:
		int actual, expected;
		p.setJailRounds(3);
		jc.jailMenu(p, 3);
		expected = 0;
		actual = p.getJailRounds();
		assertEquals(expected,actual);

		expected = 29000;
		actual = p.getFortune();
		assertEquals(expected,actual);

		//Gives player a jailtoken (chancecard), using jail menu 2 to got out of jail with the jailtoken:
		p.setJailRounds(3);
		p.setJailToken(1);
		assertTrue(p.getJailToken()==1);
		jc.jailMenu(p, 2);
		expected = 0;
		actual = p.getJailRounds();
		assertEquals(expected,actual);

		expected = 0;
		actual = p.getJailToken();
		assertEquals(expected,actual);

	}

	@Test
	/**
	 * Tests that a player can get out of jail by using a jailtoken.
	 * Gives player 1 jailtoken (chancecard), using jail menu 2 to got out of jail with the jailtoken:
	 * 
	 **/
	public void testUseJailToken() {
		int expected, actual;

		p.setJailRounds(3);
		p.setJailToken(1);
		assertTrue(p.getJailToken()==1);
		jc.useJailToken(p);
		expected = 0;
		actual = p.getJailRounds();
		assertEquals(expected,actual);

		expected = 0;
		actual = p.getJailToken();
		assertEquals(expected,actual);
	}

	@Test
	/**
	 * Tests if the player is able to pay 1000 to get out of the jail:
	 */
	public void testPayBail() {
		int expected, actual;
		p.setJailRounds(3);
		jc.jailMenu(p, 3);
		expected = 0;
		actual = p.getJailRounds();
		assertEquals(expected,actual);

		expected = 29000;
		actual = p.getFortune();
		assertEquals(expected,actual);
	}

}
