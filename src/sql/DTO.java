package sql;

import java.sql.SQLException;

public interface DTO {

	void removePlayer(int playerID) throws SQLException;
	
	void updatePlayer(int playerID) throws SQLException;
	
	void updateField(int playerID) throws SQLException;
	
	void updateChanceDeck(int cardID) throws SQLException;
	
}
