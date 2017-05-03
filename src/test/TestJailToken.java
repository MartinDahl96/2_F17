package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entities.Board;
import entities.Player;
import fieldEntities.Jail;

public class TestJailToken {

	Board b;
	Player p;
	JailControllerMockup jc;
	Jail j;

	@Before
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
	public void testEntities() {
		assertNotNull(p);
		assertNotNull(j);
		assertTrue(p instanceof Player);
		assertTrue(j instanceof Jail);
	}

	@Test
	//Testing choice 2 and 3, since choice 1 is based on RNG.
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
	public void testUseJailToken() {
		//Gives player 1 jailtoken (chancecard), using jail menu 2 to got out of jail with the jailtoken:
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
