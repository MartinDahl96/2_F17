package sql;

import java.sql.SQLException;

public interface IChanceDAO {
	
	void getChanceCards(int cardID) throws SQLException;
	
	void insertChanceCards() throws SQLException;

	void resetCardDeck() throws SQLException;

}
