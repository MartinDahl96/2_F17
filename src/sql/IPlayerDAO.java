package sql;

import java.sql.SQLException;
import entities.Player;

public interface IPlayerDAO {

	Player getPlayer (int playerID) throws SQLException;
	
	void getOwnable(int playerID) throws SQLException;
	
	void getChanceCard(int cardID) throws SQLException;	
}
 