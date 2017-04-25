package fieldControllers;

import desktop_resources.GUI;
import entities.Cup;
import entities.Player;
import fieldEntities.Jail;
import mainControllers.MUI;

public class JailController {

	public void landOnJail(Player player, Jail j) {

		if (player.getCurrentPosition() == 31) {
			player.changePosition(11);
			player.setJailRounds(3);
		}

		if (player.getCurrentPosition() == 11) {
			MUI.showMessage(j.getFieldInfo());
		}
	}

	public void jailMenu(Player player) {

		String options = GUI.getUserSelection(player.getplayerName() + ", du er i fængsel, vælg ét af følgende: \t [Fængselsrunder tilbage: "+player.getJailRounds()+"]","1. Slå to ens", "2. Benyt benådningskort", "3. Betal kr. 1000");
		int choice = Integer.parseInt(options.substring(0, 1));

		switch (choice) {
		case 1:
			Cup cup = new Cup();
			rollDice(player, cup);
			break;
		case 2:
			useJailToken(player);
			break;
		case 3:
			payBail(player);
			break;

		}

	}

	public void rollDice(Player player, Cup cup) {
		cup.useCup();
		GUI.setDice(cup.getFaceValue1(), cup.getFaceValue2());
		if (cup.getFaceValue1() == cup.getFaceValue2()) {
			MUI.showMessage("De er en fri mand!");
			player.setJailRounds(0);
		}

		else {
			
			
			MUI.showMessage("Desværre, De er fortsat i fængsel! - Turen går videre");
			player.setJailRounds(player.getJailRounds()-1);
			
			
		}
			
			
			
			
			}
		

	public void useJailToken(Player player) {
		if (player.getJailToken() > 0) {
			player.setJailToken(-1);
			MUI.showMessage("De er en fri mand!");
			player.setJailRounds(0);
		}

		else {
			MUI.showMessage("Desværre, De har ingen benådningskort - prøv noget andet");
			jailMenu(player);
		}

	}

	public void payBail(Player player) {
		int bail = 1000;
		if (player.getFortune() >= bail) {
			player.setFortune(-bail);
			MUI.showMessage("Du er en fri mand!");
			player.setJailRounds(0);
		}

		else {
			MUI.showMessage("Desværre, De har ikke penge nok - prøv noget andet");
			jailMenu(player);
		}

	}
	
}
