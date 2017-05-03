package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entities.Board;
import entities.Cup;
import entities.Player;
import fieldControllers.JailController;
import fieldEntities.Jail;

public class TestJailController {

	private Jail j;
	private Player p; 
	private Board b;
	private JailController jc;
	private int expected, actual;
	
	@Before
	public void setUp() throws Exception {
		this.p = new Player(1,"Test player");
		this.b = new Board();
		this.j = new Jail(11, "Jail", "j");
		this.jc = new JailController();
	}

	@After
	public void tearDown() throws Exception {
		p = null;
		b = null;
		j = null;
	
	}

	@Test
	public void testLandOnJail() {
		
		// Testing if player lands on go to jail field:
		p.changePosition(31);
		//Player lands on field 31.
		jc.landOnJail(p);
		expected = 11;
		actual = p.getCurrentPosition();
		assertEquals(expected, actual);
		
	}
	@Test
	public void testLandOnJailround() {
		p.changePosition(31);
		jc.landOnJail(p);
		expected = 3;
		actual = p.getJailRounds();
		assertEquals(expected, actual);
	}

}
