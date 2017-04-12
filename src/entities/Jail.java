package entities;

import desktop_resources.GUI;

public class Jail extends Field {

	/**
	 * Constructor for a Jail-field.
	 * @param fieldName is used as a name for the field.
	 * @param fieldInfo is used to give info about the field.
	 */
	public Jail(int fieldID, String fieldName, String fieldInfo) {
		super(fieldID, fieldName, fieldInfo);

	}
	
	/**
	 * The landOnField-method for the Jail field.
	 * The method will first check if the player is in prison, by checking if the amount of rounds the player has left in prison is > 0.
	 * It will then give the player 3 options in order to get out:
	 * roll the dice in order to hit two equal dice,
	 * pay 1000 and roll the dice to move out,
	 * use a jailToken to get out of jail.
	 * If the player tries to use a jailToken without having one, the player will be declined to get out of jail, and will therefore have to pick another option.
	 */
	
	@Override
	public void landOnField(Player player) {
		
		if(player.getCurrentPosition() == 31){
			player.changePosition(11);
			player.setJailRounds(3);
			}
		
		
		if (player.getJailRounds() > 0) {

			Cup cup = new Cup();
			boolean playerChoice = true;

			while (playerChoice) {

				String useDie = "Slå to ens";
				String pay = "Betal kr. 1000";
				String jailToken = "Brug Kongens benådning";
				String choice = GUI.getUserSelection("Du er i fængsel, vælg hvordan du vil komme ud:", useDie, pay , jailToken);

				if (choice.equals(useDie)) {
					cup.useCup();

					if (cup.getFaceValue1() == cup.getFaceValue2()) {
						player.setJailRounds(0);
						player.setCurrentPosition(cup.getCupValue());
						playerChoice = false;

					}

					else {
						GUI.showMessage("Du slå desværre ikke to ens, og forbliver i fængsel lidt endnu");
						player.setJailRounds(player.getJailRounds() - 1);
						playerChoice = false;
					}

				}

				else if (choice.equals(pay)) {
					player.setFortune(-1000);
					player.setJailRounds(0);
					cup.useCup();
					player.setCurrentPosition(cup.getCupValue());
					playerChoice = false;

				}

				else if (choice.equals(jailToken) && player.getJailToken() > 0) {
					player.setJailToken(player.getJailToken() - 1);
					player.setJailRounds(0);

					cup.useCup();
					player.setCurrentPosition(cup.getCupValue());
					playerChoice = false;
				}
				else if (choice.equals(jailToken) && player.getJailToken() < 1){
						GUI.showMessage("Du har ingen ben�dning");
					}
				}

			}
		/**
		 * If the player lands on the go-to-jail-field (field number 31), he will be moved to jail (field number 11) and become imprisoned for 3 rounds.
		 */
	
		

	}

}


