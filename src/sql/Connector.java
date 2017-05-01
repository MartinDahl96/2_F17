package sql;
import java.sql.*;


public class Connector 
{
//
	final String PASSWORD = "1234";
	final String USERNAME = "root";
	final String DATABASE = "matador";
	String url = "jdbc:mysql://localhost::3306/";
	Statement stmt = null;
	Connection connection = null;
	
	public Connector() {
		
        try {
        	
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(url, USERNAME, PASSWORD);
			stmt = connection.createStatement();
		      String sql = "CREATE DATABASE matador";
		      stmt.executeUpdate(sql);
			
			System.out.println(connection.getMetaData().getDatabaseProductName());
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
//			System.exit(1);
		}
   
    }
	
	public Connection getConnection(){
	    	return connection;
	    }
	 
	public ResultSet doQuery(String query) throws SQLException {
		 Statement stmt = connection.createStatement();
		 ResultSet  rs = stmt.executeQuery(query);
		 return rs;
	 }
	 
	public void doUpdate(String query) throws SQLException{
		 Statement stmt = connection.createStatement();
		 stmt.executeUpdate(query);
	 }
	 
	public PreparedStatement doPreparedStmt(String query) throws SQLException{
		 PreparedStatement prepstmt = connection.prepareStatement(query);
		 return prepstmt;
	 }
	 
	public String getDBname(){
		 return DATABASE;
	 }
	
	public int boolToInt(boolean b){
			
			return b ? 1 :0;
		} 
	 
	public void CreateDatabase() throws SQLException {
			
			try {	
				stmt = connection.createStatement();
				
				String DBCreate = "CREATE DATABASE IF NOT EXISTS matador;";
								
				String DBPlayer =
						"CREATE TABLE IF NOT EXISTS matador.Player (PlayerID INT(1) NOT NULL, playerName VARCHAR(20), fortune INT(7), immunity BIT(1),totalAssets INT(6), ownedFerries INT(1), ownedBreweries INT(1),jailRounds INT(1),jailtoken INT(1),currentPosition INT(2),PRIMARY KEY (PlayerID),UNIQUE INDEX PlayerID_UNIQUE (PlayerID ASC));";
				
				String DBField =
	                    "CREATE TABLE IF NOT EXISTS matador.field (fieldID INT(2) NOT NULL,PlayerID INT(1) NOT NULL,PRIMARY KEY (fieldID),FOREIGN KEY (PlayerID) REFERENCES matador.Player(PlayerID));" ;
				String DBOwnable =
						"CREATE TABLE IF NOT EXISTS matador.Ownable (PlayerID INT(1) NOT NULL,fieldID INT(2) NOT NULL,Owner INT(1),Houses INT(1) DEFAULT NULL,Pawned BIT(1),PRIMARY KEY (fieldID),FOREIGN KEY (Owner) REFERENCES matador.Player(PlayerID),UNIQUE INDEX fieldID_UNIQUE (FieldID ASC));";
				
				String DBChanceDeck = 
						"CREATE TABLE IF NOT EXISTS matador.ChanceDeck (CardID INT(2) NOT NULL,CardText VARCHAR(150) NOT NULL,CardValue INT(5) NOT NULL,PRIMARY KEY (CardID));";
				
				stmt.executeUpdate(DBCreate);
				stmt.executeUpdate(DBPlayer);
				stmt.executeUpdate(DBField);
				stmt.executeUpdate(DBOwnable);
				stmt.executeUpdate(DBChanceDeck);
		
			} catch (Exception  e) {
				e.printStackTrace();
			} 

			
			finally {
				stmt.close();
				
				}
		}
	
	public void ResetDatabase() throws SQLException {

		
			try {
				
				String url = "jdbc:mysql://localhost/";
				String sql = "DROP DATABASE IF EXISTS matador";
				Class.forName("com.mysql.jdbc.Driver");

				System.out.println("Connecting to a selected database...");
				connection = DriverManager.getConnection(url, USERNAME, PASSWORD);
				System.out.println("Connected database successfully...");

				System.out.println("Deleting database...");
				stmt = connection.createStatement();

				stmt.executeUpdate(sql);
				System.out.println("Database deleted successfully...");

			} catch (SQLException | NullPointerException e) {
				e.printStackTrace();

			} catch (Exception e) {
				e.printStackTrace();
			}

			finally {
				stmt.close();
			}
		}
	
	public static void main (String[] args){
		Connector c = new Connector();
		try {
			c.CreateDatabase();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}