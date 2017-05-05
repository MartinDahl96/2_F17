package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entities.Board;
import entities.Player;
import test.TaxControllerMockup;
import fieldEntities.Tax;

public class TestTaxController {
	Player p; 
	Board b;
	TaxControllerMockup tc;
	Tax t1,t2;
	
	@Before
	public void setUp() throws Exception {
		this.tc = new TaxControllerMockup();
	
		this.p = new Player(1,"test player");
		this.b = new Board();
		this.t1 = new Tax(5, "sa", "sa", 4000, 0.10);
		this.t2 = new Tax(39, "es", "es", 2000, 0);
		
		
	}

	@After
	public void tearDown() throws Exception {
		this.p = new Player(1,"test player");
	}

	@Test
	public void testLandOnTax4k() {
		int expected, actual;
		p.changePosition(5);
		tc.landOnTax(t1,p, true);
		expected = 26000;
		actual = p.getFortune();
		assertEquals(expected, actual);
		
	}
	
	@Test
	public void testLandOnTax10pct() {
		int expected, actual;
		p.changePosition(5);
		tc.landOnTax(t1, p, false);
		expected = 27000;
		actual = p.getFortune();
		assertEquals(expected, actual);
		
	}
	@Test
	public void testLandOnTax2k() {
		int expected, actual;
		p.changePosition(39);
		tc.landOnTax(t2,p, true);
		expected = 28000;
		actual = p.getFortune();
		assertEquals(expected, actual);
		
	}
}