package sql;

import java.sql.SQLException;

public interface IFieldDAO {

	void getOwnable(int playerID) throws SQLException;
	
	void updateOwnable() throws SQLException;

	void insertOwnable() throws SQLException;
	
	
	
	
}
