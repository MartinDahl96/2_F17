package sql;

import java.sql.SQLException;
import entities.Player;

public interface IPlayerDAO {

	Player getPlayer(int playerID) throws SQLException;

	void removePlayer(int playerID) throws SQLException;

	void insertPlayer() throws SQLException;
	
	void updatePlayer() throws SQLException; 

}
