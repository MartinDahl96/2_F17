<<<<<<< HEAD
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
	
	public void createDBPlayers(int playerID)  {
	
		try {
			pDAO.insertPlayer(playerID);
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

	
	public void createDBownable()  {
		
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
}
=======
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
	
	public void createDBPlayers(int playerID)  {
	
		try {
			pDAO.insertPlayer(playerID);
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

	
	public void createDBownable()  {
		
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
}
>>>>>>> refs/remotes/origin/master
