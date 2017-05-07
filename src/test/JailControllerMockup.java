package test;



import entities.Cup;
import entities.Player;
import fieldEntities.Jail;
/**
 * MockupClass for the JailController, where the UI elements of the original class is removed.
 * As the UI is gone, we're able to run JUnit test on the class. 
 * @author janus
 *
 */
public class JailControllerMockup {

	Jail j;
	Cup cup;

	public JailControllerMockup(Jail j){
		this.j = j;

	}
	public JailControllerMockup(){
		this.cup = new Cup();

	}

	public void landOnJail(Player player) {

		if (player.getCurrentPosition() == 31) {
			player.changePosition(11);
			player.setJailRounds(3);
		}

		else if (player.getCurrentPosition() == 11) {
		}
	}

	public void jailMenu(Player player,int choice) {
	
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

	public void rollDice(Player player) {
		
		cup.useCup();
		if (cup.getFaceValue1() == cup.getFaceValue2() ) {
			player.setJailRounds(0);
		}

		else {

			player.setJailRounds(player.getJailRounds()-1);

		}
	}


	public void useJailToken(Player player) {
		if (player.getJailToken() > 0) {
			player.setJailToken(-1);
			player.setJailRounds(0);
		}

		else {
		}

	}

	public void payBail(Player player) {
		int bail = 1000;
		if (player.getFortune() >= bail) {
			player.setFortune(-bail);
			player.setJailRounds(0);
		}

		else {
		}

	}

}