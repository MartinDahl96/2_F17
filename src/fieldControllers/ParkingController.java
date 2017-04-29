 package fieldControllers;

import entities.Player;
import fieldEntities.Parking;
import mainControllers.MUI;

public class ParkingController {
	
	Parking p;
	
	public ParkingController(Parking p){
		this.p = p;
		
	}
	

	public  void landOnParking(Player player) {
		
			MUI.showMessage("De er immun på dette felt (Deres formue kan ikke skades af andre spillere), og De modtager kr. 2000");
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
