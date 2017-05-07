package test;


import entities.Player;
import fieldEntities.Parking;



/**
 * Mockup class of the ParkingController. MockUp classes doesn't contain UI methods.
 * Hence it's possible to perform JUnittests on the class. 
 * @author janus
 *
 */

public class ParkingControllerMockup {


	Parking p;

	public ParkingControllerMockup(Parking p){
		this.p = p;

	}


	public void landOnParking(Player player) {

		activateImmunity(player);
		player.setFortune(p.getParkingBonus());

	}

	public void activateImmunity(Player player){

		if(player.getCurrentPosition() == 21){
			player.setImmunity(true);
		}

	}


	public static void deactivateImmunity(Player player){

		if(player.getCurrentPosition() != 21){
			player.setImmunity(false);

		}
	}
}
