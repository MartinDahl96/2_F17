package mainControllers;

import java.sql.SQLException;


import entities.Board;

public class Launch {
	
	public static void main(String[] args) throws SQLException {

		GUIcontroller g = new GUIcontroller();
		GameController gc = new GameController();

		//creates the board with fields and starts the gameloop.
		g.createGUIFields(Board.getFields());
		gc.startGame();

	}

}
