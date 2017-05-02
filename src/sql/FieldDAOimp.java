package sql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entities.Board;
import fieldEntities.Ownable;
import fieldEntities.Street;
import mainControllers.GameController;

public class FieldDAOimp implements IFieldDAO {

	private Connector c = new Connector();
	private PreparedStatement prepstmt;

	@Override
	public void getOwnable(int playerID) throws SQLException {
		String getOwnable = "SELECT * FROM matador.Field WHERE playerID = ?;";
		ResultSet rs;

		try {

			prepstmt = c.getConnection().prepareStatement(getOwnable);
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

	@Override
	public void updateOwnable(int playerID) throws SQLException {
		String updateOwnable = "INSERT INTO matador.Ownable (PlayerID,fieldID, Owner, houses, Pawned VALUES (?,?,?,?,?), ON DUPLICATE KEY UPDATE PlayerID = VALUES(PlayerID), fieldID = VALUES(fieldID), Owner = VALUES(Owner),Houses = VALUES(Houses), Pawned = VALUES(Pawned));";

		try {

			prepstmt = c.getConnection().prepareStatement(updateOwnable);
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

					prepstmt.setInt(5, c.boolToInt(((Ownable) Board.getFields().get(i)).isPawned()));

				}
			}
			prepstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			prepstmt.close();
		}

	}
}
