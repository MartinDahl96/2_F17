package fieldControllers;

import entities.Player;


public class StartController {
	
	
	
	public void grantStartBonus(Player player){  
		
		if(player.getCurrentPosition() < player.getPrevPosition()){
			player.setFortune(4000);
		}
	}

}