package sql;

import java.sql.SQLException;

public interface IFieldDAO {

	void getOwnable() throws SQLException;
	
	void updateOwnable() throws SQLException;

	void insertOwnable() throws SQLException;

	void getBuildingsOnStreet() throws SQLException;

}
