<<<<<<< HEAD
package sql;

import java.sql.*;

import entities.Board;
import entities.Player;
import fieldControllers.ChanceController;
import fieldEntities.Ownable;
import fieldEntities.Street;

public class DAOimp implements DAO {
	private Connector c = new Connector();
	private PreparedStatement prepstmt;

	@Override
	public Player getPlayer(int playerID) throws SQLException {
		String getPlayer = "SELECT * FROM matador.Player WHERE playerID = ?;";
		Player player = null;
		ResultSet rs;
		
		try{
			prepstmt = c.getConnection().prepareStatement(getPlayer);
			prepstmt.setInt(1, playerID);
			rs = prepstmt.executeQuery();
			if(rs.next()){
			player = new Player(rs.getInt("playerID"),
					rs.getString("playerName"),
					rs.getInt("fortune"),
					rs.getBoolean("immunity"),
					rs.getInt("totalAssets"),
					rs.getInt("ownedFerries"),
					rs.getInt("ownedBreweries"),
					rs.getInt("jailRounds"),
					rs.getInt("jailToken"),
					rs.getInt("currentPosition"));
					}
		}
			catch(SQLException e){
			e.printStackTrace();
		} finally{
			prepstmt.close();
		}
		
		return player;
	}

	@Override
	public void getOwnable(int playerID) throws SQLException {
		String getOwnable = "SELECT * FROM matador.Field WHERE playerID = ?;";
		ResultSet rs;

		try {
			
			prepstmt = c.getConnection().prepareStatement(getOwnable);
			prepstmt.setInt(1, playerID);
			rs = prepstmt.executeQuery();
			int fieldID = rs.getInt("fieldID");
			while (rs.next()) {

				((Ownable) Board.getFields().get(fieldID)).getOwner();
			}
			if (rs.getBoolean("Pawned")) {
				((Ownable) Board.getFields().get(fieldID)).setPawned(true);
			}
			if (Board.getFields().get(fieldID) instanceof Street) {
				((Street) Board.getFields().get(fieldID)).setNumOfBuildings(rs.getInt("Houses"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		finally {
			prepstmt.close();
		}

	}

	@Override
	public void getChanceCard(int cardID) throws SQLException {
		String getChanceCard = "SELECT * FROM matador.ChanceDeck WHERE cardID = ?;";
		ResultSet rs;
		ChanceController cc = new ChanceController(null);
		
		try{
			
			prepstmt = c.getConnection().prepareStatement(getChanceCard);
			rs = prepstmt.executeQuery();
			while (rs.next()){
			prepstmt.setInt(1, cardID);
			prepstmt.setString(2, cc.deck.getDeck().get(cardID).getCardText());
			prepstmt.setInt(3, cc.deck.getDeck().get(cardID).getCardValue());
			}
		}catch(SQLException e){
			e.printStackTrace();
		} finally {
			prepstmt.close();
		}
		
	}

	public void loadGame(int playerID)  throws SQLException {
		getPlayer(playerID);
		getOwnable(playerID);	
	}
}
=======
package sql;

import java.sql.*;

import entities.Board;
import entities.Player;
import fieldControllers.ChanceController;
import fieldEntities.Ownable;
import fieldEntities.Street;

public class DAOimp implements DAO {
	private Connector c = new Connector();
	private PreparedStatement prepstmt;

	@Override
	public Player getPlayer(int playerID) throws SQLException {
		String getPlayer = "SELECT * FROM matador.Player WHERE playerID = ?;";
		Player player = null;
		ResultSet rs;
		
		try{
			prepstmt = c.getConnection().prepareStatement(getPlayer);
			prepstmt.setInt(1, playerID);
			rs = prepstmt.executeQuery();
			if(rs.next()){
			player = new Player(rs.getInt("playerID"),
					rs.getString("playerName"),
					rs.getInt("fortune"),
					rs.getBoolean("immunity"),
					rs.getInt("totalAssets"),
					rs.getInt("ownedFerries"),
					rs.getInt("ownedBreweries"),
					rs.getInt("jailRounds"),
					rs.getInt("jailToken"),
					rs.getInt("currentPosition"));
					}
		}
			catch(SQLException e){
			e.printStackTrace();
		} finally{
			prepstmt.close();
		}
		
		return player;
	}

	@Override
	public void getOwnable(int playerID) throws SQLException {
		String getOwnable = "SELECT * FROM matador.Field WHERE playerID = ?;";
		ResultSet rs;

		try {
			
			prepstmt = c.getConnection().prepareStatement(getOwnable);
			prepstmt.setInt(1, playerID);
			rs = prepstmt.executeQuery();
			int fieldID = rs.getInt("fieldID");
			while (rs.next()) {

				((Ownable) Board.getFields().get(fieldID)).getOwner();
			}
			if (rs.getBoolean("Pawned")) {
				((Ownable) Board.getFields().get(fieldID)).setPawned(true);
			}
			if (Board.getFields().get(fieldID) instanceof Street) {
				((Street) Board.getFields().get(fieldID)).setNumOfBuildings(rs.getInt("Houses"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		finally {
			prepstmt.close();
		}

	}

	@Override
	public void getChanceCard(int cardID) throws SQLException {
		String getChanceCard = "SELECT * FROM matador.ChanceDeck WHERE cardID = ?;";
		ResultSet rs;
		ChanceController cc = new ChanceController(null);
		
		try{
			
			prepstmt = c.getConnection().prepareStatement(getChanceCard);
			rs = prepstmt.executeQuery();
			while (rs.next()){
			prepstmt.setInt(1, cardID);
			prepstmt.setString(2, cc.deck.getDeck().get(cardID).getCardText());
			prepstmt.setInt(3, cc.deck.getDeck().get(cardID).getCardValue());
			}
		}catch(SQLException e){
			e.printStackTrace();
		} finally {
			prepstmt.close();
		}
		
	}

	public void loadGame(int playerID)  throws SQLException {
		getPlayer(playerID);
		getOwnable(playerID);	
	}
}
>>>>>>> refs/remotes/origin/master
