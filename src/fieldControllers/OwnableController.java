package fieldControllers;

import entities.Player;
import fieldEntities.Ownable;
import mainControllers.MUI;


public class OwnableController {
	
	
	public void landOnOwnable(Player player, Ownable o) {
		
		System.out.println("Ejeren: "+o.getOwner());
		
		if (o.getOwner() != null && o.getOwner() != player) {
			System.out.println("der er en ejer");
			payRent(player,o);
			
		}

		else if (o.getOwner() == null) {
			System.out.println("Der er ingen ejer");
			buyProperty(player,o);
		}

	

	}

	public void payRent(Player payer, Ownable o) {

		MUI.showMessage(payer.getplayerName() + " har betalt leje til " + o.getOwner().getplayerName());
		payer.setFortune(-o.getRent());

		o.getOwner().setFortune(o.getRent());
		MUI.setFortune(o.getOwner().getplayerName(), o.getOwner().getFortune());

	}

	public void buyProperty(Player buyer, Ownable o) {

		if (buyer.getFortune() < o.getPrice()) {
			MUI.showMessage("Du har ikke penge nok, til at købe dette uejede felt!");
		}

		boolean choice = MUI.getTwoButtons("Vil du købe denne grund?", "Ja", "Nej");
		if (choice == true) {
			MUI.showMessage("Du har købt denne grund: " + o.getFieldName() + " for kr. " + o.getPrice());
			buyer.setFortune(-o.getPrice());
			
			o.setOwner(buyer);
			MUI.setOwner(o.getFieldID(), buyer.getplayerName());
			
		}

	}

}
