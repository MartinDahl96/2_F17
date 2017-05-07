package sql;

import java.io.IOException;
import java.sql.*;
import entities.Player;
import inputHandlers.Text;
import mainControllers.GameController;

public class PlayerDAOimp implements IPlayerDAO {
	
	//attributes
	private Connector c = new Connector();
	private PreparedStatement prepstmt;
	private Text file = new Text("txtfiles/sql.txt");
	private String[] textList;


	
	/**
	 * Constructor for the PlayerDataAccessObjectImplementation 
	 */
	public PlayerDAOimp(){
		try {
			textList = file.OpenFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * used to get a player's information from the database.
	 * @throws SQLException if no connection can be made.
	 */
	@Override
	public void getPlayers() throws SQLException { // Implementer

		String getPlayers = textList[28]; // selecting from
																// view
		ResultSet rs = c.doQuery(getPlayers);

		while (rs.next()) {
			GameController.getPlayers().add(new Player(rs.getInt(textList[29]), 
													   rs.getString(textList[30]), 
													   rs.getInt(textList[31]),
													   rs.getInt(textList[32]), 
													   rs.getInt(textList[33]), 
													   rs.getInt(textList[34])));
			
		}

		rs.close();
	}

	/**
	 * used to get the amount of ferries owned by a player in the database.
	 * @throws SQLException if no connection can be made.
	 */
	public void getOwnedFerries() throws SQLException { 
		String ownedFerries = textList[35]; // selecting from view											
		ResultSet rs = c.doQuery(ownedFerries);
		while (rs.next()) {
			GameController.getPlayer(rs.getInt(textList[29])).setOwnedFerries(1);
		}
	}

	/**
	 * used to get the amount of breweries owned by a player in the database.
	 * @throws SQLException if no connection can be made.
	 */
	public void getOwnedBreweries() throws SQLException { 
		String ownedBreweries = textList[37]; // selecting from view
		ResultSet rs = c.doQuery(ownedBreweries);
		while (rs.next()) {
			GameController.getPlayer(rs.getInt(textList[29])).setOwnedBreweries(1);
		}
	}

	/**
	 * used to insert a player's information into the database.
	 * @throws SQLException if no connection can be made.
	 */
	@Override
	public void insertPlayer() throws SQLException {
		String addPlayerProcedure = textList[37];

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
		System.out.println(textList[38]);

	}

	/**
	 * used to update a player's information in the database.
	 * @throws SQLException if no connection can be made.
	 */
	@Override
	public void updatePlayer() throws SQLException {
		String updatePlayerProcedure = textList[39];

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
		System.out.println(textList[40]);
	}
}