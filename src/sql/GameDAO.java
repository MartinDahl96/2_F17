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

}
