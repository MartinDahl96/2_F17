package test;

import entities.Cup;
import entities.Player;
import fieldEntities.Brewery;
import fieldEntities.Ferry;
import fieldEntities.Ownable;


/**
 * This is a MockUp class, which is used to create JUnit tests, The mockup is the same as the original.
 * However the UI involving methods has been commented out. 
 * @author janus
 *
 */
public class OwnableControllerMockup{

	public OwnableControllerMockup(){
	}


	public void landOnOwnable(Player player, Ownable o) {

		if (o.getOwner() != null && o.getOwner() != player) payRent(player,o);
		else if (o.getOwner() == null) buyProperty(player, true,o);
	}


	public void payRent(Player player, Ownable o) {
		
		if(o instanceof Brewery) {
			calcBrewRent(player,o);
		}
		else if(!o.isPawned()) {
			player.setFortune(-o.getRent());
			o.getOwner().setFortune(o.getRent());
			Ferry.setDoubleRent(false);
		}
	}

	public void buyProperty(Player buyer, boolean choice, Ownable o) {

		if (buyer.getFortune() < o.getPrice());

		else if (true) {
			buyer.setFortune(-o.getPrice());

			o.setOwner(buyer);
			setOwnedFields(buyer,o); //�ndre
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

	public void calcBrewRent(Player p, Ownable o){
		Cup cup = new Cup();
		cup.useCup();

		p.setFortune(-o.getRent()*cup.getCupValue());
		o.getOwner().setFortune(o.getRent()*cup.getCupValue());
	}
}
