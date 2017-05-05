package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entities.Board;
import entities.Player;
import test.ParkingControllerMockup;
import fieldEntities.Parking;
public class TestParkingController {

	ParkingControllerMockup pc;
	Player p; 
	Parking pa;
	Board b;
	
	@Before
	public void setUp() throws Exception {
		this.p = new Player(1, "test player");
		this.b = new Board();
		this.pa = new Parking(21, "Parking", "Park", 2000);
		this.pc = new ParkingControllerMockup(pa);
	}

	@After 
	public void tearDown() throws Exception {
		
	}

	@Test
	public void testLandOnParkingBonus() {
		p.changePosition(21);
		int expected, actual;
		pc.landOnParking(p);
		expected = 32000;
		actual = p.getFortune();
		assertEquals(expected, actual);	
	}

	@Test
	public void testLandOnParkingImmunity() {
		p.changePosition(21);
		boolean expected, actual;
		pc.landOnParking(p);
		expected = true;
		actual = p.getImmunity();
		assertEquals(expected, actual);	
	}

}