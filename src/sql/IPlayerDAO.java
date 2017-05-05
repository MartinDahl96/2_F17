package sql;

import java.sql.SQLException;

public interface IPlayerDAO {

	void getPlayers() throws SQLException;

	void insertPlayer() throws SQLException;
	
	void updatePlayer() throws SQLException; 

}
