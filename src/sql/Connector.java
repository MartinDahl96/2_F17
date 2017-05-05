package sql;

import java.sql.*;

public class Connector {

	//attributes
	private final String LOCALHOST = "Localhost";
	private final int PORT = 3306;
	private final String USERNAME = "root";
	private final String PASSWORD = "sql123";
	private final String DATABASE = "matador";
	private Connection con;

	/**
	 * constructor for the Connector.
	 * the constructor establishes a connection between the java-project and the database server.
	 */
	public Connector() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://" + LOCALHOST + ":" + PORT + "/" + DATABASE;
			con = DriverManager.getConnection(url, USERNAME, PASSWORD);

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			e.getMessage();
			System.exit(0);
		}
	}

	/**
	 * used to retreive the connection to the database server.
	 * @return con is the connection to the database server.
	 */
	public Connection getConnection() {
		return con;
	}

	/**
	 * used to create a result set of a preparedstatement to be executed in the database.
	 * @param query is the result set of the preparedstatement to be executed.
	 * @return rs is the result set executed from the preparedstatement.
	 * @throws SQLException
	 */
	public ResultSet doQuery(String query) throws SQLException {
		PreparedStatement prepstmt = con.prepareStatement(query);
		ResultSet rs = prepstmt.executeQuery();
		return rs;
	}

	/**
	 * used to create an updating statement.
	 * @param query is the updating statement.
	 * @throws SQLException
	 */
	public void doUpdate(String query) throws SQLException {
		Statement stmt = con.createStatement();
		stmt.executeUpdate(query);
	}

	/**
	 * used to create a prepared statement.
	 * @param query is the prepared statement to create.
	 * @return prepstmt is the prepared statement created.
	 * @throws SQLException
	 */
	public PreparedStatement doPreparedStmt(String query) throws SQLException {
		PreparedStatement prepstmt = con.prepareStatement(query);
		return prepstmt;
	}

	/**
	 * used to get the name of the database.
	 * @return DATABASE is the name of the database.
	 */
	public String getDBname() {
		return DATABASE;
	}

}