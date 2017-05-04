package sql;

import java.sql.SQLException;

public interface IChanceDAO {
	
	void getChanceCards(int cardID) throws SQLException;
	
	void insertUpdateCards() throws SQLException;

	void resetCardDeck() throws SQLException;

}
