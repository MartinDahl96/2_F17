package sql;

import java.sql.SQLException;
import entities.Player;

public interface IPlayerDAO {

	Player getPlayer(int playerID) throws SQLException;

	void removePlayer(int playerID) throws SQLException;

	void insertPlayer(int playerID) throws SQLException;
	
	void updatePlayer(int playerID) throws SQLException; 

}
