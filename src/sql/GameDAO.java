package sql;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;

import inputHandlers.Text;

public class GameDAO {
	
	private Connector c = new Connector();
	private PlayerDAOimp pDAO = new PlayerDAOimp();
	private FieldDAOimp fDAO = new FieldDAOimp();
	private ChanceDAOimp cDAO = new ChanceDAOimp();
	private Text file = new Text("txtfiles/sql.txt");
	private String[] textList;

	/**
	 * Constructor for the GameDataAccessObjectImplementation 
	 */
	public GameDAO(){
		try {
			textList = file.OpenFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void loadGame(){
		try {
			pDAO.getPlayers();
			pDAO.getOwnedBreweries();
			pDAO.getOwnedFerries();
			fDAO.getOwnable();
			fDAO.getBuildingsOnStreet();
			cDAO.getChanceCards();
			
		} catch (SQLException e) {
			
		}
	}

	public void saveGame() {
		try {
			pDAO.insertPlayer();
			fDAO.insertOwnable();
			cDAO.insertCards();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateSave() {
		try {
			pDAO.updatePlayer();
			fDAO.updateOwnable();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void newGame(){
		String resetTables = textList[26];
		try {
			Statement stmt = c.getConnection().createStatement();
			stmt.executeUpdate(resetTables);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(textList[27]);
	}
}

