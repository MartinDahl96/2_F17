package mainControllers;

import entities.Board;

public class Launch {
	
	public static void main(String[] args) {

		GUIcontroller g = new GUIcontroller();
		Board board = new Board();
		GameController gc = new GameController();

		g.createGUIFields(Board.getFields());
		gc.startGame();
	}

}
