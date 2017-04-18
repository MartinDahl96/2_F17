package fieldControllers;

import entities.Player;

public class ParkingController {

	public  void landOnParking(Player player) {

		
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
