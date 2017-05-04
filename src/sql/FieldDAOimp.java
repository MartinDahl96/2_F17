package sql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entities.Board;
import fieldEntities.Field;
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
	public void updateOwnable() throws SQLException {
		String updateOwnableProcedure = "call updateOwnable(?,?,?,?);";

		prepstmt = c.getConnection().prepareStatement(updateOwnableProcedure);
		for(Field f :Board.getFields()){
			if(f instanceof Ownable){
				if(f instanceof Ownable){
					prepstmt.setInt(1, f.getFieldID());
					if(((Ownable) f).getOwner()!=null)prepstmt.setInt(2, ((Ownable) f).getOwner().getPlayerID());
					else prepstmt.setNull(2, java.sql.Types.NULL);
					if(f instanceof Street) prepstmt.setInt(3, ((Street) f).getNumOfBuildings());
					else prepstmt.setInt(3, 0);
					prepstmt.setBoolean(4, ((Ownable) f).isPawned());
					prepstmt.executeUpdate();
				}
			}	
		}
		System.out.println("ownable fields updated in database");
	}

	@Override 
	public void insertOwnable() throws SQLException {
		String addOwnableProcedure = "call addOwnable(?,?,?);";

		prepstmt = c.getConnection().prepareStatement(addOwnableProcedure);
		for(Field f :Board.getFields()){
			if(f instanceof Ownable){
				prepstmt.setInt(1, f.getFieldID());
				if(f instanceof Street) prepstmt.setInt(2, ((Street) f).getNumOfBuildings());
				else prepstmt.setInt(2, 0);
				prepstmt.setBoolean(3, ((Ownable) f).isPawned());
				prepstmt.executeUpdate();
			}
		}
		System.out.println("ownable fields added to database");
	}

}
