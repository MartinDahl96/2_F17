package fieldControllers;

import entities.Board;
import entities.Player;
import fieldEntities.Field;
import fieldEntities.Ownable;
import fieldEntities.Street;
import mainControllers.MUI;

public class StreetController {

	

	

	public void sellProperty() {
		// MANGLER
	}

	public void buildProperty(Player player, Street s) {

		checkIfBuildable(player,);

		if (s.isBuildable() == true && player.getFortune() > s.getBuildPrice()) {
			boolean choice = MUI.getTwoButtons("Vil du bygge et hus eller hvad?", "Ja", "Nej");

			int buildHouse0 = 0;
			int buildHouse1 = 0;
			int buildHouse2 = 0;
			int buildHouse3 = 0;
			int buildHouse4 = 0;

			for (Field field : b.getFields()) {

				if (((Street) field).getColor() == s.getColor()) {

					if (s.getNumOfBuildings() == 0) {
						buildHouse0++;

						if (s.getNumOfBuildings() == 1) {
							buildHouse1++;

						}
						if (s.getNumOfBuildings() == 2) {
							buildHouse2++;
						}
						if (s.getNumOfBuildings() == 3) {
							buildHouse3++;
						}
						if (s.getNumOfBuildings() == 4) {
							buildHouse4++;

						}
					}
				}

				if (buildHouse0 == 3) {
					if (choice == true) {
						s.setNumOfBuildings();
					}

				}
				if (buildHouse1 == 3) {
					if (choice == true) {
						s.setNumOfBuildings();
					}
				}
				if (buildHouse2 == 3) {
					if (choice == true) {
						s.setNumOfBuildings();
					}
				}
				if (buildHouse3 == 3) {
					if (choice == true) {
						s.setNumOfBuildings();
					}
				}
				if (buildHouse4 == 3) {
					if (choice == true) {
						s.setNumOfBuildings();
					}
				}

			}

		}

	}

	public boolean checkIfBuildable(Player player, Street s){

		int tempCounter3 = 0;
		int tempCounter2 = 0;

		for (Field field : Board.getFields()) {

			if(field instanceof Street){
			if (((Street) field).getOwner() == player) {

				if (((Street) field).getColor().equals("purple") || ((Street) field).getColor().equals("blue")) {
					tempCounter2++;

				}

				else if (((Street) field).getColor().equals(s.getColor())) {
					tempCounter3++;

				}

			}
			}
			if (tempCounter3 == 3 || tempCounter2 == 2) {
				s.setBuildablel(true);
			}

		}
		return s.isBuildable();

	
		
		
	}

}
