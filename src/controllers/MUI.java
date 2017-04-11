package controllers;

import java.awt.Color;

import desktop_resources.GUI;
import entities.Player;

/**
 * 
 * This class stores (gui)methods, that will be used frequently in other classes
 *
 */

public class MUI {

	public static boolean getTwoButtons(String msg, String trueButton, String falseButton) {

		return GUI.getUserLeftButtonPressed(msg, trueButton, falseButton);

	}

	public static void showMessage(String msg) {
		GUI.showMessage(msg);
	}

	public static void setOwner(int position, String playerName) {
		GUI.setOwner(position, playerName);
	}

	public static String setSixButtons(String msg, String B1, String B2, String B3, String B4, String B5) {
		return GUI.getUserButtonPressed(msg, B1, B2, B3, B4, B5);

	}

	public static String getUserString(String msg) {
		return GUI.getUserString(msg);
	}

	public static Color carColor(int i) {
		switch (i) {
		case 1:
			return Color.RED;
		case 2:
			return Color.GREEN;
		case 3:
			return Color.BLUE;
		case 4:
			return Color.BLACK;
		case 5:
			return Color.PINK;
		default:
			return Color.WHITE;
		}
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
