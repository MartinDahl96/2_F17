package mainControllers;

import java.awt.Color;


import java.util.ArrayList;

import desktop_codebehind.Car;
import desktop_resources.GUI;
import entities.Player;

/**
 * This class stores GUI-methods, that will be used frequently in other classes
 */

public class MUI {

	/**
	 * used to display a choice and two buttons to the player.
	 * @param msg is the message to be displayed.
	 * @param trueButton mostly used to show a "yes" button.
	 * @param falseButton mostly used to show a "no" button.
	 * @return is the message and the two buttons.
	 */
	public static boolean getTwoButtons(String msg, String trueButton, String falseButton) {

		return GUI.getUserLeftButtonPressed(msg, trueButton, falseButton);

	}

	/**
	 * used to display a player's fortune on the GUI.
	 * @param name is the name of the player
	 * @param fortune is the amount of money held by the player.
	 */
	public static void setFortune(String name, int fortune) {
		GUI.setBalance(name, fortune);
	}

	/**
	 * used to display a card on the GUI.
	 * @param cardInfo is the text on the card.
	 */
	public static void displayCard(String cardInfo) {
		GUI.displayChanceCard(cardInfo);
	}

	/**
	 * used to display a message on the GUI.
	 * @param msg is the message displayed.
	 */
	public static void showMessage(String msg) {
		GUI.showMessage(msg);
	}

	/**
	 * used to set an owner on a field on the GUI.
	 * @param position is the position of the field.
	 * @param playerName is the name of the owner of the field.
	 */
	public static void setOwner(int position, String playerName) {
		GUI.setOwner(position, playerName);

	}

	/**
	 * used to display a message and 5 choices on the GUI.
	 * @param msg is the message displayed.
	 * @param B1 is the first button.
	 * @param B2 is the second button.
	 * @param B3 is the third button.
	 * @param B4 is the fourth button.
	 * @param B5 is the fifth button.
	 * @return is the message and the five buttons.
	 */
	public static String setFiveButtons(String msg, String B1, String B2, String B3, String B4, String B5) {
		return GUI.getUserButtonPressed(msg, B1, B2, B3, B4, B5);

	}

	/**
	 * used to get a String from the player.
	 * @param msg is the String gotten from the player.
	 * @return is the String from the player.
	 */
	public static String getUserString(String msg) {
		return GUI.getUserString(msg);
	}

	/**
	 * used to create cars on the GUI.
	 * @param cars is the cars being build.
	 */
	public static void createCars(ArrayList<Car> cars) {
		
		cars.add(new Car.Builder()
				.primaryColor(Color.RED)
				.secondaryColor(Color.WHITE)
				.typeRacecar()
				.patternFill()
				.build());
		
		cars.add(new Car.Builder()
				.primaryColor(Color.GREEN)
				.secondaryColor(Color.WHITE)
				.typeRacecar()
				.patternFill()
				.build());
		
		cars.add(new Car.Builder()
				.primaryColor(Color.BLUE)
				.secondaryColor(Color.WHITE)
				.typeRacecar()
				.patternFill()
				.build());
		
		cars.add(new Car.Builder()
				.primaryColor(Color.BLACK)
				.secondaryColor(Color.WHITE)
				.typeRacecar()
				.patternFill()
				.build());
		
		cars.add(new Car.Builder()
				.primaryColor(Color.PINK)
				.secondaryColor(Color.WHITE)
				.typeRacecar()
				.patternFill()
				.build());
		
		cars.add(new Car.Builder()
				.primaryColor(Color.WHITE)
				.secondaryColor(Color.WHITE)
				.typeRacecar()
				.patternFill()
				.build());
	}

	/**
	 * used to set a car on the start field.
	 * @param player is the player whose car is being set.
	 */
	public static void setCarOnStart(Player player) {
		player.setCurrentPosition(1);
		GUI.setCar(player.getCurrentPosition(), player.getplayerName());
		
	}

	/**
	 * used to remove a car from the GUI.
	 * @param name is the name of the player whose car is being removed.
	 */
	public static void removeCar(String name) {
		GUI.removeAllCars(name);
	}

	/**
	 * used to move a car from the GUI.
	 * @param position is the position the car is being moved to.
	 * @param name is the name of the player whose car is being moved.
	 */
	public static void moveCar(int position, String name) {
		removeCar(name);
		GUI.setCar(position, name);
	}
	
	/**
	 * used to set a hotel on a field on the GUI.
	 * @param fieldNumber is the number of the field where the hotel should be placed.
	 * @param hasHotel sets the boolean value that the field has a hotel.
	 */
	public static void setHotel(int fieldNumber, boolean hasHotel){
		GUI.setHotel(fieldNumber, hasHotel);
	}
	
	/**
	 * used to set houses on a field on the GUI.
	 * @param fieldNumber is the number of the field where the house should be placed.
	 * @param houseCount is the amount of houses to be placed on the field.
	 */
	public static void SetHouses(int fieldNumber, int houseCount){
		GUI.setHouses(fieldNumber, houseCount);
	}
	
	/**
	 * used to update a player on the GUI.
	 * @param name is the name of the player to be updated.
	 * @param fortune is the fortune of said player.
	 * @param position is the position of said player.
	 */
	public static void updateGUIPlayer(String name,int fortune, int position){
		setFortune(name, fortune);
		moveCar(position, name);
	}
	
	/**
	 * used to exit the game.
	 */
	public static void exitGame(){
		MUI.showMessage("Tryk OK for at afslutte");
		System.exit(0);
	}

	/**
	 * used to validate the player's name.
	 * @param msg is the name of the player to be validated.
	 * @return s is the name of the player.
	 */
	public static String nameValidation(String msg) {
		String s;

		do {
			s = GUI.getUserString(msg);

		} while (!s.matches("([a-zA-Z0-9]){2,10}") || s.matches("[0-9]+"));
		
		return s;
	}
	
	/**
	 * removes owner from GUI
	 * @param fieldID refers to the field that gets removed
	 */
	public static void removeOwner(int fieldID){
		GUI.removeOwner(fieldID);
	}
	
	
	

}
