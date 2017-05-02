package test;

import java.io.IOException;
import entities.Player;
import fieldEntities.Parking;
import inputHandlers.Text;
import mainControllers.MUI;

public class ParkingControllerMethodTest {


	Parking p;
	private Text file = new Text("txtfiles/fieldControllerText.txt");
	private String[] textList;

	public ParkingControllerMethodTest(Parking p){
		this.p = p;

	}


	public void landOnParking(Player player) {
		try {
			textList = file.OpenFile();
		} catch (IOException e) {
			e.printStackTrace();
		}

		//MUI.showMessage(textList[23]);
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

