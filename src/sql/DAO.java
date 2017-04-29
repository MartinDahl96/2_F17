 package sql;

import java.sql.SQLException;
import entities.Player;

public interface DAO {

	Player getPlayer (int playerID) throws SQLException;
	
	void getOwnable(int playerID) throws SQLException;
	
	void getChanceDeck(int cardID) throws SQLException;	
}
