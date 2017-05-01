package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import entities.Board;
import entities.Player;
import fieldEntities.Street;

public class TestStreetField {

	Player p1, p2;
	Street s1, s2;
	StreetControllerMockup sc;
	Board b; 

	@Before
	public void setUp() throws Exception {
		this.p1 = new Player(1, "Test Player");
		this.p2 = new Player(2,"Test Player 2");
		this.s1 = new Street(2, "Roedorvevej","Vej", 1000, 100, 200, 300, 400, 500, 600, 1000, "blue");
		this.s2 = new Street(4, "Hvidorvevej","Vej2", 1000, 100, 200, 300, 400, 500, 600, 1000, "blue");
		this.sc = new StreetControllerMockup(s1);
		b = new Board();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testEntities() {
		assertNotNull(p1);
		assertNotNull(p2);
		assertNotNull(s1);
		assertNotNull(s2);
		assertTrue(p1 instanceof Player);
		assertTrue(p2 instanceof Player);
		assertTrue(s1 instanceof Street);
		assertTrue(s2 instanceof Street);
	}
	
	@Test
	public void testGetRent0Houses() {
		int actual, expected;
		s1.setOwner(p1);
		actual = s1.getRent();
		expected = 100;
		assertEquals(actual,expected);
		
		
	}
	@Test
	public void testGetRent1House() {
		int actual, expected;
		s1.setOwner(p1);
		s2.setOwner(p1);
		s1.setBuildable(true);
		s2.setBuildable(true);
		
		System.out.println(s1.isBuildable());
		System.out.print(p1.getFortune() +">"+s1.getBuildPrice());
		sc.buildProperty(p1, true);
		
		actual = s1.getRent();
		expected = 200;
		assertEquals(actual,expected);
	}
	@Test
	public void testGetRent2Houses() {
		
	}
	@Test
	public void testGetRent3Houses() {
		
	}
	@Test
	public void testGetRent4Houses() {
		
	}
	@Test
	public void testGetRentHotel() {
		
	}
	@Test
	public void testSellHouseAndGetRent() {
		
	}
	@Test
	public void testSellHotelAndGetRent() {
		
	}

}
