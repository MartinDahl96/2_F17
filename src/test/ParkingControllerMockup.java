package test;

import java.io.IOException;
import entities.Player;
import fieldEntities.Parking;
import inputHandlers.Text;


/**
 * Mockup class of the ParkingController. MockUp classes doesn't contain UI methods.
 * Hence it's possible to perform JUnittests on the class. 
 * @author janus
 *
 */

public class ParkingControllerMockup {


	Parking p;
	private Text file = new Text("txtfiles/fieldControllerText.txt");
	private String[] textList;

	public ParkingControllerMockup(Parking p){
		this.p = p;

	}


	public void landOnParking(Player player) {
		try {
			textList = file.OpenFile();
		} catch (IOException e) {
			e.printStackTrace();
		}

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

