package sql;

import java.sql.SQLException;

public interface IChanceDAO {
	
	public void getChanceCard(int cardID) throws SQLException;
	
	void updateChanceCard(int cardID, String cardText, int cardValue) throws SQLException;

}
