package fieldControllers;

import desktop_resources.GUI;
import entities.Board;
import entities.Player;
import fieldEntities.Field;
import fieldEntities.Ownable;
import fieldEntities.Street;
import mainControllers.MUI;

//The idea of this class is it being responsible for buying/selling property (houses), and maybe also pawning

public class PropertyController {

	public void sellProperty (Player player) {
		boolean check = false;
		String input = MUI.getUserString("Indtast feltnummer som De ønsker at sælge");
		int fieldNumber = Integer.parseInt(input);

		for (Field f : Board.getFields()) {

			
			if (f instanceof Ownable) {

				if (fieldNumber == f.getFieldID()) {
					if (((Ownable) f).getOwner() == player) {
						if (f instanceof Street && ((Street) f).getNumOfBuildings() == 0) {
							((Ownable) f).setOwner(null);
							check = true;

						}

						else {
							((Ownable) f).setOwner(null);
							check = true;
						}

						if (check == true) {
							GUI.removeOwner(fieldNumber);
							player.setFortune(((Ownable) f).getPrice() / 2);
							MUI.showMessage("Du har solgt felt " + fieldNumber);
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

	
		
		
		
		
		
	System.out.println("Pawned is true");	
		
		
		
		
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

	
		
		
		
		
		
	System.out.println("unPawned");	
		
		
		
		
	
		
	}

}
