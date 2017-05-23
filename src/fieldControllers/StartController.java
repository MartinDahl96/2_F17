package fieldControllers;

import java.io.IOException;

import entities.Player;
import fieldEntities.Start;
import inputHandlers.Text;
import mainControllers.MUI;


public class StartController {
	
	//attributes
	private static Start s;
	private Text file = new Text("txtfiles/fieldControllerText.txt");
	private String[] textList;
	
	/**
	 * constructor for the StartController.
	 * @param s is a start-field object.
	 */
	public StartController(Start s){
		try {
			textList = file.OpenFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		StartController.s = s;
		
	}
	
	/**
	 * used to grant the startbonus to a player.
	 * @param player is the receive of the bonus.
	 */
	public static void grantStartBonus(Player player){  
		
		if(player.getCurrentPosition() < player.getPrevPosition()){
			player.setFortune(s.getStartBonus());
		}
	}
	
	/**
	 * used to cancel the startbonus.
	 * Is only used if the player draws a card where it states to discard the startbonus.
	 * @param player is the player who received a bonus, but shouldn't.
	 */
	public static void cancelStartBonus(Player player){
		
		if(player.getCurrentPosition() < player.getPrevPosition()){
			player.setFortune(-s.getStartBonus());
		}
	}
	
	/**
	 * landOnField method for a start-field.
	 * @param player is the player landing on the field.
	 */
	public void landOnStart(Player player){
		MUI.showMessage(player.getplayerName()+textList[34]);
	}
}
