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
		
		if (o.getOwner() != null && o.getOwner() != player) payRent(player);
		else if (o.getOwner() == null) buyProperty(player);
	}

	
	public void payRent(Player player) {
		
		if(o instanceof Brewery) {
			calcBrewRent(player);
		}
		else if(!o.isPawned()) {
		MUI.showMessage(player.getplayerName() + " har betalt leje til " + o.getOwner().getplayerName());
		player.setFortune(-o.getRent());
		o.getOwner().setFortune(o.getRent());
		Ferry.setDoubleRent(false);
	}
}

	public void buyProperty(Player buyer) {
		boolean choice = MUI.getTwoButtons("Vil du købe denne grund?", "Ja", "Nej");
		
		if (buyer.getFortune() < o.getPrice()) MUI.showMessage("Du har ikke penge nok, til at købe dette uejede felt!");
	
		else if (choice) {
			MUI.showMessage("Du har købt denne grund: " + o.getFieldName() + " for kr. " + o.getPrice());
			buyer.setFortune(-o.getPrice());
			
			o.setOwner(buyer);
			MUI.setOwner(o.getFieldID(), buyer.getplayerName());
			setOwnedFields(buyer); //ændre
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
	
	public void calcBrewRent(Player p){
		Cup cup = new Cup();
		
		MUI.showMessage("Slå med terninger for at beregne lejen");
		cup.useCup();
		GUI.setDice(cup.getFaceValue1(), cup.getFaceValue2());
		MUI.showMessage("Betal leje kr. "+o.getRent()*cup.getCupValue());
		
		p.setFortune(-o.getRent()*cup.getCupValue());
		o.getOwner().setFortune(o.getRent()*cup.getCupValue());
	}
}
