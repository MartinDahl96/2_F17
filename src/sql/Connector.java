package sql;

import java.sql.*;

public class Connector {

	private final String LOCALHOST = "Localhost";
	private final int PORT = 3306;
	private final String USERNAME = "root";
	private final String PASSWORD = "sql123";
	private final String DATABASE = "matador";
	private Connection con;
	private Statement stmt;

	public Connector() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://" + LOCALHOST + ":" + PORT + "/" + DATABASE;
			con = DriverManager.getConnection(url, USERNAME, PASSWORD);

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			System.exit(0);
		}

	}

	public Connection getConnection() {
		return con;
	}

	public ResultSet doQuery(String query) throws SQLException {
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		return rs;
	}

	public void doUpdate(String query) throws SQLException {
		Statement stmt = con.createStatement();
		stmt.executeUpdate(query);
	}

	public PreparedStatement doPreparedStmt(String query) throws SQLException {
		PreparedStatement prepstmt = con.prepareStatement(query);
		return prepstmt;
	}

	public String getDBname() {
		return DATABASE;
	}

}