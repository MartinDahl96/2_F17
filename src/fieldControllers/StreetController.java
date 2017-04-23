package fieldControllers;

import entities.Board;
import entities.Player;
import fieldEntities.Field;
import fieldEntities.Ownable;
import fieldEntities.Street;
import mainControllers.MUI;

public class StreetController {

	

	public void buildProperty(Player player, Street s) {

		checkIfBuildable(player,s);

		if (s.isBuildable() == true && player.getFortune() > s.getBuildPrice()) {
			boolean choice = MUI.getTwoButtons("Vil du bygge et hus eller hvad?", "Ja", "Nej");

			int buildHouse0 = 0;
			int buildHouse1 = 0;
			int buildHouse2 = 0;
			int buildHouse3 = 0;
			int buildHouse4 = 0;

			for (Field field : Board.getFields()) {

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

		int count3colors = 0;
		int count2colors = 0;

		for (Field field : Board.getFields()) {

			if(field instanceof Street){
			if (((Street) field).getOwner() == player) {

				if (((Street) field).getColor().equals("purple") || ((Street) field).getColor().equals("blue")) {
					count2colors++;

				}

				else if (((Street) field).getColor().equals(s.getColor())) {
					count3colors++;

				}

			}
			}
			if (count3colors == 3 || count2colors == 2) {
				s.setBuildablel(true);
			}

		}
		return s.isBuildable();

	
		
		
	}

}
