package fieldControllers;

import desktop_resources.GUI;
import entities.Cup;
import entities.Player;
import fieldEntities.Brewery;
import fieldEntities.Ferry;
import fieldEntities.Ownable;
import fieldEntities.Street;
import mainControllers.MUI;


public class OwnableController{
	
	Ownable o;
	
	public OwnableController(Ownable o){
		this.o = o;
		
		
	}
	
	public void landOnOwnable(Player player) {
		
//		if(o.getOwner() == player && o instanceof Street){
//			sc.checkIfBuildable(player);
//			
//		}
		
		if (o.getOwner() != null && o.getOwner() != player) {
			payRent(player);
		}

		else if (o.getOwner() == null) {
			buyProperty(player);
		}
		
	}

	public void payRent(Player payer) {
		
		if(o instanceof Brewery){
			MUI.showMessage("Slå med terninger for at beregne lejen");
			Cup cup = new Cup();
			cup.useCup();
			GUI.setDice(cup.getFaceValue1(), cup.getFaceValue2());
			MUI.showMessage("Betal leje kr. "+o.getRent()*cup.getCupValue());
			
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

	public void buyProperty(Player buyer) {

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
			setOwnedFields(buyer);
			
		}

	}
	
	public void setOwnedFields(Player player){
		if(o instanceof Ferry){
			player.setOwnedFerries(player.getOwnedFerries()+1);
		}
		
		if(o instanceof Brewery){
			player.setOwnedBreweries(player.getOwnedBreweries()+1);
		}
	}
	
	

}
