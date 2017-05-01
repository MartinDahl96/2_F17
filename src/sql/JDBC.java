package sql;

import java.util.jar.*;

import java.sql.*;
import java.lang.*;
import entities.Board;
import entities.Player;
import fieldControllers.ChanceController;
import fieldEntities.Ownable;
import fieldEntities.Street;
import mainControllers.GameController;

public class JDBC implements DTO, DAO{
	
	
//	private final String HOST ="localhost";
//	private final int PORT = 3306;
	private final String PASSWORD = "1234";
	private Connection connection;
	private PreparedStatement prepstmt = null;
	private Statement stmt = null;
	private String DBname = "matador";
	private String USERNAME = "root";
	
	
	public JDBC() {
        try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost/";
			connection = DriverManager.getConnection(url, USERNAME, PASSWORD);
			System.out.println(connection.getMetaData().getDatabaseProductName());
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			System.exit(1);
		}
    }
	
	public Connection getConnection(){
		return connection;
	}

	public ResultSet doQuery(String query) throws SQLException{
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		return rs;
	}
	
	public void doUpdate(String query) throws SQLException{
		Statement stmt = connection.createStatement();
		stmt.executeQuery(query);
	}

	public void CreateDatabase() throws SQLException {
		
		try {
			stmt = connection.createStatement();
			
			String DBCreate = "CREATE DATABASE matador";
			
			
			String DBPlayer =
					"CREATE TABLE matador.Player (" +
							"  `PlayerID` INT(1) NOT NULL, " +
							"  `Name` VARCHAR(20), Balance INT(7)," +
							"  `Position` INT(2)," +
							"  `Jailtokens` INT(1)," +
							"  `JailRounds` INT(1)," +
							"  `PRIMARY KEY` (`PlayerID`)," +
							"  UNIQUE INDEX `PlayerID_UNIQUE` (PlayerID ASC));";
			
			String DBField =
                    "CREATE TABLE matador.Field (" +
			                "  `fieldID` INT(2) NOT NULL," +
                    		"  `PlayerID` INT(1) NOT NULL,"+
                            "  PRIMARY KEY (`fieldID`)," +  
			                "  FOREIGN KEY (`PlayerID`) REFERENCES " + DBname + ".Player(PlayerID));" ;
			String DBOwnable =
					"CREATE TABLE matador.Ownable (" +
							"  `PlayerID` INT(1) NOT NULL," +
							"  `fieldID` INT(2) NOT NULL," +
							"  `Owner` INT(1)," +
							"  `Houses` INT(1) DEFAULT NULL," +
							"  `Pawned` BIT(1)," +
							"  PRIMARY KEY (`fieldID`)," +
							"  FOREIGN KEY (`Owner`) REFERENCES " + DBname + ".Player(PlayerID)," +
							"  UNIQUE INDEX `fieldID_UNIQUE` (`FieldID` ASC));";
			
			String DBChanceDeck = 
					"  CREATE TABLE matador.ChanceDeck (" +
							"  `CardID` INT(2) NOT NULL," +
							"  `CardText` VARCHAR(150) NOT NULL," +
							"  `CardValue` INT(5) NOT NULL," +
							"  PRIMARY KEY (`CardID`));";
			
			         
			
			DBField = DBField.replace("$DBname", DBname);
			DBPlayer = DBPlayer.replace("$DBname", DBname);
			DBOwnable = DBOwnable.replace("$DBname", DBname);
			
			stmt.executeUpdate(DBPlayer);
			stmt.executeUpdate(DBField);
			stmt.executeUpdate(DBOwnable);
			stmt.executeUpdate(DBChanceDeck);
			stmt.executeUpdate(DBCreate);
		} catch (SQLException | NullPointerException e) {
			e.printStackTrace();
		} finally {
			stmt.close();
			prepstmt.close();
			}
	}
	
	public void ResetDatabase() throws SQLException {
		try {
			//STEP 2: Register JDBC driver
		      Class.forName("com.mysql.jdbc.Driver");

		      //STEP 3: Open a connection
		      System.out.println("Connecting to a selected database...");
		      connection = DriverManager.getConnection(DB_URL, USER, PASS);
		      System.out.println("Connected database successfully...");
		      
		      //STEP 4: Execute a query
		      System.out.println("Deleting database...");
		      stmt = connection.createStatement();
		      
		      String sql = "DROP DATABASE matador";
		      stmt.executeUpdate(sql);
		      System.out.println("Database deleted successfully...");
			
			
			
			
//		    stmt = connection.createStatement();
//			String DropDB = "DROP DATABASE IF EXISTS matador";
//			stmt.executeUpdate(DropDB);
//			CreateDatabase();
		} catch (SQLException | NullPointerException e) {
			e.printStackTrace();
		} finally {
			stmt.close();
			prepstmt.close();}
		}
	//load
	@Override
	public Player getPlayer(int playerID) throws SQLException {
		String getPlayer = "SELECT * FROM $DBname.Player WHERE playerID = ?;";
		Player player = null;
		ResultSet rs;
		
		try{
			getPlayer = getPlayer.replace("$DBname", DBname);
			prepstmt = connection.prepareStatement(getPlayer);
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
	//load
	@Override
	public void getOwnable(int playerID) throws SQLException {
		String getOwnable = "SELECT * FROM $DBname.Field WHERE playerID = ?;";
		ResultSet rs;

		try {
			getOwnable.replace("$DBname", DBname);
			prepstmt = connection.prepareStatement(getOwnable);
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
	//load
	@Override
	public void getChanceCard(int cardID) throws SQLException {
		String getChanceCard = "SELECT * FROM $DBname.ChanceDeck WHERE cardID = ?;";
		ResultSet rs;
		ChanceController cc = new ChanceController(null);
		
		try{
			getChanceCard.replace("$DBname", DBname);
			prepstmt = connection.prepareStatement(getChanceCard);
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

	@Override
	public void removePlayer(int playerID) throws SQLException {
		String updateField = "DELETE * FROM $DBname.Ownable WHERE Owner = ?;";
		String updatePlayer = "DELETE * FROM $DBname.Player WHERE playerID = ?;";
				
		try{
			updateField.replace("$DBname", DBname);
			prepstmt = connection.prepareStatement(updateField);
			prepstmt.setInt(1, playerID);
			prepstmt.executeUpdate();
			
			updatePlayer = updatePlayer.replace("$DBname", DBname);
			prepstmt = connection.prepareStatement(updatePlayer);
			prepstmt.setInt(1, playerID);
			prepstmt.executeUpdate();
			
		}catch (SQLException e){
			e.printStackTrace();
		}
		finally {
			prepstmt.close();
		}
	}
	//save
	@Override
	public void updatePlayer(int playerID) throws SQLException {
		Player p = GameController.getPlayer(playerID);
		String updatePlayer = "INSERT INTO $DBname.Player (playerID,playerName, fortune, immunity, totalAssets, ownedFerries, ownedBreweries, jailRounds, jailToken, currentPosition)"
				+ "VALUES (?,?,?,?,?,?,?,?,?,?)\n"
				+ "ON DUPLICATE KEY UPDATE playerID = VALUES(playerID), playerName = VALUES(playerName), fortune = VALUES(fortune), immunity = VALUES(immunity), totalAssets = VALUES(totalAssets),"
				+ "ownedFerries = VALUES(ownedFerries), ownedBreweries = VALUES(ownedBreweries), jailRounds = VALUES(jailRounds), jalToken = VALUES(jailToken), currentPosition = VALUES(currentPosition)";
		try {
			updatePlayer.replace("$DBname", DBname);
			prepstmt = connection.prepareStatement(updatePlayer);
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
	//save
	@Override
	public void updateOwnable(int playerID) throws SQLException {
		String updateOwnable = "INSERT INTO $DBname.Ownable (fieldID, Owner, Pawned) VALUES (?,?,?,?) \n "
				+ "ON DUPLICATE KEY UPDATE fieldID = VALUES(fieldID), Owner = VALUES(Owner), Pawned = VALUES(Pawned)";
		try {
			updateOwnable = updateOwnable.replace("$DBname", DBname);
			prepstmt = connection.prepareStatement(updateOwnable);
			for (int i = 0; i < 41; i++) {
				if (Board.getFields().get(i) instanceof Ownable) {
					if (((Ownable) Board.getFields().get(i)).getOwner() == GameController.getPlayer(playerID))
						;
					prepstmt.setInt(1, i);
					prepstmt.setInt(2, playerID);

					if (Board.getFields().get(i) instanceof Street) {
						prepstmt.setInt(3, ((Street) Board.getFields().get(i)).getNumOfBuildings());
					}

					else {
						prepstmt.setInt(3, 0);
					}
					prepstmt.setBoolean(5, ((Street) Board.getFields().get(i)).isPawned());
					prepstmt.executeUpdate();

				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			prepstmt.close();
		}

	}
	//save
	@Override
	public void updateChanceCard(int cardID, String cardText, int cardValue) throws SQLException {
		String updateChanceCard = "INSERT INTO $DBname.ChanceDeck (cardID, cardText, cardValue) VALUES (?,?,?) \n" +
									"ON DUPLICATE KEY UPDATE cardID = VALUES(cardID), cardText = VALUES(cardText), cardValue = VALUES(cardValue)";
		ChanceController cc = new ChanceController(null);
		try{
			updateChanceCard.replace("$DBname", DBname);
			prepstmt = connection.prepareStatement(updateChanceCard);
	
			for (int i = 1 ; i <= cc.sizeOfStack() ; i++){
				prepstmt.setInt(1, cc.deck.getDeck().get(i).getCardID());
				prepstmt.setString(2, cc.deck.getDeck().get(i).getCardText());
				prepstmt.setInt(3, cc.deck.getDeck().get(i).getCardValue());
			}
			
		} catch(SQLException e){
			e.printStackTrace();
		}finally {
			prepstmt.close();
		}
		
	}
	//save
	public void saveGame(int playerID) throws SQLException {
		updatePlayer(playerID);
		updateOwnable(playerID);
		}
}