package sql;

import java.sql.SQLException;

public interface IFieldDAO {

	/**
	 * used to get an ownable field's status from the database.
	 * @throws SQLException if no connection can be made.
	 */
	void getOwnable() throws SQLException;
	
	/**
	 * used to update an ownable field's status in the database.
	 * @throws SQLException if no connection can be made.
	 */
	void updateOwnable() throws SQLException;

	/**
	 * used to insert an ownable field's status in the database.
	 * @throws SQLException if no connection can be made.
	 */
	void insertOwnable() throws SQLException;

	/**
	 * used to get the amount of buildings on a street field in the database.
	 * @throws SQLException if no connection can be made.
	 */
	void getBuildingsOnStreet() throws SQLException;

}
