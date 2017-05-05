package sql;

import java.sql.SQLException;

import entities.ChanceCard;

public interface IChanceDAO {
	
	void getChanceCards() throws SQLException;
	
	void insertCards() throws SQLException;

	void updateCards(ChanceCard card) throws SQLException;

	
}
