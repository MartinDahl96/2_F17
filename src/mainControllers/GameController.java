package mainControllers;

import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import desktop_codebehind.Car;
import desktop_resources.GUI;
import entities.Board;
import entities.Cup;
import entities.Player;
import fieldControllers.*;

import inputHandlers.Text;
import mainControllers.Rule;
import sql.GameDAO;

public class GameController {

	private static ArrayList<Player> players = new ArrayList<Player>();
	private ArrayList<Car> cars = new ArrayList<Car>();
	private Cup cup = new Cup();
	private Board board = new Board();
	private boolean winner = false;
	private int bankruptPlayers = 0;
	private JailController jailControle = new JailController();
	private StreetController streetControle = new StreetController(null);	
	private PropertyController propertyControle = new PropertyController();
	
	private GameDAO gDAO = new GameDAO();
	
	private Rule Rule = new Rule();

	private Text file = new Text("txtfiles/mainControllerText.txt");
	private String[] textList;

	public GameController(){

		try {
			textList = file.OpenFile();
		} catch (IOException e) {
			e.printStackTrace();
		} 	
	}


	public void startGame() {
		Boolean choice = MUI.getTwoButtons("Vælg: ", "Nyt spil", "Indlæs tidligere spil");
		if (choice){
//			gDAO.newGame();
			createPlayers();
			gDAO.saveGame();
			playerTurn();

		}
		else if (!choice) {
			gDAO.loadGame();
			playerTurn();
			
			
		}
	}


	public void playerTurn() {
		
		while (winner == false) {

			for (int i = 0; i < players.size(); i++) {
				checkForWinner(i);
				ParkingController.activateImmunity(players.get(i));
	
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
		gDAO.updateSave();
		
		Rule.calcTotalAssets(players.get(i));
		
		if (players.get(i).isBankRupt() == true){

			String options = GUI.getUserSelection(players.get(i).getplayerName() + textList[22], textList[2], textList[3], textList[4]);
			int choice = Integer.parseInt(options.substring(0, 1));

			switch (choice) {
			case 1:
				streetControle.sellBuilding(players.get(i));
				playerOptions(i);
				break;
			case 2:
				propertyControle.sellProperty(players.get(i));
				playerOptions(i);
				break;
			case 3:
				propertyControle.pawnProperty(players.get(i));
				playerOptions(i);
				break;
			}
		}
		String options = GUI.getUserSelection(players.get(i).getplayerName() + textList[0],textList[1], textList[2], textList[3], textList[4], textList[5],textList[6]);
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
			gDAO.updateSave();
			System.exit(0);
			break;
		}
		gDAO.updateSave();
	}

	public void throwDice(int i) {
		
		if(players.get(i).getFortune() > 0){ //er dette nødvendigt?


			cup.useCup();
			GUI.setDice(cup.getFaceValue1(), cup.getFaceValue2());
			players.get(i).setCurrentPosition(2);
			playOnBoard(i);
		}
		else{
			MUI.showMessage("SÃ¦lg noget lort");
		}

	}


	public void playOnBoard(int i) {

		MUI.updateGUIPlayer(players.get(i).getplayerName(), players.get(i).getFortune(), players.get(i).getCurrentPosition());

		board.landOnField(players.get(i));
		StartController.grantStartBonus(players.get(i)); 		// grants the player startBonus if he landed on/passed the start field
		ParkingController.deactivateImmunity(players.get(i));	// deactivates immunnity if the current field is not a parking field

		MUI.updateGUIPlayer(players.get(i).getplayerName(), players.get(i).getFortune(), players.get(i).getCurrentPosition());

	}


	public void createPlayers() {
		int numOfPlayers = Integer.parseInt(MUI.setFiveButtons(textList[7], textList[8], textList[9], textList[10], textList[11], textList[12]));

		for (int i = 0; i < numOfPlayers; i++) {
			setPlayers(i);
			setCars(i);
			
			

			
		}

	}


	public void setPlayers(int i) {

		players.add(new Player(i, MUI.nameValidation(textList[13] + (i + 1) + textList[14])));
		MUI.showMessage(players.get(i).getplayerName() + textList[15] + players.get(i).getFortune());
		players.get(i).setPlayerID(i+1);
	}


	public void setCars(int i) {
		MUI.createCars(cars);
		GUI.addPlayer(players.get(i).getplayerName(), players.get(i).getFortune(), cars.get(i));
		MUI.setCarOnStart(players.get(i));
	}


	public static ArrayList<Player> getPlayers() {
		return players;
	}

	public static Player getPlayer(int playerID) {
		Player p = null;
		for (Player player : players) {
			if (player.getPlayerID() == playerID) {
				p = player;
			}
		}
		return p;
	}
		
	

	public void checkForWinner(int i) {

		if(bankruptPlayers == players.size()-1){
			winner = true;
			MUI.showMessage(players.get(i).getplayerName()+textList[16]);
			MUI.exitGame();


		}
	}

	public void checkPlayerLost(int i){

		if(players.get(i).getFortune() <= 0){
			Rule.calcTotalAssets(players.get(i));

			if (players.get(i).isBankRupt()){
				players.get(i).changePosition(-1);
				MUI.showMessage(players.get(i).getplayerName() +textList[17]);
				MUI.removeCar(players.get(i).getplayerName());
				bankruptPlayers++;

			}
		}
	}
}
