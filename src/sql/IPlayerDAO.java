package sql;

import java.sql.SQLException;

public interface IPlayerDAO {

	/**
	 * used to get a player's information from the database.
	 * @throws SQLException if no connection can be made.
	 */
	void getPlayers() throws SQLException;

	/**
	 * used to insert a player's information into the database.
	 * @throws SQLException if no connection can be made.
	 */
	void insertPlayer() throws SQLException;
	
	/**
	 * used to update a player's information in the database.
	 * @throws SQLException if no connection can be made.
	 */
	void updatePlayer() throws SQLException; 

}
