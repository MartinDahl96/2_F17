package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entities.Die;

public class TestDie {

	Die d;
	
	@Before
	public void setUp() throws Exception {
		d = new Die();
	}	

	@After
	public void tearDown() throws Exception {
		d = null;
	}

	@Test
		public final void testRoll() {

			int one = 0, two = 0, three = 0, four = 0, five = 0, six = 0;

			for (int i=1; i<600001; i++){
				d.roll();
				int roll = d.getRoll();

				if (roll == 1){
					one ++;
				}
				else if (roll == 2){
					two ++;
				}
				else if (roll == 3){
					three ++;
				}
				else if (roll == 4){
					four ++;
				}
				else if (roll == 5){
					five ++;
				}
				else if (roll == 6){
					six ++;
				}
			}

			assertTrue("Error, not enough 1's " + one, 96000 <= one);
			assertTrue("Error, too many 1's " + one, 104000 >= one);

			assertTrue("Error, not enough 2's " + two, 96000 <= two); 
			assertTrue("Error, too many 2's " + two, 104000 >= two);

			assertTrue("Error, not enough 3's " + three, 96000 <= three); 
			assertTrue("Error, too many 3's " + three, 104000 >= three);

			assertTrue("Error, not enough 4's " + four, 96000 <= four); 
			assertTrue("Error, too many 4's " + four, 104000 >= four);

			assertTrue("Error, not enough 5's " + five, 96000 <= five); 
			assertTrue("Error, too many 5's " + five, 104000 >= five);

			assertTrue("Error, not enough 6's " + six, 96000 <= six); 
			assertTrue("Error, too many 6's " + six, 104000 >= six);

			
			System.out.println("Expected deviation of each roll is between 96000 - 104000: \n");
			System.out.println("Number of 1's: " + one);
			System.out.println("Number of 2's: " + two);
			System.out.println("Number of 3's: " + three);
			System.out.println("Number of 4's: " + four);
			System.out.println("Number of 5's: " + five);
			System.out.println("Number of 6's: " + six);
			System.out.println("\n");


		}

}
