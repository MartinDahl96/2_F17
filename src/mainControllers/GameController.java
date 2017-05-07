package mainControllers;

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

	//attributes
	private static ArrayList<Player> players = new ArrayList<Player>();
	private ArrayList<Car> cars = new ArrayList<Car>();
	private Cup cup = new Cup();
	private Board board = new Board();
	private boolean winner = false;
	private int bankruptPlayers = 0;
	private JailController jailControle = new JailController();
	private StreetController streetControle = new StreetController();	
	private PropertyController propertyControle = new PropertyController();
	private GameDAO gDAO = new GameDAO();
	private Text file = new Text("txtfiles/mainControllerText.txt");
	private String[] textList;

	/**
	 * constructor for the Gamecontroller.
	*/
	public GameController(){
		try {
			textList = file.OpenFile();
		} catch (IOException e) {
			e.printStackTrace();
		} 	
	}


	/**
	 * used to  make the player decide whether to start a new game or to load a saved one.
	 */
	public void startGame() {
		Boolean choice = MUI.getTwoButtons("Vælg: ", "Nyt spil", "Indlæs tidligere spil");
		if (choice){
			gDAO.newGame();
			createPlayers();
			gDAO.saveGame();
			playerTurn();

		}
		else if (!choice) {
			gDAO.loadGame();
			loadPlayers();
			playerTurn();
		}
	}


	/**
	 * used as the loop the player's are in until they have lost the game.
	 */
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

	/**
	 * used to define the options available to the player.
	 * @param i is the player.
	 */
	public void playerOptions(int i) {
		gDAO.updateSave();
		
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

	/**
	 * is the option for the player to throw the dice.
	 * @param i is the player.
	 */
	public void throwDice(int i) {
	Rule.calcTotalAssets(players.get(i));
	if(players.get(i).getTotalAssets() > 0 && players.get(i).getFortune() > 0){
			cup.useCup();
			GUI.setDice(cup.getFaceValue1(), cup.getFaceValue2());
			players.get(i).setCurrentPosition(cup.getCupValue());
			playOnBoard(i);
		}
	else { MUI.showMessage("De har ingen penge, sælg noget for at spille videre!");
		   playerOptions(i);
		 }
	}
	/**
	 * is the player's movement on the board, affected by the player's turn.
	 * @param i is the player.
	 */
	public void playOnBoard(int i) {

		MUI.updateGUIPlayer(players.get(i).getplayerName(), players.get(i).getFortune(), players.get(i).getCurrentPosition());

		board.landOnField(players.get(i));
		StartController.grantStartBonus(players.get(i)); 		// grants the player startBonus if he landed on/passed the start field
		ParkingController.deactivateImmunity(players.get(i));	// deactivates immunnity if the current field is not a parking field

		MUI.updateGUIPlayer(players.get(i).getplayerName(), players.get(i).getFortune(), players.get(i).getCurrentPosition());

	}


	/**
	 * used to create the amount of players stated by the choice of the player starting the game.
	 */
	public void createPlayers() {
		int numOfPlayers = Integer.parseInt(MUI.setFiveButtons(textList[7], textList[8], textList[9], textList[10], textList[11], textList[12]));

		for (int i = 0; i < numOfPlayers; i++) {
			setPlayers(i);
			setCars(i);
			
			

			
		}

	}


	/**
	 * used the set a player on the GUI.
	 * @param i is the player's number.
	 */
	public void setPlayers(int i) {

		players.add(new Player(i, MUI.nameValidation(textList[13] + (i + 1) + textList[14])));
		MUI.showMessage(players.get(i).getplayerName() + textList[15] + players.get(i).getFortune());
		players.get(i).setPlayerID(i+1);
	}


	/**
	 * used to set a car on the GUI.
	 * @param i is the car to be set for the player's number.
	 */
	public void setCars(int i) {
		MUI.createCars(cars);
		GUI.addPlayer(players.get(i).getplayerName(), players.get(i).getFortune(), cars.get(i));
		MUI.setCarOnStart(players.get(i));
	}


	/**
	 * used to get the ArrayList of players.
	 * @return is the ArrayList of players.
	 */
	public static ArrayList<Player> getPlayers() {
		return players;
	}

	/**
	 * used to get a single player out of the ArrayList of players.
	 * @param playerID is the ID of the player in the ArrayList.
	 * @return is the selected player.
	 */
	public static Player getPlayer(int playerID) {
		Player p = null;
		for (Player player : players) {
			if (player.getPlayerID() == playerID) {
				p = player;
			}
		}
		return p;
	}
		
	

	/**
	 * used to check if a winner is found.
	 * @param i is the player to check the win/loss status on.
	 */
	public void checkForWinner(int i) {

		if(bankruptPlayers == players.size()-1){
			winner = true;
			MUI.showMessage(players.get(i).getplayerName()+textList[16]);
			MUI.exitGame();


		}
	}

	/**
	 * used to check if a player has lost.
	 * @param i is the player to be checked.
	 */
	public void checkPlayerLost(int i){

		if(players.get(i).getFortune() <= 0){
			Rule.calcTotalAssets(players.get(i));

			if (players.get(i).isBankRupt()){
				players.get(i).changePosition(-1);
				MUI.showMessage(players.get(i).getplayerName() +textList[17]);
				MUI.removeCar(players.get(i).getplayerName());
				Rule.removeOwner(players.get(i));
				bankruptPlayers++;

			}
		}
	}
	
	/**
	 * used to put the loaded players form the database to the GUI.
	 */
	public void loadPlayers(){
		for(int i = 0; i<players.size();i++){
			MUI.createCars(cars);
			GUI.addPlayer(players.get(i).getplayerName(), players.get(i).getFortune(), cars.get(i));
			MUI.updateGUIPlayer(players.get(i).getplayerName(), players.get(i).getFortune(), players.get(i).getCurrentPosition());
			Rule.assignOwner(players.get(i));
			Rule.placeHouses(players.get(i));
			
		}
	}
}
