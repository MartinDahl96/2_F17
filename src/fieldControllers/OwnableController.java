package fieldControllers;

import desktop_resources.GUI;
import entities.Cup;
import entities.Player;
import fieldEntities.Brewery;
import fieldEntities.Ferry;
import fieldEntities.Ownable;
import mainControllers.MUI;


public class OwnableController {
	
	
	public void landOnOwnable(Player player, Ownable o) {
		
		System.out.println("Ejeren: "+o.getOwner());
		
		if (o.getOwner() != null && o.getOwner() != player) {
			payRent(player,o);
			
		}

		else if (o.getOwner() == null) {
			buyProperty(player,o);
		}
		
	}

	public void payRent(Player payer, Ownable o) {
		
		if(o instanceof Brewery){
			MUI.showMessage("Slå med terninger for at beregne lejen");
			Cup cup = new Cup();
			cup.useCup();
			GUI.setDice(cup.getFaceValue1(), cup.getFaceValue2());
			
			payer.setFortune(-o.getRent()*cup.getCupValue());
			MUI.setFortune(payer.getplayerName(), payer.getFortune());
			
			o.getOwner().setFortune(o.getRent()*cup.getCupValue());
			MUI.setFortune(o.getOwner().getplayerName(), o.getOwner().getFortune());
			
		}
		else {
			
			if(o.isPawned() == false){
		MUI.showMessage(payer.getplayerName() + " har betalt leje til " + o.getOwner().getplayerName());
		payer.setFortune(-o.getRent());
		MUI.setFortune(payer.getplayerName(), payer.getFortune());
		o.getOwner().setFortune(o.getRent());
		MUI.setFortune(o.getOwner().getplayerName(), o.getOwner().getFortune());
		
			}
		}

	}

	public void buyProperty(Player buyer, Ownable o) {

		if (buyer.getFortune() < o.getPrice()) {
			MUI.showMessage("Du har ikke penge nok, til at købe dette uejede felt!");
		}

		boolean choice = MUI.getTwoButtons("Vil du købe denne grund?", "Ja", "Nej");
		if (choice == true) {
			MUI.showMessage("Du har købt denne grund: " + o.getFieldName() + " for kr. " + o.getPrice());
			buyer.setFortune(-o.getPrice());
			MUI.setFortune(buyer.getplayerName(), buyer.getFortune());
			
			o.setOwner(buyer);
			MUI.setOwner(o.getFieldID(), buyer.getplayerName());
			setOwnedFields(buyer, o);
			
		}

	}
	
	public void setOwnedFields(Player player, Ownable o){
		if(o instanceof Ferry){
			player.setOwnedFerries(player.getOwnedFerries()+1);
		}
		
		if(o instanceof Brewery){
			player.setOwnedBreweries(player.getOwnedBreweries()+1);
		}
	}
	
	

}
