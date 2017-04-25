package fieldControllers;

import entities.Player;
import fieldEntities.Start;


public class StartController {
	
	Start s;
	
	public StartController(Start s){
		this.s = s;
		
	}
	
	
	
	public void grantStartBonus(Player player){  
		
		if(player.getCurrentPosition() < player.getPrevPosition()){
			player.setFortune(4000);
		}
	}
	
	public static void cancelStartBonus(Player player){
		
		if(player.getCurrentPosition() < player.getPrevPosition()){
			player.setFortune(-4000);
		}
	}

}
