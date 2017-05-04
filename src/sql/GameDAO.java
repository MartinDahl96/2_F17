package sql;

import java.sql.SQLException;

public class GameDAO  {
	
	private PlayerDAOimp pDAO = new PlayerDAOimp();
	private FieldDAOimp fDAO = new FieldDAOimp();
	private ChanceDAOimp cDAO = new ChanceDAOimp();
	
	
	public void loadGame(int playerID) throws SQLException {
		pDAO.getPlayer(playerID);
		fDAO.getOwnable(playerID);
	}
	
	public void saveGame(int playerID) throws SQLException {
		pDAO.insertPlayer(playerID);
		fDAO.updateOwnable(playerID);
		}
	
	public void setupGame(int playerID){
		
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void createDBPlayers()  {
	
		try {
			pDAO.insertPlayer();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void updateDBplayers(int playerID) {
		try {
			pDAO.updatePlayer(playerID);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	public void createDBownable() {
		try {
			fDAO.insertOwnable();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public void updateDBownable() {
		try {
			fDAO.updateOwnable();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateDBowner() {
		try {
			fDAO.updateOwner();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void createDBcardDeck(){
		try {
			cDAO.insertChanceCards();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
