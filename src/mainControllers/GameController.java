package mainControllers;

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
	private ArrayList<Car> cars =  new ArrayList<Car>();
	private Cup cup = new Cup();
	private Board board = new Board();
	private boolean noWinner = false;
	
    /*------------------------- Subcontrollers -------------------------*/
	private ChanceController chanceControle = new ChanceController();
	private OwnableController ownControle = new OwnableController();
	private ParkingController parkControle = new ParkingController();
	private TaxController taxControle = new TaxController();
	private JailController jailControle = new JailController();
	private StartController startControle = new StartController();
	private PropertyController propertyControle = new PropertyController();
	/*------------------------- Subcontrollers -------------------------*/


	public void startGame() {
		createPlayers();
		playerTurn();

	}

	public void playerTurn() {

		while (noWinner == false) {
			
			for (int i = 0; i < players.size(); i++) {
				playerOptions(i);	
			}

		}

	}

	public void playerOptions(int i) {

		String options = GUI.getUserSelection(players.get(i).getplayerName()+" vælg dit næste træk:", "1. Kast med terningerne", "2. Sælg hus/hotel",
				"3. Sælg grund","4. Pantsæt", "5. Køb pantsat tilbage", "6. Afslut spil");
		int choice = Integer.parseInt(options.substring(0, 1));

		switch (choice) {
		case 1:
			throwDice(i);
			break;
		case 2:
			
			break;
		case 3:
			propertyControle.sellProperty(players.get(i));
			break;
		case 4:
			propertyControle.pawnProperty(players.get(i));
			break;
		case 5:
			propertyControle.unPawnProperty(players.get(i));
			break;
		case 6:
			System.exit(0);
			//Save with database on this line

			break;
		}
	}

	public void throwDice(int i) {
		cup.useCup();
		GUI.setDice(cup.getFaceValue1(), cup.getFaceValue2());
		players.get(i).setCurrentPosition(8);
	
		MUI.updateGUIPlayer(players.get(i).getplayerName(), players.get(i).getFortune(), players.get(i).getCurrentPosition());
		landOnField(i);
		startControle.grantStartBonus(players.get(i)); //grants the player startBonus if he has landed on/passed the start field
		MUI.updateGUIPlayer(players.get(i).getplayerName(), players.get(i).getFortune(), players.get(i).getCurrentPosition());
	}

	public void landOnField(int i) {
		
		MUI.moveCar(players.get(i).getCurrentPosition(), players.get(i).getplayerName());
		
		/* LOGIC OF THE FOLLOWING IF-STATEMENTES: If the current field, is and instance of X, then excecute landOnx */
		
		int currentField = players.get(i).getCurrentPosition();
		
		if (Board.getFields().get(currentField) instanceof Chance) {
			chanceControle.landOnChance(players.get(i), (Chance) Board.getFields().get(currentField)); 
			/*The following if-statement ensures, that if the player's position is changed by a chanceCard, then then landOnField (new field), is executed again.*/
			if(players.get(i).getCurrentPosition() != currentField){
				landOnField(i);
			}
		}
		
		if (Board.getFields().get(currentField) instanceof Ownable) {
			ownControle.landOnOwnable(players.get(i), (Ownable) Board.getFields().get(currentField));
		
		}
		
		if((Board.getFields().get(currentField) instanceof Parking)) {
			parkControle.landOnParking(players.get(i));
		}
		
		if (Board.getFields().get(currentField) instanceof Tax) {
			taxControle.landOnTax(players.get(i) , (Tax) Board.getFields().get(currentField));

		}

		if (Board.getFields().get(currentField) instanceof Jail) {
			jailControle.landOnJail(players.get(i) , (Jail) Board.getFields().get(currentField));

		}
		
		/* The following if statement ensures that if a player no longer is on the Parking field, then he loses his immunity */
		if(!(Board.getFields().get(currentField) instanceof Parking)) {
			parkControle.deactivateImmunity(players.get(i));
			}
		
	
		
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
		cars.add(new Car.Builder().typeCar().primaryColor(MUI.carColor(i + 1)).build());
		GUI.addPlayer(players.get(i).getplayerName(), players.get(i).getFortune(), cars.get(i));
		MUI.setCarOnStart(players.get(i), players.get(i).getplayerName());
		}
	
	public static ArrayList<Player> getPlayers(){
		return players;
		}
	
	
	public static void main(String[] args) {
		GUIcontroller g = new GUIcontroller();
		Board board = new Board();
		GameController gc = new GameController();

		g.createGUIFields(Board.getFields());
		gc.startGame();
	}
}
