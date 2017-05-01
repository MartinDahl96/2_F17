package test;

import java.io.IOException;

//TaxController class

import entities.Player;
import fieldEntities.Tax;
import inputHandlers.Text;
import mainControllers.MUI;

public class TaxMethodTest {

	
	private Text file = new Text("txtfiles/fieldControllerText.txt");
	private String[] textList;

	public TaxMethodTest(){
		

	}

/**
 * based on choice the player will either pay 10% of account balance
 * or 4000 from account balance. 
 * True = 4k or 2k.
 * False = 10%
 * @param player
 * @param choice
 */
	public void landOnTax(Tax t, Player player, boolean choice) {
		try {
			textList = file.OpenFile();
		} catch (IOException e) {
			e.printStackTrace();
		}


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


