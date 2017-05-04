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
	private Statement stmt;

	@Override
	public Player getPlayer() throws SQLException {
		
		String getPlayer = "SELECT * FROM playerview;";
		stmt = c.getConnection().createStatement();
		
		while(c.doQuery(getPlayer).next()){
			GameController.getPlayers().add(new Player(rs.getInt("playerID"),
													   rs.getString("playerName"), 
													   rs.getInt("fortune"), 
													   rs.getInt("jailRounds"), 
													   rs.getInt("jailToken"), 
													   rs.getInt("currentPosition")));
		}
		
		
		
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
	public void insertPlayer() throws SQLException {
		String addPlayerProcedure = "call addPlayer(?,?,?,?,?,?)";
		
		for(Player p: GameController.getPlayers()){
			
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
		
		for(Player p: GameController.getPlayers()){
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