package mainControllers;

import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;

import desktop_codebehind.Car;
import desktop_resources.GUI;
import entities.Player;
import inputHandlers.Text;

//Methods

/**
 * 
 * This class stores (gui)methods, that will be used frequently in other classes
 *
 */

public class MUI {
	private Text file = new Text("txtfiles/mainControllerText.txt");
	private String[] textList;
	
	public static boolean getTwoButtons(String msg, String trueButton, String falseButton) {

		return GUI.getUserLeftButtonPressed(msg, trueButton, falseButton);

	}

	public static void setFortune(String name, int fortune) {
		GUI.setBalance(name, fortune);
	}

	public static void displayCard(String cardInfo) {
		GUI.displayChanceCard(cardInfo);
	}

	public static void showMessage(String msg) {
		GUI.showMessage(msg);
	}

	public static void setOwner(int position, String playerName) {
		GUI.setOwner(position, playerName);

	}

	public static String setFiveButtons(String msg, String B1, String B2, String B3, String B4, String B5) {
		return GUI.getUserButtonPressed(msg, B1, B2, B3, B4, B5);

	}

	public static String getUserString(String msg) {
		return GUI.getUserString(msg);
	}

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

	public static void setCarOnStart(Player player) {
		player.setCurrentPosition(1);
		GUI.setCar(player.getCurrentPosition(), player.getplayerName());
		
	}

	public static void removeCar(String name) {
		GUI.removeAllCars(name);
	}

	public static void moveCar(int position, String name) {
		removeCar(name);
		GUI.setCar(position, name);
	}
	public static void setHotel(int fieldNumber, boolean hasHotel){
		GUI.setHotel(fieldNumber, hasHotel);
	}
	public static void SetHouses(int fieldNumber, int houseCount){
		GUI.setHouses(fieldNumber, houseCount);
	}
	
	public static void updateGUIPlayer(String name,int fortune, int position){
		setFortune(name, fortune);
		moveCar(position, name);
	}
	
	public static void exitGame(){
		MUI.showMessage("Tryk OK for at afslutte");
		System.exit(0);
	}

	public static String nameValidation(String msg) {
		String s;

		do {
			s = GUI.getUserString(msg);

		} while (!s.matches("([a-zA-Z0-9]){2,10}") || s.matches("[0-9]+"));

		// The first RegEx above matches any String containing Latin
		// uppercase/lowercase letters, and that it is between 2-10 characters.
		// The second RegEx ensures that the String doesn't consist of only
		// numbers

		// ("(.){2,10}")

		return s;
	}
	
	

}
