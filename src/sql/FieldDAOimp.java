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
	
	//attributes
	private Connector c = new Connector();
	private PreparedStatement prepstmt;
	private ResultSet rs;
	
	/**
	 * used to get an ownable field's status from the database.
	 * @throws SQLException if no connection can be made.
	 */
	@Override
	public void getOwnable() throws SQLException {
		String getOwnable = "SELECT * FROM ownedfields;";
		rs = c.doQuery(getOwnable);

		while (rs.next()) {
			((Ownable) Board.getFields().get(rs.getInt("fieldID"))).setOwner(GameController.getPlayer(rs.getInt("playerID")));
			((Ownable) Board.getFields().get(rs.getInt("fieldID"))).setPawned(rs.getBoolean("pawned"));
		}
		rs.close();
	}
	
	
	/**
	 * used to get the amount of buildings on a street field in the database.
	 * @throws SQLException if no connection can be made.
	 */
	@Override
	public void getBuildingsOnStreet() throws SQLException{ 
		String ownedStreets = "SELECT * FROM ownedstreets;";
		rs = c.doQuery(ownedStreets);
		
		while(rs.next()){
			((Street) Board.getFields().get(rs.getInt("fieldID"))).setNumOfBuildings(rs.getInt("houses"));
		}
		rs.close();
	}

	/**
	 * used to update an ownable field's status in the database.
	 * @throws SQLException if no connection can be made.
	 */
	@Override
	public void updateOwnable() throws SQLException {
		String updateOwnableProcedure = "call updateOwnable(?,?,?,?);";

		prepstmt = c.getConnection().prepareStatement(updateOwnableProcedure);
		for(Field f :Board.getFields()){
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
		System.out.println("ownable fields updated in database...");
	}

	/**
	 * used to insert an ownable field's status in the database.
	 * @throws SQLException if no connection can be made.
	 */
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

