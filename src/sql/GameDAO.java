package sql;

import java.sql.SQLException;

import entities.ChanceDeck;

public class GameDAO {

	private PlayerDAOimp pDAO = new PlayerDAOimp();
	private FieldDAOimp fDAO = new FieldDAOimp();
	private ChanceDAOimp cDAO = new ChanceDAOimp();

	public void loadGame(int playerID) throws SQLException {
		try ())
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	}

	public void saveGame() {

		try {
			pDAO.insertPlayer();
			fDAO.insertOwnable();
			cDAO.insertUpdateCards();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

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
