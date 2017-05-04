package sql;

import java.sql.SQLException;

public interface IChanceDAO {
	
	void getChanceCards(int cardID) throws SQLException;
	
	void updateChanceCards(int cardID, String cardText, int cardValue) throws SQLException;
	
	void insertChanceCards() throws SQLException;

	void resetTable(String tableName) throws SQLException;

}
