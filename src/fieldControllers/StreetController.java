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

public class StreetController {
	
	Street s;
	private Text file = new Text("txtfiles/fieldControllerText.txt");
	private String[] textList;
	
	public StreetController(Street s){
		this.s = s;
	}
	
	public void sellBuilding(Player player) {
		try {
			textList = file.OpenFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String input = MUI.getUserString(textList[35]);
		Street field = ((Street) Board.getFields().get(Integer.parseInt(input)));

		if (field.getOwner() == player) { 
			if (field.getNumOfBuildings() == 5) sellHotel(player, field);
			else sellHouse(player, field);}
		else {
			MUI.showMessage(textList[36]);
		}
	}
	
	
	public void buildProperty(Player player) {
		try {
			textList = file.OpenFile();
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (s.isBuildable() && player.getFortune() > s.getBuildPrice()) {
			boolean choice = MUI.getTwoButtons(player.getplayerName() + textList[37] + s.getBuildPrice() + textList[38], textList[39],textList[40]);
			if (choice) {
				player.setFortune(-s.getBuildPrice());
				s.setNumOfBuildings(1);

				if (s.getNumOfBuildings() == 5) buildHotel(player);
				else buildHouse(player);
			}
		}
	}
	

	public boolean checkIfBuildable(Player player) {
		try {
			textList = file.OpenFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		int count2colors = 0;
		int count3colors = 0;
		
		if(s.getOwner() == player){
		for (Field field : Board.getFields()) {
			if (field instanceof Street && ((Street) field).getOwner() == player) {
				if (((Street) field).getColor().equals(textList[41]) || ((Street) field).getColor().equals(textList[42])) count2colors++;
				else if (((Street) field).getColor().equals(s.getColor())) count3colors++;
				}
			}
		}
		
		if (count3colors == 3 || count2colors == 2) {
			s.setBuildable(true);
			buildProperty(player);
		}
		
		return s.isBuildable();
	}
	
	
	
	public void sellHouse(Player p, Street s){
		try {
			textList = file.OpenFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		s.setNumOfBuildings(-1);
		MUI.SetHouses(s.getFieldID(), s.getNumOfBuildings());
		p.setFortune(s.getBuildPrice() / 2);
		MUI.showMessage(textList[43]);
		
	}
	
	
	public void sellHotel(Player p, Street s){
		try {
			textList = file.OpenFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		s.setNumOfBuildings(-1);
		MUI.setHotel(s.getFieldID(), false);
		p.setFortune(s.getBuildPrice() / 2);
		MUI.showMessage(textList[44]);
		
	}
	
	
	public void buildHouse(Player p){
		try {
			textList = file.OpenFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		MUI.SetHouses(p.getCurrentPosition(), s.getNumOfBuildings());
		MUI.showMessage(textList[45]);
	}
	
	
	public void buildHotel(Player p){
		try {
			textList = file.OpenFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		MUI.setHotel(p.getCurrentPosition(), true);
		MUI.showMessage(textList[46]);
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