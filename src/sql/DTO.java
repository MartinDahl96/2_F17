package sql;

import java.sql.SQLException;

public interface DTO {

	void removePlayer(int playerID) throws SQLException;
	
	void updatePlayer(int playerID) throws SQLException;
	
	void updateOwnable(int playerID) throws SQLException;
	
	void updateChanceCard(int cardID, String cardText, int cardValue) throws SQLException;
	
	
}
