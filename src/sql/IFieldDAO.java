package sql;

import java.sql.SQLException;

public interface IFieldDAO {

	void getOwnable(int playerID) throws SQLException;
	
	void updateOwnable(int playerID) throws SQLException;
	
	
	
	
}
