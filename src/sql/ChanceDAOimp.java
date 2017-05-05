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
	 * @throws SQLException
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
		System.out.println("cardDeck is up to date");
	}

	/**
	 * used to update/change a chancecard in the database
	 * @param card is the card to be changed.
	 * @throws SQLException
	 */
	@Override
	public void updateCards(ChanceCard card) { 
		String updateCardDeckProcedure = "call updateCardDeck(?,?);";
		try {
			prepstmt = c.getConnection().prepareStatement(updateCardDeckProcedure);
			prepstmt.setInt(1, card.getCardID());
			prepstmt.setBoolean(2, true);
			prepstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("CARDDECK UPDATED");

	}

	/**
	 * used to get a chancecard from the Database.
	 * @throws SQLException
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

	// public static void main(String[] args){
	//
	// ChanceDeck cc = new ChanceDeck();
	// System.out.println("FØR: "+cc.getDeck());
	// ChanceDAOimp dao = new ChanceDAOimp();
	//
	// try {
	// dao.insertCards();
	// } catch (SQLException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// try {
	// dao.updateCards(cc.getDeck().peek());
	// cc.getDeck().pop();
	// } catch (SQLException e1) {
	// // TODO Auto-generated catch block
	// e1.printStackTrace();
	// }
	//
	// try {
	// dao.updateCards(cc.getDeck().peek());
	// cc.getDeck().pop();
	// } catch (SQLException e1) {
	// // TODO Auto-generated catch block
	// e1.printStackTrace();
	// }try {
	// dao.updateCards(cc.getDeck().peek());
	// cc.getDeck().pop();
	// } catch (SQLException e1) {
	// // TODO Auto-generated catch block
	// e1.printStackTrace();
	// }try {
	// dao.updateCards(cc.getDeck().peek());
	// cc.getDeck().pop();
	// } catch (SQLException e1) {
	// // TODO Auto-generated catch block
	// e1.printStackTrace();
	// }
	//
	// System.out.println("EFTER: "+cc.getDeck());
	// System.out.println("SIZE: "+cc.getDeck().size());
	//
	// cc.getDeck().removeAllElements();
	// System.out.println("SLETTET: "+cc.getDeck());
	//
	// try {
	// dao.getChanceCards();
	// } catch (SQLException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	//
	// System.out.println("SKAL VÆRE SAMME SOM 'EFTER': "+cc.getDeck());
	// System.out.println("SIZE: "+cc.getDeck().size());
	//
	//
	// }
}