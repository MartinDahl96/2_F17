package sql;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import entities.Board;
import entities.Player;
import fieldControllers.ChanceController;
import fieldEntities.Ownable;
import fieldEntities.Street;
import mainControllers.GameController;

public class DTOimp implements IFieldDAO {
	private Connector c = new Connector();
	private PreparedStatement prepstmt;
	

	@Override
	public void removePlayer(int playerID) throws SQLException {
		String updateField = "DELETE * FROM matador.Ownable WHERE Owner = ?;";
		String updatePlayer = "DELETE * FROM matador.Player WHERE playerID = ?;";
				
		try{
			
			prepstmt = c.getConnection().prepareStatement(updatePlayer);
			prepstmt.setInt(1, playerID);
			prepstmt.executeUpdate();
			
			
			prepstmt = c.getConnection().prepareStatement(updateField);
			prepstmt.setInt(1, playerID);
			prepstmt.executeUpdate();
			
		}catch (SQLException e){
			e.printStackTrace();
		}
		finally {
			prepstmt.close();
		}
	}

	@Override
	public void updatePlayer(int playerID) throws SQLException {
		Player p = GameController.getPlayer(playerID);
	String updatePlayer = "INSERT INTO matador.Player (playerID, playerName, fortune, immunity, totalAssets, ownedFerries, ownedBreweries, jailRounds, jailToken, currentPosition) VALUES (?,?,?,?,?,?,?,?,?,?) ON DUPLICATE KEY UPDATE playerID = VALUES(playerID), playerName = VALUES(playerName), fortune = VALUES(fortune), immunity = VALUES(immunity), totalAssets = VALUES(totalAssets), ownedFerries = VALUES(ownedFerries), ownedBreweries = VALUES(ownedBreweries), jailRounds = VALUES(jailRounds), jailToken = VALUES(jailToken), currentPosition = VALUES(currentPosition);";
		
		try {
			prepstmt = c.getConnection().prepareStatement(updatePlayer);
			prepstmt.setInt(1, p.getPlayerID());
			prepstmt.setString(2, p.getplayerName());
			prepstmt.setInt(3, p.getFortune());
			prepstmt.setBoolean(4, p.getImmunity());
			prepstmt.setInt(5, p.getTotalAssets());
			prepstmt.setInt(6, p.getOwnedFerries());
			prepstmt.setInt(7, p.getOwnedBreweries());
			prepstmt.setInt(8, p.getJailRounds());
			prepstmt.setInt(9, p.getJailToken());
			prepstmt.setInt(10, p.getCurrentPosition());
			prepstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
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
					if (((Ownable) Board.getFields().get(i)).getOwner() == GameController.getPlayer(playerID));
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

	@Override
	public void updateChanceCard(int cardID, String cardText, int cardValue) throws SQLException {
		String updateChanceCard = "INSERT INTO matador.ChanceDeck (cardID, cardText, cardValue) VALUES (?,?,?) \n" +
									"ON DUPLICATE KEY UPDATE cardID = VALUES(cardID), cardText = VALUES(cardText), cardValue = VALUES(cardValue)";
		
		ChanceController cc = new ChanceController(null);
		try{

			prepstmt = c.getConnection().prepareStatement(updateChanceCard);
	
			for (int i = 1 ; i <= cc.sizeOfStack() ; i++){
				prepstmt.setInt(1, cc.deck.getDeck().get(i).getCardID());
				prepstmt.setString(2, cc.deck.getDeck().get(i).getCardText());
				prepstmt.setInt(3, cc.deck.getDeck().get(i).getCardValue());
			}
				prepstmt.executeUpdate();
		} catch(SQLException e){
			e.printStackTrace();
		}finally {
			prepstmt.close();
		}
		
	}

	public void saveGame(int playerID) throws SQLException {
		updatePlayer(playerID);
//		updateOwnable(playerID);
		}
}
