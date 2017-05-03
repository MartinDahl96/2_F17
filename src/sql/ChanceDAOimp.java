<<<<<<< HEAD
package sql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fieldControllers.ChanceController;

public class ChanceDAOimp implements IChanceDAO {

	private Connector c = new Connector();
	private PreparedStatement prepstmt;

	@Override
	public void getChanceCard(int cardID) throws SQLException {
		String getChanceCard = "SELECT * FROM matador.ChanceDeck WHERE cardID = ?;";
		ResultSet rs;
		ChanceController cc = new ChanceController(null);

		try {

			prepstmt = c.getConnection().prepareStatement(getChanceCard);
			rs = prepstmt.executeQuery();
			while (rs.next()) {
				prepstmt.setInt(1, cardID);
				prepstmt.setString(2, cc.deck.getDeck().get(cardID).getCardText());
				prepstmt.setInt(3, cc.deck.getDeck().get(cardID).getCardValue());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			prepstmt.close();
		}

	}

	@Override
	public void updateChanceCard(int cardID, String cardText, int cardValue) throws SQLException {
		String updateChanceCard = "INSERT INTO matador.ChanceDeck (cardID, cardText, cardValue) VALUES (?,?,?) \n"
				+ "ON DUPLICATE KEY UPDATE cardID = VALUES(cardID), cardText = VALUES(cardText), cardValue = VALUES(cardValue)";

		ChanceController cc = new ChanceController(null);
		try {

			prepstmt = c.getConnection().prepareStatement(updateChanceCard);

			for (int i = 1; i <= cc.sizeOfStack(); i++) {
				prepstmt.setInt(1, cc.deck.getDeck().get(i).getCardID());
				prepstmt.setString(2, cc.deck.getDeck().get(i).getCardText());
				prepstmt.setInt(3, cc.deck.getDeck().get(i).getCardValue());
			}
			prepstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			prepstmt.close();
		}

	}

=======
package sql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fieldControllers.ChanceController;

public class ChanceDAOimp implements IChanceDAO {

	private Connector c = new Connector();
	private PreparedStatement prepstmt;

	@Override
	public void getChanceCard(int cardID) throws SQLException {
		String getChanceCard = "SELECT * FROM matador.ChanceDeck WHERE cardID = ?;";
		ResultSet rs;
		ChanceController cc = new ChanceController(null);

		try {

			prepstmt = c.getConnection().prepareStatement(getChanceCard);
			rs = prepstmt.executeQuery();
			while (rs.next()) {
				prepstmt.setInt(1, cardID);
				prepstmt.setString(2, cc.deck.getDeck().get(cardID).getCardText());
				prepstmt.setInt(3, cc.deck.getDeck().get(cardID).getCardValue());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			prepstmt.close();
		}

	}

	@Override
	public void updateChanceCard(int cardID, String cardText, int cardValue) throws SQLException {
		String updateChanceCard = "INSERT INTO matador.ChanceDeck (cardID, cardText, cardValue) VALUES (?,?,?) \n"
				+ "ON DUPLICATE KEY UPDATE cardID = VALUES(cardID), cardText = VALUES(cardText), cardValue = VALUES(cardValue)";

		ChanceController cc = new ChanceController(null);
		try {

			prepstmt = c.getConnection().prepareStatement(updateChanceCard);

			for (int i = 1; i <= cc.sizeOfStack(); i++) {
				prepstmt.setInt(1, cc.deck.getDeck().get(i).getCardID());
				prepstmt.setString(2, cc.deck.getDeck().get(i).getCardText());
				prepstmt.setInt(3, cc.deck.getDeck().get(i).getCardValue());
			}
			prepstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			prepstmt.close();
		}

	}

>>>>>>> refs/remotes/origin/master
}