package sql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

import entities.Board;
import entities.ChanceCard;
import entities.ChanceDeck;
import fieldControllers.ChanceController;
import fieldEntities.Field;
import fieldEntities.Ownable;
import fieldEntities.Street;

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
	public void getChanceCards(int cardID) throws SQLException {
		
	}


	@Override
	public void insertUpdateCards() throws SQLException {
		resetCardDeck();
		String addCardDeckProcedure = "call addCardDeck(?,?);";
		prepstmt = c.getConnection().prepareStatement(addCardDeckProcedure);
		
		for(int i = 0; i<ChanceDeck.getDeck().size();i++){
			prepstmt.setInt(1, ChanceDeck.getDeck().get(i).getCardID());
			prepstmt.setInt(2, i);
			prepstmt.executeUpdate();
			}
		System.out.println("cardDeck is up to date");
		}
		
	
	public static void main (String[] args){
		
		ChanceDeck cc = new ChanceDeck();
		
		
		
		System.out.println("PEEK: "+cc.getDeck().peek());
		System.out.println("INDEX 0: "+cc.getDeck().get(0));
		System.out.println("INDEX 32: "+cc.getDeck().get(32));
		System.out.println("POP: "+cc.getDeck().pop());
		
		
	}

	@Override
	public void resetCardDeck() throws SQLException {
		String resetCardDeckProcedure = "call resetCardDeck();";
		c.doUpdate(resetCardDeckProcedure);
	}

}