package entities;

import desktop_resources.GUI;

public class Jail extends Field {

	public Jail(String fieldName, String fieldInfo) {
		super(fieldName, fieldInfo);

	}
	
	@Override
	public void landOnField(Player player) {
		
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

					if (cup.getDie1() == cup.getDie2()) {
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
	if(player.getCurrentPosition() == 31){
		player.changePosition(11);
		player.setJailRounds(3);
		}
		

	}

}


