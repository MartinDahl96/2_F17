package sql;

import java.sql.SQLException;

import entities.ChanceDeck;

public class GameDAO {

	//attributes
	private PlayerDAOimp pDAO = new PlayerDAOimp();
	private FieldDAOimp fDAO = new FieldDAOimp();
	private ChanceDAOimp cDAO = new ChanceDAOimp();

	/**
	 * used to load the game.
	 * @param playerID is the ID of the player to load.
	 * @throws SQLException
	 */
	public void loadGame(int playerID) throws SQLException {
		try ())
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	}

	/**
	 * used to save the current game.
	 * @throws Exception
	 */
	public void saveGame() {

		try {
			pDAO.insertPlayer();
			fDAO.insertOwnable();
			cDAO.insertUpdateCards();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * used to update the current saved game to a new state of the game.
	 * @throws Exception
	 */
	public void updateSave() {
		try {
			pDAO.updatePlayer();
			fDAO.updateOwnable();
			cDAO.insertUpdateCards();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
