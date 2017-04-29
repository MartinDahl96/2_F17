 package fieldControllers;

import entities.Player;
import fieldEntities.Start;
import mainControllers.MUI;


public class StartController {
	
	private static Start s;
	
	public StartController(Start s){
		StartController.s = s;
		
	}
	
	public static void grantStartBonus(Player player){  
		
		if(player.getCurrentPosition() < player.getPrevPosition()){
			player.setFortune(s.getStartBonus());
		}
	}
	
	public static void cancelStartBonus(Player player){
		
		if(player.getCurrentPosition() < player.getPrevPosition()){
			player.setFortune(-s.getStartBonus());
		}
	}
	
	public void landOnStart(Player player){
		MUI.showMessage(player.getplayerName()+", De modtager kr. 4000 ved at lande på startfeltet, eller passere det.");
	}
}
