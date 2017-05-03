<<<<<<< HEAD
package test;

import java.io.IOException;

import desktop_resources.GUI;
import entities.Cup;
import entities.Player;
import fieldEntities.Jail;
import inputHandlers.Text;
import mainControllers.MUI;

public class JailControllerMockup {
		
		Jail j;
		Cup cup;
		private Text file = new Text("txtfiles/fieldControllerText.txt");
		private String[] textList;
		
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
				//MUI.showMessage(j.getFieldInfo());
			}
		}

		public void jailMenu(Player player,int choice) {
			try {
				textList = file.OpenFile();
			} catch (IOException e) {
				e.printStackTrace();
			}

			//String options = GUI.getUserSelection(player.getplayerName() + textList[1]+player.getJailRounds()+textList[2],textList[3], textList[4], textList[5]);
			//int choice = Integer.parseInt(options.substring(0, 1));

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
			try {
				textList = file.OpenFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
			cup.useCup();
			//GUI.setDice(cup.getFaceValue1(), cup.getFaceValue2());
			if (cup.getFaceValue1() == cup.getFaceValue2() ) {
			//	MUI.showMessage(textList[6]);
				player.setJailRounds(0);
			}

			else {
				
				
				//MUI.showMessage(textList[7]);
				player.setJailRounds(player.getJailRounds()-1);
		
			}
		}
			

		public void useJailToken(Player player) {
			if (player.getJailToken() > 0) {
				player.setJailToken(-1);
				//MUI.showMessage(textList[6]);
				player.setJailRounds(0);
			}

			else {
				//MUI.showMessage(textList[8]);
				//jailMenu(player);
			}

		}

		public void payBail(Player player) {
			int bail = 1000;
			if (player.getFortune() >= bail) {
				player.setFortune(-bail);
				//MUI.showMessage(textList[6]);
				player.setJailRounds(0);
			}

			else {
				//MUI.showMessage(textList[9]);
				//jailMenu(player);
			}

		}
	
}
=======
package test;

import java.io.IOException;

import desktop_resources.GUI;
import entities.Cup;
import entities.Player;
import fieldEntities.Jail;
import inputHandlers.Text;
import mainControllers.MUI;

public class JailControllerMockup {
		
		Jail j;
		Cup cup;
		private Text file = new Text("txtfiles/fieldControllerText.txt");
		private String[] textList;
		
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
				//MUI.showMessage(j.getFieldInfo());
			}
		}

		public void jailMenu(Player player,int choice) {
			try {
				textList = file.OpenFile();
			} catch (IOException e) {
				e.printStackTrace();
			}

			//String options = GUI.getUserSelection(player.getplayerName() + textList[1]+player.getJailRounds()+textList[2],textList[3], textList[4], textList[5]);
			//int choice = Integer.parseInt(options.substring(0, 1));

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
			try {
				textList = file.OpenFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
			cup.useCup();
			//GUI.setDice(cup.getFaceValue1(), cup.getFaceValue2());
			if (cup.getFaceValue1() == cup.getFaceValue2() ) {
			//	MUI.showMessage(textList[6]);
				player.setJailRounds(0);
			}

			else {
				
				
				//MUI.showMessage(textList[7]);
				player.setJailRounds(player.getJailRounds()-1);
		
			}
		}
			

		public void useJailToken(Player player) {
			if (player.getJailToken() > 0) {
				player.setJailToken(-1);
				//MUI.showMessage(textList[6]);
				player.setJailRounds(0);
			}

			else {
				//MUI.showMessage(textList[8]);
				//jailMenu(player);
			}

		}

		public void payBail(Player player) {
			int bail = 1000;
			if (player.getFortune() >= bail) {
				player.setFortune(-bail);
				//MUI.showMessage(textList[6]);
				player.setJailRounds(0);
			}

			else {
				//MUI.showMessage(textList[9]);
				//jailMenu(player);
			}

		}
	
}
>>>>>>> refs/remotes/origin/master
