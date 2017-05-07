package sql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import entities.ChanceCard;
import entities.ChanceDeck;


public class ChanceDAOimp implements IChanceDAO {

	//attributes
	private Connector c = new Connector();
	private PreparedStatement prepstmt;
	private ResultSet rs;

	
	/**
	 * used to insert a chancecard to the database.
	 * @throws SQLException if no connection can be made.
	 */
	@Override
	public void insertCards() throws SQLException {

		String addCardDeckProcedure = "call addCardDeck(?,?,?,?);";
		prepstmt = c.getConnection().prepareStatement(addCardDeckProcedure);

		for (int i = 0; i < ChanceDeck.getDeck().size(); i++) {
			prepstmt.setInt(1, ChanceDeck.getDeck().get(i).getCardID());
			prepstmt.setInt(2, ChanceDeck.getDeck().get(i).getCardValue());
			prepstmt.setString(3, ChanceDeck.getDeck().get(i).getCardText());
			prepstmt.setInt(4, i);
			prepstmt.executeUpdate();
		}
		System.out.println("cardDeck is up to date...");
	}

	/**
	 * used to update/change a chancecard in the database
	 * @param card is the card to be changed.
	 */
	@Override
	public void updateCards(ChanceCard card){ 
		String updateCardDeckProcedure = "call updateCardDeck(?,?);";
		try {
			prepstmt = c.getConnection().prepareStatement(updateCardDeckProcedure);
			prepstmt.setInt(1, card.getCardID());
			prepstmt.setBoolean(2, true);
			prepstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("ChanceCard picked...");

	}

	/**
	 * used to get a chancecard from the Database.
	 * @throws SQLException if no connection can be made.
	 */
	@Override
	public void getChanceCards() throws SQLException {
		ChanceDeck.getDeck().removeAllElements();
		String notPickedCards = "SELECT * FROM notpickedcards;";
		rs = c.doQuery(notPickedCards);

		while (rs.next()) {
			ChanceDeck.getDeck().push(new ChanceCard(rs.getInt("cardID"), rs.getInt("cardValue"), rs.getString("cardText")));
		}
	}
}