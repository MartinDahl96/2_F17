package fieldControllers;

import entities.Player;
import fieldEntities.Jail;
import mainControllers.MUI;

public class JailController {
	
	
	public void landOnJail(Player player, Jail j) {
		
		if(player.getCurrentPosition() == 31){
			player.changePosition(11);
			player.setJailRounds(3);
			}
		
		if(player.getCurrentPosition() == 11){
			MUI.showMessage(j.getFieldInfo());
		}
		
		
	}	

}
