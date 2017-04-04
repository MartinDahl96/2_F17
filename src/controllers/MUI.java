package controllers;

import desktop_resources.GUI;

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

	public static void setOwner(int position, String playerName){
		GUI.setOwner(position, playerName);
	}
}
