<<<<<<< HEAD
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

/**
 * Test the JailController methods.
 * 
 * @author janus
 *
 */

public class TestJailController {

	private Jail j;
	private Player p; 
	private Board b;
	private JailController jc;
	private int expected, actual;
	
	@Before
	/**
	 * Created the objects/instances needed to perform the tests. 
	 * These are created before every @Test starts.
	 * @throws Exception
	 */
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
	/**
	 * Testing the LandOnJail method.
	 * When the player lands on field number 31 it's expected that he's moved to the Jail field (number 11).
	 */
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
	/**
	 * Checks the players status when the player lands on the go to jail field, and is moved to the jail field.
	 * The players status on jailrounds should be 3, as no rounds has passed since the player went in jail.
	 * The getJailRounds status is checked in the AssertEquals:  
	 */
	public void testLandOnJailround() {
		p.changePosition(31);
		jc.landOnJail(p);
		expected = 3;
		actual = p.getJailRounds();
		assertEquals(expected, actual);
	}

}
=======
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

/**
 * Test the JailController methods.
 * 
 * @author janus
 *
 */

public class TestJailController {

	private Jail j;
	private Player p; 
	private Board b;
	private JailController jc;
	private int expected, actual;
	
	@Before
	/**
	 * Created the objects/instances needed to perform the tests. 
	 * These are created before every @Test starts.
	 * @throws Exception
	 */
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
	/**
	 * Testing the LandOnJail method.
	 * When the player lands on field number 31 it's expected that he's moved to the Jail field (number 11).
	 */
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
	/**
	 * Checks the players status when the player lands on the go to jail field, and is moved to the jail field.
	 * The players status on jailrounds should be 3, as no rounds has passed since the player went in jail.
	 * The getJailRounds status is checked in the AssertEquals:  
	 */
	public void testLandOnJailround() {
		p.changePosition(31);
		jc.landOnJail(p);
		expected = 3;
		actual = p.getJailRounds();
		assertEquals(expected, actual);
	}

}
>>>>>>> refs/remotes/origin/master
