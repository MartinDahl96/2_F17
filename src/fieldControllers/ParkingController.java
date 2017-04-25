package fieldControllers;

import entities.Player;
import mainControllers.MUI;

public class ParkingController {
	
	

	public  void landOnParking(Player player) {
		
			MUI.showMessage("De er immun på dette felt (Deres formue kan ikke skades af andre spillere), og De modtager kr. 2000");
			activateImmunity(player);
			player.setFortune(2000);
			
	}
	
	public void activateImmunity(Player player){
		
		if(player.getCurrentPosition() == 21){
			player.setImmunity(true);
		}
		
	}
	
	
	public void deactivateImmunity(Player player){
		
		player.setImmunity(false);
	}

}
