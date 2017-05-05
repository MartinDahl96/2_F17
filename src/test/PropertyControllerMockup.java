package test;
import java.io.IOException;

import desktop_resources.GUI;
import entities.Board;
import entities.Player;
import fieldEntities.Field;
import fieldEntities.Ownable;
import fieldEntities.Street;
import inputHandlers.Text;
import mainControllers.MUI;

//The idea of this class is, it being responsible for buying/selling property (houses), and maybe also pawning

public class PropertyControllerMockup {
	private Text file = new Text("txtfiles/fieldControllerText.txt");
	private String[] textList;
	
	public void sellProperty (Player player, int fieldNumber) {
		try {
			textList = file.OpenFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		boolean check = false;
//		String input = MUI.getUserString(textList[24]);
		// int fieldNumber = Integer.parseInt(input);

		for (Field f : Board.getFields()) {

			
			if (f instanceof Ownable) {

				if (fieldNumber == f.getFieldID()) {
					if (((Ownable) f).getOwner() == player) {
						if (f instanceof Street && ((Street) f).getNumOfBuildings() > 0) {
							
							int soldFor = (((Street) f).getPrice()*(3/4))+(((Street) f).getNumOfBuildings()*(((Street) f).getBuildPrice()/2));
							
							player.setFortune(soldFor);
							((Street) f).setNumOfBuildings(-((Street) f).getNumOfBuildings());
//							MUI.setHotel(fieldNumber, false);
//							MUI.SetHouses(fieldNumber, ((Street) f).getNumOfBuildings());
							((Ownable) f).setOwner(null);
							
//							MUI.showMessage(textList[25] + fieldNumber+textList[26]+soldFor);
							check = true;
							System.out.println(player.getFortune());

						}
						
						

						else {
							((Ownable) f).setOwner(null);
							player.setFortune(((Ownable) f).getPrice());
//							MUI.showMessage(textList[27] + fieldNumber+textList[28]+ ((Ownable) f).getPrice()*(3/4));
							check = true;
						}

						if (check == true) {
							//GUI.removeOwner(fieldNumber);
							
						}
						
					}

				}
			
			}

		}

	}
	






	public void pawnProperty(Player player, int fieldNumber){
		try {
			textList = file.OpenFile();
		} catch (IOException e) {
			e.printStackTrace();
		}

//		String input = MUI.getUserString(textList[29]);
		//int fieldNumber = Integer.parseInt(input);

		for (Field f : Board.getFields()) {

			
			if (f instanceof Ownable) {

				if (fieldNumber == f.getFieldID()) {
					if (((Ownable) f).getOwner() == player) {
						if (f instanceof Street && ((Street) f).getNumOfBuildings() == 0) {
							
							((Ownable) f).setPawned(true);

						}

						else {
							((Ownable) f).setPawned(true);
						}

						if (((Ownable) f).isPawned() == true) {
							
							player.setFortune(((Ownable) f).getMortgage());
//							MUI.showMessage(textList[30] + fieldNumber);
//							GUI.setDescriptionText(fieldNumber, ((Ownable) f).getFieldInfo() + textList[31]);
						}
						
					}

				}
			
			}

		}
		
	}
	
	public void unPawnProperty(Player player, int fieldNumber){
		try {
			textList = file.OpenFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
//		String input = MUI.getUserString(textList[32]);
		//int fieldNumber = Integer.parseInt(input);

		for (Field f : Board.getFields()) {

			
			if (f instanceof Ownable) {

				if (fieldNumber == f.getFieldID()) {
					if (((Ownable) f).getOwner() == player) {
						
						if (((Ownable) f).isPawned() == true) {
							((Ownable) f).setPawned(false);
							player.setFortune(-((Ownable) f).getMortgage()*(11/10));
//							MUI.showMessage(textList[33] + fieldNumber);
//							GUI.setDescriptionText(fieldNumber, ((Ownable) f).getFieldInfo());
						}
						
					}

				}
			
			}

		}
		
	}

}