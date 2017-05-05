package sql;

import java.sql.SQLException;

import entities.ChanceCard;

public interface IChanceDAO {
	
	/**
	 * used to get a chancecard from the Database.
	 * @throws SQLException
	 */
	void getChanceCards() throws SQLException;
	
	/**
	 * used to insert a chancecard to the database.
	 * @throws SQLException
	 */
	void insertCards() throws SQLException;

	/**
	 * used to update/change a chancecard in the database
	 * @param card is the card to be changed.
	 * @throws SQLException
	 */
	void updateCards(ChanceCard card) throws SQLException;

	
}
