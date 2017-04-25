package sql;

import java.sql.*;

import entities.Board;
import entities.Player;
import fieldEntities.Ownable;
import fieldEntities.Street;

public class JDBC implements DTO, DAO{
	
	
	private static Connection con;
	private PreparedStatement prepstmt;
	private Statement stmt;
	private String DBname = "";
	
	public void CreateDatabase() throws SQLException {
		
		try {
			String DBPlayer =
					"CREATE TABLE $DBname.Player (\n" +
							"  PlayerID INT(1) NOT NULL,\n" +
							"  Name VARCHAR(20),\n" +
							"  Balance INT(7),\n" +
							"  Position INT(2),\n" +
							"  Jailtokens INT(1),\n" +
							"  JailRounds INT(1),\n" +
							"  PRIMARY KEY (`PlayerID`),\n" +
							"  UNIQUE INDEX `PlayerID_UNIQUE` (`PlayerID` ASC));";
			
			String DBField =
                    "CREATE TABLE $DBname.Field (\n" +
			                "  fieldID INT(2) NOT NULL, \n" +
                    		"  PlayerID INT(1) NOT NULL, \n "+
                            "  PRIMARY KEY (`fieldID`), \n" +  
			                "  FOREIGN KEY (`PlayerID`) REFERENCES " + DBname + ".Player(PlayerID),\n" ;
			String DBOwnable =
					"CREATE TABLE $DBname.Ownable (\n" +
							"  PlayerID INT(1) NOT NULL,\n" +
							"  fieldID INT(2), \n" +
							"  Owner INT(1),\n" +
							"  FOREIGN KEY (`Owner`) REFERENCES " + DBname + ".Player(PlayerID),\n" +
							"  Houses INT(1) DEFAULT NULL,\n" +
							"  Pawned BIT(1),\n" +
							"  PRIMARY KEY (`fieldID`),\n" +
							"  UNIQUE INDEX `fieldID_UNIQUE` (`FieldID` ASC));";
			
			String DBChanceDeck = 
							"  CREATE TABLE $DBname.ChanceDeck (\n" +
							"  CardID INT(2) NOT NULL, \n" +
							"  StackLoc INT(2), \n" +
							"  PRIMARY KEY (`CardID`))";
			
		/**	         
			
			DBPlayer = DBPlayer.replace("$DBname", DBname);
			DBField = DBField.replace("$DBname", DBname);
			DBOwnable = DBOwnable.replace("$DBname", DBname);
			
		*/
			stmt = con.createStatement();;
			prepstmt = con.prepareStatement(DBPlayer);
			prepstmt.execute();
			prepstmt = con.prepareStatement(DBField);
			prepstmt.execute();
			prepstmt = con.prepareStatement(DBOwnable);
			prepstmt.execute();
			prepstmt = con.prepareStatement(DBChanceDeck);
			prepstmt.execute();
		} catch (SQLException | NullPointerException e) {
			e.printStackTrace();
		} finally {
			stmt.close();
			prepstmt.close();}
	}
	
	
	public void ResetDatabase() throws SQLException {
		try {
			String dropField = "DROP TABLE IF EXISTS " + DBname + ".Field";
			String dropPlayer = "DROP TABLE IF EXISTS " + DBname + ".Player";
			String dropOwnable = "DROP TABLE IF EXIST " + DBname +".Ownable";
			String dropChanceDeck = "DROP TABLE IF EXIST " + DBname + ".ChanceDeck";
			String DBPlayer =
					"CREATE TABLE $DBname.Player (\n" +
							"  PlayerID INT(1) NOT NULL,\n" +
							"  Name VARCHAR(20),\n" +
							"  Balance INT(7),\n" +
							"  Position INT(2),\n" +
							"  Jailtokens INT(1),\n" +
							"  JailRounds INT(1),\n" +
							"  PRIMARY KEY (`PlayerID`),\n" +
							"  UNIQUE INDEX `PlayerID_UNIQUE` (`PlayerID` ASC));";
			
			String DBField =
                    "CREATE TABLE $DBname.Field (\n" +
			                "  fieldID INT(2) NOT NULL, \n" +
                    		"  PlayerID INT(1) NOT NULL, \n "+
                            "  PRIMARY KEY (`fieldID`), \n" +  
			                "  FOREIGN KEY (`PlayerID`) REFERENCES " + DBname + ".Player(PlayerID),\n" ;
			String DBOwnable =
					"CREATE TABLE $DBname.Ownable (\n" +
							"  PlayerID INT(1) NOT NULL,\n" +
							"  fieldID INT(2), \n" +
							"  Owner INT(1),\n" +
							"  FOREIGN KEY (`Owner`) REFERENCES " + DBname + ".Player(PlayerID),\n" +
							"  Houses INT(1) DEFAULT NULL,\n" +
							"  Pawned BIT(1),\n" +
							"  PRIMARY KEY (`fieldID`),\n" +
							"  UNIQUE INDEX `fieldID_UNIQUE` (`FieldID` ASC));";
			
			String DBChanceDeck = 
							"  CREATE TABLE $DBname.ChanceDeck (\n" +
							"  CardID INT(2) NOT NULL, \n" +
							"  StackLoc INT(2), \n" +
							"  PRIMARY KEY (`CardID`))";
			
			         
			
			DBPlayer = DBPlayer.replace("$DBname", DBname);
			DBField = DBField.replace("$DBname", DBname);
			DBOwnable = DBOwnable.replace("$DBname", DBname);
			stmt = con.createStatement();
			stmt.execute(dropField);
			stmt.execute(dropPlayer);
			stmt.execute(dropOwnable);
			stmt.execute(dropChanceDeck);
			prepstmt = con.prepareStatement(DBPlayer);
			prepstmt.execute();
			prepstmt = con.prepareStatement(DBField);
			prepstmt.execute();
			prepstmt = con.prepareStatement(DBOwnable);
			prepstmt.execute();
			prepstmt = con.prepareStatement(DBChanceDeck);
			prepstmt.execute();
		} catch (SQLException | NullPointerException e) {
			e.printStackTrace();
		} finally {
			stmt.close();
			prepstmt.close();}
		}
	
public void jailTokenCounter() throws SQLException{
	
};


	public static void main(String[] args) throws Exception {
		// connection data

		Statement stmt = null;
		String HOST = "localhost";
		int PORT = 3306;
		String DATABASE = "Matador";
		String USERNAME = "root";
		String PASSWORD = "1234";

		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE;
		Connection conn = DriverManager.getConnection(url, USERNAME, PASSWORD);
		System.out.println(conn.getMetaData().getDatabaseProductName());

		
		
	
		
		
	}


	@Override
	public Player getPlayer(int playerID) throws SQLException {
		String query = "SELECT * FROM $DBname.Player WHERE playerID = ?;";
		Player player = null;
		ResultSet rs;
		
		try{
			query = query.replace("$DBname", DBname);
			prepstmt = con.prepareStatement(query);
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
		String query = "SELECT * FROM $DBname.Field WHERE playerID = ?;";
		ResultSet rs;
		
		
		try{
		query.replace("$DBname", DBname);
		prepstmt = con.prepareStatement(query);
		prepstmt.setInt(1, playerID);
		rs = prepstmt.executeQuery();
		int fieldID = rs.getInt("fieldID");
		while (rs.next()){
			
			((Ownable) Board.getFields().get(fieldID)).getOwner();
			}
			if(rs.getBoolean("Pawned")){
			((Ownable) Board.getFields().get(fieldID)).setPawned(true);
			}
			if(Board.getFields().get(fieldID) instanceof Street){
				((Street) Board.getFields().get(fieldID)).setNumOfBuildings(rs.getInt("Houses"));
			}
			
		
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
		finally{
			prepstmt.close();
		}
		
		
		
		
		
	}


	@Override
	public void getChanceDeck(int cardID) throws SQLException {
		String query = "SELECT * FROM $DBname.ChanceDeck WHERE cardID = ?;";
		ResultSet rs;
		
		try{
			query.replace("$DBname", DBname);
			prepstmt = con.prepareStatement(query);
			prepstmt.setInt(1, cardID);
			rs = prepstmt.executeQuery();
			while (rs.next()){
				
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		} finally {
			prepstmt.close();
		}
		
	}


	@Override
	public void removePlayer(int playerID) throws SQLException {
		String updateField = "DELETE * FROM $DBname.Field WHERE Owner = ?;";
		String updatePlayer = "DELETE * FROM $DBname.Player WHERE playerID = ?;";
				
		try{
			updateField.replace("$DBname", DBname);
			prepstmt = con.prepareStatement(updateField);
			prepstmt.setInt(1, playerID);
			prepstmt.executeUpdate();
			
			updatePlayer = updatePlayer.replace("$DBname", DBname);
			prepstmt = con.prepareStatement(updatePlayer);
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
		Player p = null;
		String updatePlayer = "INSERT INTO $DBname.Player (playerID,playerName, fortune, immunity, totalAssets, ownedFerries, ownedBreweries, jailRounds, jailToken, currentPosition)"
				+ "VALUES (?,?,?,?,?,?,?,?,?,?)\n" +
				"ON DUPLICATE KEY UPDATE playerID = VALUES(playerID), playerName = VALUES(playerName), fortune = VALUES(fortune), immunity = VALUES(immunity), totalAssets = VALUES(totalAssets)," +
				"ownedFerries = VALUES(ownedFerries), ownedBreweries = VALUES(ownedBreweries), jailRounds = VALUES(jailRounds), jalToken = VALUES(jailToken), currentPosition = VALUES(currentPosition)";
		try{
		updatePlayer.replace("$DBname", DBname);
		prepstmt = con.prepareStatement(updatePlayer);
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
		
		} catch (SQLException e){
			e.printStackTrace();
		} finally{
			prepstmt.close();
		}
		
		
		
	}


	@Override
	public void updateField(int playerID) throws SQLException {
		String updateField = "INSERT INTO $DBname.Field";
		
	}


	@Override
	public void updateChanceDeck(int cardID) throws SQLException {
		// TODO Auto-generated method stub
		
	}
}