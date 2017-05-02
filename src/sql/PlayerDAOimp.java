package sql;

import java.sql.*;

import entities.Board;
import entities.Player;
import fieldControllers.ChanceController;
import fieldEntities.Ownable;
import fieldEntities.Street;
import mainControllers.GameController;

public class PlayerDAOimp implements IPlayerDAO {
	private Connector c = new Connector();
	
	private PreparedStatement prepstmt;

	@Override
	public Player getPlayer(int playerID) throws SQLException {
		String getPlayer = "SELECT * FROM matador.Player WHERE playerID = ?;";
		Player player = null;
		ResultSet rs;

		try {
			prepstmt = c.getConnection().prepareStatement(getPlayer);
			prepstmt.setInt(1, playerID);
			rs = prepstmt.executeQuery();
			if (rs.next()) {
				player = new Player(rs.getInt("playerID"), rs.getString("playerName"), rs.getInt("fortune"),
						rs.getBoolean("immunity"), rs.getInt("totalAssets"), rs.getInt("ownedFerries"),
						rs.getInt("ownedBreweries"), rs.getInt("jailRounds"), rs.getInt("jailToken"),
						rs.getInt("currentPosition"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			prepstmt.close();
		}

		return player;
	}

	

	@Override
	public void removePlayer(int playerID) throws SQLException {
		String updateField = "DELETE * FROM matador.Ownable WHERE Owner = ?;";
		String updatePlayer = "DELETE * FROM matador.Player WHERE playerID = ?;";
				
		try{
			
			prepstmt = c.getConnection().prepareStatement(updatePlayer);
			prepstmt.setInt(1, playerID);
			prepstmt.executeUpdate();
			
			
			prepstmt = c.getConnection().prepareStatement(updateField);
			prepstmt.setInt(1, playerID);
			prepstmt.executeUpdate();
			
		}catch (SQLException e){
			e.printStackTrace();
		}
		finally {
			prepstmt.close();
		}
	}

	@Override
	public void updatePlayer(int playerID) throws SQLException {
		Player p = GameController.getPlayer(playerID);
	String updatePlayer = "INSERT INTO matador.Player (playerID, playerName, fortune, immunity, totalAssets, ownedFerries, ownedBreweries, jailRounds, jailToken, currentPosition) VALUES (?,?,?,?,?,?,?,?,?,?) ON DUPLICATE KEY UPDATE playerID = VALUES(playerID), playerName = VALUES(playerName), fortune = VALUES(fortune), immunity = VALUES(immunity), totalAssets = VALUES(totalAssets), ownedFerries = VALUES(ownedFerries), ownedBreweries = VALUES(ownedBreweries), jailRounds = VALUES(jailRounds), jailToken = VALUES(jailToken), currentPosition = VALUES(currentPosition);";
		
		try {
			prepstmt = c.getConnection().prepareStatement(updatePlayer);
			prepstmt.setInt(1, p.getPlayerID());
			prepstmt.setString(2, p.getplayerName());
			prepstmt.setInt(3, p.getFortune());
			prepstmt.setBoolean(4, p.getImmunity());
			prepstmt.setInt(5, p.getTotalAssets());
			prepstmt.setInt(6, p.getOwnedFerries());
			prepstmt.setInt(7, p.getOwnedBreweries());
			prepstmt.setInt(8, p.getJailRounds());
			prepstmt.setInt(9, p.getJailToken());
			prepstmt.setInt(10, p.getCurrentPosition());
			prepstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			prepstmt.close();
		}

	}

}
