package test;

import entities.Player;
import fieldEntities.Parking;

public class ParkingControllerMethodTest {


	Parking p;

	public ParkingControllerMethodTest(Parking p){
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

