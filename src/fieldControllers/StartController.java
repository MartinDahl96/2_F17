package fieldControllers;

import java.io.IOException;

import entities.Player;
import fieldEntities.Start;
import inputHandlers.Text;
import mainControllers.MUI;


public class StartController {
	
	private static Start s;
	private Text file = new Text("txtfiles/fieldControllerText.txt");
	private String[] textList;
	
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
		try {
			textList = file.OpenFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		MUI.showMessage(player.getplayerName()+textList[34]);
	}
}
