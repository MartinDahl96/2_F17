package test;




//TaxController class

import entities.Player;
import fieldEntities.Tax;


public class TaxMethodTest {

	public TaxMethodTest(){
		

	}

/**
 * based on choice the player will either pay 10% of account balance
 * or 4000 from account balance. 
 * True = 4k or 2k.
 * False = 10%
 * @param t is a Tax field.
 * @param player is the player landing on the field.
 * @param choice is the choice made by the player.
 */
	public void landOnTax(Tax t, Player player, boolean choice) {
		
		if (player.getCurrentPosition() == 5) {
			// choice = MUI.getTwoButtons(textList[19],textList[20],textList[21]);
			if (choice == true) {
				player.setFortune(-t.getFixedTax());

			}

			else if (choice == false) {

				player.setFortune((int) (-t.getRevenueTax() * player.getFortune()));
			}

		}

		else if (player.getCurrentPosition() == 39) {
			//MUI.showMessage(textList[22]);
			player.setFortune(-t.getFixedTax());
		}

	}
}


