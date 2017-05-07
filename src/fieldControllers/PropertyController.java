package fieldControllers;

import java.io.IOException;


import desktop_resources.GUI;
import entities.Board;
import entities.Player;
import fieldEntities.Field;
import fieldEntities.Ownable;
import fieldEntities.Street;
import inputHandlers.Text;
import mainControllers.MUI;
import mainControllers.Rule;

public class PropertyController {
	
	//attributes
	private Text file = new Text("txtfiles/fieldControllerText.txt");
	private String[] textList;
	
	/**
	 * Constructor for a PropertyController.
	 */
	public PropertyController(){
		try {
			textList = file.OpenFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * used for selling a property.
	 * @param player is the seller.
	 */
	public void sellProperty (Player player) {
		boolean check = false;
		String input = MUI.getUserString(textList[24]);
		int fieldNumber = Integer.parseInt(input);

		for (Field f : Board.getFields()) {
			if (f instanceof Ownable) {
				if (fieldNumber == f.getFieldID()) {
					if (((Ownable) f).getOwner() == player) {
						if (f instanceof Street && ((Street) f).getNumOfBuildings() > 0) {
							
							int soldFor = (((Street) f).getPrice()*(3/4))+(((Street) f).getNumOfBuildings()*(((Street) f).getBuildPrice()/2));
							player.setFortune(soldFor);
							((Street) f).setNumOfBuildings(-((Street) f).getNumOfBuildings());
							MUI.setHotel(fieldNumber, false);
							MUI.SetHouses(fieldNumber, ((Street) f).getNumOfBuildings());
							((Ownable) f).setOwner(null);
						
							MUI.showMessage(textList[25] + fieldNumber+textList[26]+soldFor);
							check = true;
							System.out.println(player.getFortune());
						}
						else {
							
							int soldFor = (int) (((Ownable) f).getPrice()*0.75);
							((Ownable) f).setOwner(null);
							player.setFortune(soldFor);
							MUI.showMessage(textList[27] + fieldNumber+textList[28]+ soldFor);
							check = true;
						}

						if (check == true) {
							GUI.removeOwner(fieldNumber);
						}
						
					} else MUI.showMessage(textList[47]);
				}
			MUI.updateGUIPlayer(player.getplayerName(), player.getFortune(), player.getCurrentPosition());
			}

		}

	}
	
	/**
	 * used to pawn a property
	 * @param player is the owner of the field.
	 */
	public void pawnProperty(Player player){
		String input = MUI.getUserString(textList[29]);
		int fieldNumber = Integer.parseInt(input);

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
							MUI.showMessage(textList[30] + fieldNumber);
							GUI.setDescriptionText(fieldNumber, ((Ownable) f).getFieldInfo() + textList[31]);
						}
						
					}

				}
			
			}

		}
		
	}
	
	/**
	 * used to unpawn a field.
	 * @param player is the owner of the field.
	 */
	public void unPawnProperty(Player player){
		String input = MUI.getUserString(textList[32]);
		int fieldNumber = Integer.parseInt(input);
		Rule.calcTotalAssets(player);
		
		if(player.getTotalAssets() > 0 && player.getFortune() > 0){
		for (Field f : Board.getFields()) {	
			if (f instanceof Ownable) {

				if (fieldNumber == f.getFieldID()) {
					if (((Ownable) f).getOwner() == player) {
						
						if (((Ownable) f).isPawned() == true) {
							((Ownable) f).setPawned(false);
							player.setFortune((int) (-((Ownable) f).getMortgage()*1.1));
							MUI.showMessage(textList[33] + fieldNumber);
							GUI.setDescriptionText(fieldNumber, ((Ownable) f).getFieldInfo());
						}
					}
				}
			}
		}
		
		  } else { MUI.showMessage("De har ingen penge, og kan ikke foretage denne handling!");
       }
	}
}