package fieldControllers;

import java.io.IOException;

//TaxController class

import entities.Player;
import fieldEntities.Tax;
import inputHandlers.Text;
import mainControllers.MUI;

public class TaxController {
	
	//attributes
	Tax t;
	private Text file = new Text("txtfiles/fieldControllerText.txt");
	private String[] textList;
	
	/**
	 * Constructor for the TaxController.
	 * @param t is a Tax-field object.
	 */
	public TaxController(Tax t){
		try {
			textList = file.OpenFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.t = t;
	
	}

	/**
	 * landOnField for a tax-field.
	 * @param player is the player landing on the field.
	 */
	public void landOnTax(Player player) {
		if (player.getCurrentPosition() == 5) {
			boolean choice = MUI.getTwoButtons(textList[19],textList[20],textList[21]);
			if (choice == true) {
				player.setFortune(-t.getFixedTax());

			}

			else if (choice == false) {

				player.setFortune((int) (-t.getRevenueTax() * player.getFortune()));
			}

		}

		else if (player.getCurrentPosition() == 39) {
			MUI.showMessage(textList[22]);
			player.setFortune(-t.getFixedTax());
		}

	}
}
