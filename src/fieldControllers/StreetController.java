package fieldControllers;

import desktop_resources.GUI;
import entities.Board;
import entities.Player;
import fieldEntities.Field;
import fieldEntities.Ownable;
import fieldEntities.Street;
import mainControllers.MUI;

public class StreetController {
	
	Street s;
	
	public StreetController(Street s){
		this.s = s;
		
	}
	
	public void sellBuilding(Player player) {

		String input = MUI.getUserString("Indtast feltnummer, hvor De ønsker at sælge en bygning");
		int fieldNumber = Integer.parseInt(input);

		for (Field f : Board.getFields()) {
			if (f instanceof Street) {
				if (fieldNumber == f.getFieldID()) {
					if (((Street) f).getOwner() == player) {

						if (f instanceof Street && ((Street) f).getNumOfBuildings() > 0) {
							if (((Street) f).getNumOfBuildings() == 5) {
								((Street) f).setNumOfBuildings(-1);
								MUI.setHotel(fieldNumber, false);
								player.setFortune(((Street) f).getBuildPrice() / 2);
								MUI.showMessage("Deres hotel er solgt, De står tilbage med 4 huse");
							}
							else {
								((Street) f).setNumOfBuildings(-1);
								MUI.SetHouses(fieldNumber, ((Street) f).getNumOfBuildings());
								player.setFortune(((Street) f).getBuildPrice() / 2);
								MUI.showMessage("Et hus på denne grund er solgt");
							}
						}
						
						else {
							MUI.showMessage("De har ingen bygninger på dette felt!");
						}

					}

				}

			}

		}

	}
	

	public void buildProperty(Player player, Street s) {

		if (s.isBuildable() == true && player.getFortune() > s.getBuildPrice()) {
			boolean choice = MUI.getTwoButtons(
					player.getplayerName() + ", vil De bygge på dette felt for kr. " + s.getBuildPrice() + "?", "Ja",
					"Nej");

			if (choice == true) {
				player.setFortune(-s.getBuildPrice());
				s.setNumOfBuildings(1);

				if (s.getNumOfBuildings() == 5) {
					MUI.setHotel(player.getCurrentPosition(), true);
					MUI.showMessage("De har bygget et hotel, dermed er lejen steget markant");
				}

				else {
					MUI.SetHouses(player.getCurrentPosition(), s.getNumOfBuildings());
					MUI.showMessage("De har bygget hus, dermed er lejen steget");
				}
			}
		}
	}

	public boolean checkIfBuildable(Player player, Street s) {
		int count3colors = 0; 
		int count2colors = 0;

		for (Field field : Board.getFields()) {
			if (field instanceof Street) {
				if (((Street) field).getOwner() == player) {

					if (((Street) field).getColor().equals("purple") || ((Street) field).getColor().equals("blue")) {
						count2colors++;
					}
					
					else if (((Street) field).getColor().equals(s.getColor())) {
						count3colors++;

					}
				}
			}
		}
		
			if (count3colors == 3 || count2colors == 2) {
				s.setBuildable(true);
				buildProperty(player, s);	
				}
		
		return s.isBuildable();

	}
}
