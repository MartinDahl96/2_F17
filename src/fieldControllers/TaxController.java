package fieldControllers;

//TaxController class

import entities.Player;
import fieldEntities.Tax;
import mainControllers.MUI;

public class TaxController {
	
	Tax t;
	
	public TaxController(Tax t){
	this.t = t;
	
	}


	public void landOnTax(Player player) {

		
		
		if (player.getCurrentPosition() == 5) {
			boolean choice = MUI.getTwoButtons("4000 kr eller 10 % af din beholdning", "4000", "10 % af din beholdning");
			if (choice == true) {
				player.setFortune(-t.getFixedTax());

			}

			else if (choice == false) {

				player.setFortune((int) (-t.getRevenueTax() * player.getFortune()));
			}

		}

		else if (player.getCurrentPosition() == 39) {
			MUI.showMessage("Betal skat: kr. 2000");
			player.setFortune(-t.getFixedTax());
		}

	}
}
