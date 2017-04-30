package fieldControllers;

import java.io.IOException;

//TaxController class

import entities.Player;
import fieldEntities.Tax;
import inputHandlers.Text;
import mainControllers.MUI;

public class TaxController {
	
	Tax t;
	private Text file = new Text("txtfiles/fieldControllerText.txt");
	private String[] textList;
	
	public TaxController(Tax t){
	this.t = t;
	
	}


	public void landOnTax(Player player) {
		try {
			textList = file.OpenFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
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
