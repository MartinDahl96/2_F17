package sql;

import java.sql.*;
import entities.Player;
import mainControllers.GameController;

public class PlayerDAOimp implements IPlayerDAO {
	private Connector c = new Connector();
	private PreparedStatement prepstmt;

	@Override
	public void getPlayers() throws SQLException { // Implementer

		String getPlayers = "SELECT * FROM notlostplayers;"; // selecting from
																// view
		ResultSet rs = c.doQuery(getPlayers);

		while (rs.next()) {
			GameController.getPlayers().add(new Player(rs.getInt("playerID"), 
													   rs.getString("playerName"), 
													   rs.getInt("fortune"),
													   rs.getInt("jailRounds"), 
													   rs.getInt("jailToken"), 
													   rs.getInt("currentPosition")));
			
		}

		rs.close();
	}

	public void getOwnedFerries() throws SQLException { 
		String ownedFerries = "SELECT * FROM ownedferries;"; // selecting from view											
		ResultSet rs = c.doQuery(ownedFerries);
		while (rs.next()) {
			GameController.getPlayer(rs.getInt("playerID")).setOwnedFerries(1);
		}
	}

	public void getOwnedBreweries() throws SQLException { // Implementer
		String ownedBreweries = "SELECT * FROM ownedBreweries;"; // selecting from view
		ResultSet rs = c.doQuery(ownedBreweries);
		while (rs.next()) {
			GameController.getPlayer(rs.getInt("playerID")).setOwnedBreweries(1);
		}
	}

	@Override
	public void insertPlayer() throws SQLException {
		String addPlayerProcedure = "call addPlayer(?,?,?,?,?,?)";

		for (Player p : GameController.getPlayers()) {
			prepstmt = c.getConnection().prepareStatement(addPlayerProcedure);
			prepstmt.setInt(1, p.getPlayerID());
			prepstmt.setString(2, p.getplayerName());
			prepstmt.setInt(3, p.getFortune());
			prepstmt.setInt(4, p.getJailRounds());
			prepstmt.setInt(5, p.getJailToken());
			prepstmt.setInt(6, p.getCurrentPosition());
			prepstmt.executeUpdate();
			prepstmt.close();
		}
		System.out.println("Players added to database");

	}

	@Override
	public void updatePlayer() throws SQLException {
		String updatePlayerProcedure = "call updatePlayer(?,?,?,?,?,?)";

		for (Player p : GameController.getPlayers()) {
			prepstmt = c.getConnection().prepareStatement(updatePlayerProcedure);
			prepstmt.setInt(1, p.getPlayerID());
			prepstmt.setString(2, p.getplayerName());
			prepstmt.setInt(3, p.getFortune());
			prepstmt.setInt(4, p.getJailRounds());
			prepstmt.setInt(5, p.getJailToken());
			prepstmt.setInt(6, p.getCurrentPosition());
			prepstmt.executeUpdate();
			prepstmt.close();

		}
		System.out.println("Players updated in database");
	}
}