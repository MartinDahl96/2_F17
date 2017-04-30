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
	
	public StreetController(){
	}
	
	public void sellBuilding(Player player) {
		
		String input = MUI.getUserString("Indtast feltnummer, hvor De ønsker at sælge en bygning.");
		Street field = ((Street) Board.getFields().get(Integer.parseInt(input)));

		if (field.getOwner() == player) { 
			if (field.getNumOfBuildings() == 5) sellHotel(player, field);
			else sellHouse(player, field);}
		else {
			MUI.showMessage("De har ingen bygninger på dette felt!");
		}
	}
	
	
	public void buildProperty(Player player) {
		
		checkIfBuildable(player);
		if (s.isBuildable() && player.getFortune() > s.getBuildPrice()) {
			boolean choice = MUI.getTwoButtons(player.getplayerName() + ", vil De bygge på dette felt for kr. " + s.getBuildPrice() + "?", "Ja","Nej");
			if (choice) {
				player.setFortune(-s.getBuildPrice());
				s.setNumOfBuildings(1);

				if (s.getNumOfBuildings() == 5) buildHotel(player);
				else buildHouse(player);
			}
		}
	}
	

	public boolean checkIfBuildable(Player player) {
		
		int count2colors = 0;
		int count3colors = 0;
		
		if(s.getOwner() == player){
		for (Field field : Board.getFields()) {
			if (field instanceof Street && ((Street) field).getOwner() == player) {
				if (((Street) field).getColor().equals("purple") || ((Street) field).getColor().equals("blue")) count2colors++;
				else if (((Street) field).getColor().equals(s.getColor())) count3colors++;
				}
			}
		}
		
		if (count3colors == 3 || count2colors == 2) {
			s.setBuildable(true);
			
		}
		
		return s.isBuildable();
	}
	
	
	
	public void sellHouse(Player p, Street s){
		
		s.setNumOfBuildings(-1);
		MUI.SetHouses(s.getFieldID(), s.getNumOfBuildings());
		p.setFortune(s.getBuildPrice() / 2);
		MUI.showMessage("Et hus på denne grund er solgt");
		
	}
	
	
	public void sellHotel(Player p, Street s){
		
		s.setNumOfBuildings(-1);
		MUI.setHotel(s.getFieldID(), false);
		p.setFortune(s.getBuildPrice() / 2);
		MUI.showMessage("Deres hotel er solgt, De står tilbage med 4 huse");
		
	}
	
	
	public void buildHouse(Player p){
		MUI.SetHouses(p.getCurrentPosition(), s.getNumOfBuildings());
		MUI.showMessage("De har bygget hus, dermed er lejen steget");
	}
	
	
	public void buildHotel(Player p){
		MUI.setHotel(p.getCurrentPosition(), true);
		MUI.showMessage("De har bygget et hotel, dermed er lejen steget markant");
	}
	
}




//for (Field f : Board.getFields()) {
//if (f instanceof Street) {
//	if (fieldNumber == f.getFieldID()) {
//		if (((Street) f).getOwner() == player) {
//
//			if (f instanceof Street && ((Street) f).getNumOfBuildings() > 0) {
//				if (((Street) f).getNumOfBuildings() == 5) {
//					((Street) f).setNumOfBuildings(-1);
//					MUI.setHotel(fieldNumber, false);
//					player.setFortune(((Street) f).getBuildPrice() / 2);
//					MUI.showMessage("Deres hotel er solgt, De står tilbage med 4 huse");
//				}
//				else {
//					((Street) f).setNumOfBuildings(-1);
//					MUI.SetHouses(fieldNumber, ((Street) f).getNumOfBuildings());
//					player.setFortune(((Street) f).getBuildPrice() / 2);
//					MUI.showMessage("Et hus på denne grund er solgt");
//				}
//			}
//			
//			else {
//				MUI.showMessage("De har ingen bygninger på dette felt!");
//			}
//
//		}
//
//	}
//
//}
//
//}