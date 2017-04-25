package fieldControllers;

import desktop_resources.GUI;
import entities.Board;
import entities.Player;
import fieldEntities.Field;
import fieldEntities.Ownable;
import fieldEntities.Street;
import mainControllers.MUI;

//The idea of this class is, it being responsible for buying/selling property (houses), and maybe also pawning




public class PropertyController {
	
	
	public void sellProperty (Player player) {
		boolean check = false;
		String input = MUI.getUserString("Indtast feltnummer som De ønsker at sælge");
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
							
							MUI.showMessage("De har solgt felt " + fieldNumber+", og bygningerne herpå (for kr. 500 stykket) \n I ALT: "+soldFor);
							check = true;
							System.out.println(player.getFortune());

						}
						
						

						else {
							((Ownable) f).setOwner(null);
							player.setFortune(((Ownable) f).getPrice());
							MUI.showMessage("De har solgt felt " + fieldNumber+"\n I ALT: "+ ((Ownable) f).getPrice()*(3/4));
							check = true;
						}

						if (check == true) {
							GUI.removeOwner(fieldNumber);
							
						}
						
					}

				}
			
			}

		}

	}
	
	public void pawnProperty(Player player){

		String input = MUI.getUserString("Indtast feltnummer som De ønsker at pantsætte");
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
							MUI.showMessage("De har pantsat felt " + fieldNumber);
							GUI.setDescriptionText(fieldNumber, ((Ownable) f).getFieldInfo() + " (PANTSAT)");
						}
						
					}

				}
			
			}

		}
		
	}
	
	public void unPawnProperty(Player player){
	
		String input = MUI.getUserString("Indtast feltnummer som De ønsker at pantsætte");
		int fieldNumber = Integer.parseInt(input);

		for (Field f : Board.getFields()) {

			
			if (f instanceof Ownable) {

				if (fieldNumber == f.getFieldID()) {
					if (((Ownable) f).getOwner() == player) {
						
						if (((Ownable) f).isPawned() == true) {
							((Ownable) f).setPawned(false);
							player.setFortune(-((Ownable) f).getMortgage()*(11/10));
							MUI.showMessage("De har købt den pantsatte grund " + fieldNumber);
							GUI.setDescriptionText(fieldNumber, ((Ownable) f).getFieldInfo());
						}
						
					}

				}
			
			}

		}
		
	}

}
