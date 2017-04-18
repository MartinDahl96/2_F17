package controllers;

import java.util.ArrayList;

import desktop_codebehind.Car;
import desktop_codebehind.Car.Builder;
import desktop_resources.GUI;
import entities.Board;
import entities.Chance;
import entities.Cup;
import entities.Player;

public class GameController {

	private ArrayList<Player> players;
	private ArrayList<Car> cars;
	private Cup cup;
	private Board board;

	public GameController() {
		this.players = new ArrayList<Player>();
		this.cars = new ArrayList<Car>();
		this.cup = new Cup();
		this.board = new Board();

	}

	public void startGame() {
		createPlayers();
		playerTurn();

	}
	public void playerTurn() {
		
		
		for (int i = 0; i < players.size(); i++) {
			playerOptions(i);
		}

	}

	public void playerOptions(int i) {

		String options = GUI.getUserSelection("Vælg dit næste træk:", "1. Kast med terningerne", "2. Sælg hus/hotel",
				"3. Pantsæt", "4. Køb pantsat tilbage", "5. Afslut spil");
		int choice = Integer.parseInt(options.substring(0, 1));

		switch (choice) {
		case 1:
			throwDice(i);

			break;
		case 2:

			break;
		case 3:

			break;
		case 4:

			break;
		case 5:

			break;
		}
	}

	public void throwDice(int i) {
		cup.useCup();
		GUI.setDice(cup.getFaceValue1(), cup.getFaceValue2());

		players.get(i).setCurrentPosition(cup.getCupValue());
		MUI.moveCar(players.get(i).getCurrentPosition(), players.get(i).getplayerName());
		
		board.landOnField(players.get(i), players.get(i).getCurrentPosition());
		

	}

	public void createPlayers() {

		int numOfPlayers = Integer.parseInt
			(MUI.setSixButtons("Velkommen til Matador, vælg antal spillere:", "2", "3", "4", "5", "6"));
	
		for (int i = 0; i < numOfPlayers; i++) {
			setPlayers(i);
			setCars(i);
			
		}

	}

	public void setPlayers(int i) {
		players.add(new Player(i, MUI.nameValidation("INDTAST NAVN PÅ SPILLER " + (i + 1)	+ " \n(Skal indeholde bogstaver, og være mellem 2-10 karaktere lang)")));
		MUI.showMessage(players.get(i).getplayerName() + "! Din formue består af kr. " + players.get(i).getFortune());
	}

	public void setCars(int i) {
		cars.add(new Car.Builder().typeCar().primaryColor(MUI.carColor(i+1)).build());
		GUI.addPlayer(players.get(i).getplayerName(), players.get(i).getFortune(), cars.get(i));
		MUI.setCarOnStart(players.get(i),players.get(i).getplayerName());
	}

	public static void main(String[] args) {
		GUIcontroller g = new GUIcontroller();
		Board b = new Board();
		GameController gc = new GameController();

		g.createGUIFields(b.getFieldsArray());

		
		gc.startGame();
	}
}
