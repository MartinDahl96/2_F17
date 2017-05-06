package sql;

import java.io.IOException;
import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;

import entities.Board;

import fieldEntities.Field;
import fieldEntities.Ownable;
import fieldEntities.Street;
import inputHandlers.Text;
import mainControllers.GameController;

public class FieldDAOimp implements IFieldDAO {
	
	//attributes
	private Connector c = new Connector();
	private PreparedStatement prepstmt;
	private ResultSet rs;
	private Text file = new Text("txtfiles/sql.txt");
	private String[] textList;

	/**
	 * Constructor for the FieldDataAccessObjectImplementation 
	 */
	public FieldDAOimp(){
		try {
			textList = file.OpenFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * used to get an ownable field's status from the database.
	 * @throws SQLException if no connection can be made.
	 */
	@Override
	public void getOwnable() throws SQLException { // Implementer
		String getOwnable = textList[16];
		rs = c.doQuery(getOwnable);

		while (rs.next()) {
			((Ownable) Board.getFields().get(rs.getInt(textList[17]))).setOwner(GameController.getPlayer(rs.getInt(textList[18])));
			((Ownable) Board.getFields().get(rs.getInt(textList[17]))).setPawned(rs.getBoolean(textList[19]));
		}
		rs.close();
	}
	
	
	/**
	 * used to get the amount of buildings on a street field in the database.
	 * @throws SQLException if no connection can be made.
	 */
	@Override
	public void getBuildingsOnStreet() throws SQLException{ //Implementer
		String ownedStreets = textList[20];
		rs = c.doQuery(ownedStreets);
		
		while(rs.next()){
			((Street) Board.getFields().get(rs.getInt(textList[17]))).setNumOfBuildings(rs.getInt(textList[21]));
		}
		rs.close();
	}

	/**
	 * used to update an ownable field's status in the database.
	 * @throws SQLException if no connection can be made.
	 */
	@Override
	public void updateOwnable() throws SQLException {
		String updateOwnableProcedure = textList[22];

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
		System.out.println(textList[23]);
	}

	/**
	 * used to insert an ownable field's status in the database.
	 * @throws SQLException if no connection can be made.
	 */
	@Override 
	public void insertOwnable() throws SQLException {
		String addOwnableProcedure = textList[24];

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
		System.out.println(textList[25]);
	}

}

