<<<<<<< HEAD
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
/**
 * MockUp class of StreetController class, Used to run JUnittests on the Mockup class. 
 * The UI part of the StreetController class has been removed in this class. 
 * @author janus
 *
 */
public class StreetControllerMockup {

	private Text file = new Text("txtfiles/fieldControllerText.txt");
	private String[] textList;

	public StreetControllerMockup(){


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
		}
	}


	public void buildProperty(Street s,Player player,boolean choice) {

		if (s.isBuildable() && player.getFortune() > s.getBuildPrice()) {
			if (choice = true) {
				player.setFortune(-s.getBuildPrice());
				s.setNumOfBuildings(1);

				if (s.getNumOfBuildings() == 5) buildHotel(player);
				else buildHouse(player);
			}
		}
	}


	public boolean checkIfBuildable(Street s,Player player) {
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
		p.setFortune(s.getBuildPrice() / 2);

	}


	public void sellHotel(Player p, Street s){
		try {
			textList = file.OpenFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		s.setNumOfBuildings(-1);
		p.setFortune(s.getBuildPrice() / 2);

	}


	public void buildHouse(Player p){
		try {
			textList = file.OpenFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public void buildHotel(Player p){
		try {
			textList = file.OpenFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

=======
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
/**
 * MockUp class of StreetController class, Used to run JUnittests on the Mockup class. 
 * The UI part of the StreetController class has been removed in this class. 
 * @author janus
 *
 */
public class StreetControllerMockup {

	private Text file = new Text("txtfiles/fieldControllerText.txt");
	private String[] textList;

	public StreetControllerMockup(){


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
		}
	}


	public void buildProperty(Street s,Player player,boolean choice) {

		if (s.isBuildable() && player.getFortune() > s.getBuildPrice()) {
			if (choice = true) {
				player.setFortune(-s.getBuildPrice());
				s.setNumOfBuildings(1);

				if (s.getNumOfBuildings() == 5) buildHotel(player);
				else buildHouse(player);
			}
		}
	}


	public boolean checkIfBuildable(Street s,Player player) {
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
		p.setFortune(s.getBuildPrice() / 2);

	}


	public void sellHotel(Player p, Street s){
		try {
			textList = file.OpenFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		s.setNumOfBuildings(-1);
		p.setFortune(s.getBuildPrice() / 2);

	}


	public void buildHouse(Player p){
		try {
			textList = file.OpenFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public void buildHotel(Player p){
		try {
			textList = file.OpenFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

>>>>>>> refs/remotes/origin/master
