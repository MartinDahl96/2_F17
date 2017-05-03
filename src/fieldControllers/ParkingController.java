package fieldControllers;

import java.io.IOException;

import entities.Player;
import fieldEntities.Parking;
import inputHandlers.Text;
import mainControllers.MUI;

public class ParkingController {
	
	//attributes
	Parking p;
	private Text file = new Text("txtfiles/fieldControllerText.txt");
	private String[] textList;
	
	/**
	 * Constructor for a ParkingController.
	 * @param p is a Parking-field object.
	 */
	public ParkingController(Parking p){
		this.p = p;
		
	}
	
	/**
	 * landOnField method for landing on a parkingfield.
	 * @param player is the player landing on the field.
	 */
	public  void landOnParking(Player player) {
		try {
			textList = file.OpenFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
			MUI.showMessage(textList[23]);
			activateImmunity(player);
			player.setFortune(p.getParkingBonus());
			
	}
	/**
	 * used to activate the player's immunity.
	 * @param player is the affected player.
	 */
	public void activateImmunity(Player player){
		
		if(player.getCurrentPosition() == 21){
			player.setImmunity(true);
		}
		
	}
	
	/**
	 * used to deactivate the player's immunity.
	 * @param player is the affected player.
	 */
	public static void deactivateImmunity(Player player){
		
		if(player.getCurrentPosition() != 21){
		player.setImmunity(false);
		
		}
	}
}
