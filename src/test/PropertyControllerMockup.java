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
 * Mockup class of PropertyController, used to perform JUnittests, as the UI calls are removed. 
 * @author janus
 *
 */

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

		for (Field f : Board.getFields()) {


			if (f instanceof Ownable) {

				if (fieldNumber == f.getFieldID()) {
					if (((Ownable) f).getOwner() == player) {
						if (f instanceof Street && ((Street) f).getNumOfBuildings() > 0) {

							int soldFor = (((Street) f).getPrice()*(3/4))+(((Street) f).getNumOfBuildings()*(((Street) f).getBuildPrice()/2));

							player.setFortune(soldFor);
							((Street) f).setNumOfBuildings(-((Street) f).getNumOfBuildings());
							((Ownable) f).setOwner(null);

							check = true;
							System.out.println(player.getFortune());

						}



						else {
							((Ownable) f).setOwner(null);
							player.setFortune(((Ownable) f).getPrice());
							check = true;
						}

						if (check == true) {

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
 * Mockup class of PropertyController, used to perform JUnittests, as the UI calls are removed. 
 * @author janus
 *
 */

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

		for (Field f : Board.getFields()) {


			if (f instanceof Ownable) {

				if (fieldNumber == f.getFieldID()) {
					if (((Ownable) f).getOwner() == player) {
						if (f instanceof Street && ((Street) f).getNumOfBuildings() > 0) {

							int soldFor = (((Street) f).getPrice()*(3/4))+(((Street) f).getNumOfBuildings()*(((Street) f).getBuildPrice()/2));

							player.setFortune(soldFor);
							((Street) f).setNumOfBuildings(-((Street) f).getNumOfBuildings());
							((Ownable) f).setOwner(null);

							check = true;
							System.out.println(player.getFortune());

						}



						else {
							((Ownable) f).setOwner(null);
							player.setFortune(((Ownable) f).getPrice());
							check = true;
						}

						if (check == true) {

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

>>>>>>> refs/remotes/origin/master
}