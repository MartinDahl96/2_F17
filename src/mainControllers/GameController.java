package mainControllers;

import java.awt.Color;
import java.util.ArrayList;
import desktop_codebehind.Car;
import desktop_resources.GUI;
import entities.Board;
import entities.Cup;
import entities.Player;
import fieldControllers.*;
import fieldEntities.Chance;
import fieldEntities.Jail;
import fieldEntities.Ownable;
import fieldEntities.Parking;
import fieldEntities.Tax;

public class GameController {

	private static ArrayList<Player> players = new ArrayList<Player>();
	private ArrayList<Car> cars = new ArrayList<Car>();
	private Cup cup = new Cup();
	private Board board = new Board();
	private boolean noWinner = false;
	private int bankruptPlayers = 0;
	private JailController jailControle = new JailController();
	private StreetController streetControle = new StreetController(null);	
	private PropertyController propertyControle = new PropertyController();

	public void startGame() {
		createPlayers();
		playerTurn();

	}

	public void playerTurn() {

		while (noWinner == false) {

			for (int i = 0; i < players.size(); i++) {
				checkForWinner(i);
				
				if(players.get(i).getJailRounds() == 0) {
					playerOptions(i);
					
				}
				
				else if (players.get(i).getJailRounds() > 0) {
					jailControle.jailMenu(players.get(i));
				}
				
				checkPlayerLost(i);
				
			}
		}
	}

	public void playerOptions(int i) {

		String options = GUI.getUserSelection(players.get(i).getplayerName() + " vælg dit næste træk:","1. Kast med terningerne", "2. Sælg hus/hotel", "3. Sælg grund", "4. Pantsæt", "5. Køb pantsat tilbage","6. Afslut spil");
		int choice = Integer.parseInt(options.substring(0, 1));
		

		switch (choice) {
		case 1:
			throwDice(i);
			break;
		case 2:
			streetControle.sellBuilding(players.get(i));
			playerOptions(i);
			break;
		case 3:
			propertyControle.sellProperty(players.get(i));
			playerOptions(i);
			break;
		case 4:
			propertyControle.pawnProperty(players.get(i));
			playerOptions(i);
			break;
		case 5:
			propertyControle.unPawnProperty(players.get(i));
			playerOptions(i);
			break;
		case 6:
			System.exit(0);
			// Save with database on this line
			break;
		}

	}
	
	public void throwDice(int i) {
		cup.useCup();
		GUI.setDice(cup.getFaceValue1(), cup.getFaceValue2());
		players.get(i).setCurrentPosition(1);
		playOnBoard(i);

		
	}

	
	public void playOnBoard(int i) {
	
		MUI.updateGUIPlayer(players.get(i).getplayerName(), players.get(i).getFortune(), players.get(i).getCurrentPosition());
		
		board.landOnField(players.get(i));
		StartController.grantStartBonus(players.get(i)); 		// grants the player startBonus if he landed on/passed the start field
		ParkingController.deactivateImmunity(players.get(i));	// deactivates immunnity if the current field is not a parking field
		
		MUI.updateGUIPlayer(players.get(i).getplayerName(), players.get(i).getFortune(), players.get(i).getCurrentPosition());

	}

	
	public void createPlayers() {

		int numOfPlayers = Integer.parseInt(MUI.setFiveButtons("Velkommen til Matador, vælg antal spillere:", "2", "3", "4", "5", "6"));

		for (int i = 0; i < numOfPlayers; i++) {
			setPlayers(i);
			setCars(i);
		}

	}

	
	public void setPlayers(int i) {
		players.add(new Player(i, MUI.nameValidation("INDTAST NAVN PÅ SPILLER " + (i + 1) + " \n(Skal indeholde bogstaver, og være mellem 2-10 karaktere lang)")));
		MUI.showMessage(players.get(i).getplayerName() + "! Din formue består af kr. " + players.get(i).getFortune());
	}

	
	public void setCars(int i) {
		cars.add(new Car.Builder().typeCar().primaryColor(MUI.carColor(i + 1)).secondaryColor(Color.white).build());
		GUI.addPlayer(players.get(i).getplayerName(), players.get(i).getFortune(), cars.get(i));
		MUI.setCarOnStart(players.get(i), players.get(i).getplayerName());
	}

	
	public static ArrayList<Player> getPlayers() {
		return players;
	}
	
	public void checkForWinner(int i) {
			if(bankruptPlayers == players.size()-1){
				noWinner = true;
				MUI.showMessage(players.get(i).getplayerName()+" vandt spillet!");
				MUI.exitGame();
			
				
				}
			}
	
	public void checkPlayerLost(int i){
		if(players.get(i).isBankRupt()){
			MUI.showMessage(players.get(i).getplayerName() +", De er gået bankerot og har dermed tabt!");
			MUI.removeCar(players.get(i).getplayerName());
			bankruptPlayers++;
				
		}
	}
}
