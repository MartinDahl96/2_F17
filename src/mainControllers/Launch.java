package mainControllers;

import java.sql.SQLException;

import entities.Board;
import sql.JDBC;

public class Launch {
	
	public static void main(String[] args) throws SQLException {

		GUIcontroller g = new GUIcontroller();
		Board board = new Board();
		GameController gc = new GameController();

		g.createGUIFields(Board.getFields());
		gc.startGame();
//		JDBC JDBC = new JDBC();
//		
//		System.out.println(JDBC.playerCount());
		
	}

}