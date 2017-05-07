package test;




//TaxController class

import entities.Player;
import fieldEntities.Tax;


/**
 * Mockup of the TaxController class, The UT methods have been removed to make the class suitable for Unittesting.
 * @author janus
 *
 */
public class TaxControllerMockup {



	public TaxControllerMockup(){
	
	}

/**
 * based on choice the player will either pay 10% of account balance
 * or 4000 from account balance. 
 * True = 4k or 2k.
 * False = 10%
 * @param t is a Tax field.
 * @param player is the player landing on the tax field.
 * @param choice is the choice made by the player.
 */
	public void landOnTax(Tax t, Player player, boolean choice) {
		
		if (player.getCurrentPosition() == 5) {
			if (choice == true) {
				player.setFortune(-t.getFixedTax());

			}

			else if (choice == false) {

				player.setFortune((int) (-t.getRevenueTax() * player.getFortune()));
			}

		}

		else if (player.getCurrentPosition() == 39) {
			player.setFortune(-t.getFixedTax());
		}

	}
}