package mainControllers;

import java.awt.Color;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.lang.*;
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
import inputHandlers.Text;
import sql.Connector;
import sql.DAOimp;
import sql.DTO;
import sql.DTOimp;

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
	private Connector Connector = new Connector();
	private DAOimp DAOimp = new DAOimp();
	private DTOimp DTOimp = new DTOimp();
	private Text file = new Text("txtfiles/mainControllerText.txt");
	private String[] textList;
	public void startGame() {
		Boolean choice = MUI.getTwoButtons("Nyt spil bro?", "Ja", "Nej");
		if (choice == true){
		
		
			createPlayers();
			playerTurn();
		
		if(choice == false){
		}}
		
		

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
		try {
			textList = file.OpenFile();
		} catch (IOException e) {
			e.printStackTrace();
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
			try{
				DTOimp.saveGame(i);
			} catch (SQLException e){
				e.printStackTrace();
			}
			System.exit(0);
			break;
		}

	}
	
	public void throwDice(int i) {
		
		if(players.get(i).getFortune() > 0){
			
		
		cup.useCup();
		GUI.setDice(cup.getFaceValue1(), cup.getFaceValue2());
		players.get(i).setCurrentPosition(1);
		playOnBoard(i);
		}
		else{
			MUI.showMessage("Sælg noget lort");
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
		try {
			textList = file.OpenFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		int numOfPlayers = Integer.parseInt(MUI.setFiveButtons(textList[7], textList[8], textList[9], textList[10], textList[11], textList[12]));

		for (int i = 0; i < numOfPlayers; i++) {
			setPlayers(i);
			setCars(i);
			
			try {
				DTOimp.updatePlayer(i);
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	
	public void setPlayers(int i) {
		try {
			textList = file.OpenFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		players.add(new Player(i, MUI.nameValidation(textList[13] + (i + 1) + textList[14])));
		MUI.showMessage(players.get(i).getplayerName() + textList[15] + players.get(i).getFortune());
	}

	
	public void setCars(int i) {
		cars.add(new Car.Builder().typeCar().primaryColor(MUI.carColor(i + 1)).secondaryColor(Color.white).build());
		GUI.addPlayer(players.get(i).getplayerName(), players.get(i).getFortune(), cars.get(i));
		MUI.setCarOnStart(players.get(i), players.get(i).getplayerName());
	}

	
	public static ArrayList<Player> getPlayers() {
		return players;
	}
	
	public static Player getPlayer(int playerID){
		return players.get(playerID);
	}
	
	public void checkForWinner(int i) {
		try {
			textList = file.OpenFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
			if(bankruptPlayers == players.size()-1){
				noWinner = true;
				MUI.showMessage(players.get(i).getplayerName()+textList[16]);
				MUI.exitGame();
			
				
				}
			}
	
	public void checkPlayerLost(int i){
		try {
			textList = file.OpenFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(players.get(i).isBankRupt()){
			MUI.showMessage(players.get(i).getplayerName() +textList[17]);
			MUI.removeCar(players.get(i).getplayerName());
			bankruptPlayers++;
				
		}
	}
}
