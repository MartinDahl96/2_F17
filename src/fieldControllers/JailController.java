package fieldControllers;

import java.io.IOException;

import desktop_resources.GUI;
import entities.Cup;
import entities.Player;
import fieldEntities.Jail;
import inputHandlers.Text;
import mainControllers.MUI;

public class JailController {
	
	//attributes
	Jail j;
	Cup cup;
	private Text file = new Text("txtfiles/fieldControllerText.txt");
	private String[] textList;
	
	/**
	 * constructor for the JailController.
	 * @param j is a Jail-field object.
	 */
	public JailController(Jail j){
		try {
			textList = file.OpenFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.j = j;
		
	}
	/**
	 * second constructor for the jailController.
	 * Doesn't require a Jail-field object, but creates a new Cup to be used.
	 */
	public JailController(){
		try {
			textList = file.OpenFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.cup = new Cup();
		
	}

	/**
	 * landOnField-method for a jail-field.
	 * @param player is the player landing on the jail field.
	 */
	public void landOnJail(Player player) {

		if (player.getCurrentPosition() == 31) {
			player.changePosition(11);
			player.setJailRounds(3);
		}

		else if (player.getCurrentPosition() == 11) {
			MUI.showMessage(j.getFieldInfo());
		}
	}
	
	/**
	 * displays the menu for a player who is in jail.
	 * @param player is the player in jail.
	 */
	public void jailMenu(Player player) {
		String options = GUI.getUserSelection(player.getplayerName() + textList[1]+player.getJailRounds()+textList[2],textList[3], textList[4], textList[5]);
		int choice = Integer.parseInt(options.substring(0, 1));

		switch (choice) {
		case 1:
		
			rollDice(player);
			break;
		case 2:
			useJailToken(player);
			break;
		case 3:
			payBail(player);
			break;

		}

	}

	/**
	 * option to get out of jail.
	 * If the player rolls two equal dice he is let out of the jail.
	 * @param player is the player rolling the dice.
	 */
	public void rollDice(Player player) {
		cup.useCup();
		GUI.setDice(cup.getFaceValue1(), cup.getFaceValue2());
		if (cup.getFaceValue1() == cup.getFaceValue2() ) {
			MUI.showMessage(textList[6]);
			player.setJailRounds(0);
		}

		else {
			
			
			MUI.showMessage(textList[7]);
			player.setJailRounds(player.getJailRounds()-1);
	
		}
	}
		
	/**
	 * option to get out of jail.
	 * If the player owns a jailToken and decides to use it he is let out of the jail.
	 * @param player is the player using the jailToken.
	 */
	public void useJailToken(Player player) {
		if (player.getJailToken() > 0) {
			player.setJailToken(-1);
			MUI.showMessage(textList[6]);
			player.setJailRounds(0);
		}

		else {
			MUI.showMessage(textList[8]);
			jailMenu(player);
		}

	}

	/**
	 * option to get out of jail.
	 * If the player pays 1.000 kr. he is let out of the jail.
	 * @param player paying the bail.
	 */
	public void payBail(Player player) {
		int bail = 1000;
		if (player.getFortune() >= bail) {
			player.setFortune(-bail);
			MUI.showMessage(textList[6]);
			player.setJailRounds(0);
		}

		else {
			MUI.showMessage(textList[9]);
			jailMenu(player);
		}

	}
	
}
