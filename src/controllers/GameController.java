package controllers;

import java.util.ArrayList;

import boundary.GUImethods;
import desktop_codebehind.Car;
import desktop_codebehind.Car.Builder;
import desktop_resources.GUI;
import entities.Board;
import entities.Cup;
import entities.Player;

public class GameController {

	private ArrayList<Player> players;
	private ArrayList<Car> cars;
	private Cup cup;

	public GameController() {
		this.players = new ArrayList<Player>();
		this.cars = new ArrayList<Car>();
		this.cup = new Cup();

	}

	public void startGame() {
		createPlayers();
playerTurn();
	}

	public void playerTurn() {
		for(int i = 0; i<players.size();i++){
			MUI.showMessage(players.get(i).getplayerName()+" din tur! Tryk OK for at kaste med terningerne)");
			useCup();
			
		}
		
		

	}

	public void useCup() {
		cup.useCup();
		GUI.setDice(cup.getFaceValue1(), cup.getFaceValue2());
	}

	public void createPlayers() {

		int numOfPlayers = Integer
				.parseInt(MUI.setSixButtons("Velkommen til Matador, vælg antal spillere:", "2", "3", "4", "5", "6"));

		for (int i = 0; i < numOfPlayers; i++) {
			setPlayers(i);
			setCars(i);
		}

	}

	public void setPlayers(int i) {
		players.add(new Player(i, MUI.nameValidation("INDTAST NAVN PÅ SPILLER " + (i + 1)
				+ " \n(Skal indeholde bogstaver, og være mellem 2-10 karaktere lang)")));
		MUI.showMessage(players.get(0).getplayerName() + "! Din formue består af kr. " + players.get(i).getFortune());
	}

	public void setCars(int i) {
		cars.add(new Car.Builder().typeCar().primaryColor(MUI.carColor(i + 1)).build());
		GUI.addPlayer(players.get(i).getplayerName(), players.get(0).getFortune(), cars.get(0));

	}

	public static void main(String[] args) {
		GUImethods g = new GUImethods();
		Board b = new Board();
		GameController gc = new GameController();

		g.createGUIFields(b.getFieldsArray());

		gc.startGame();
	}
}
