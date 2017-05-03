package mainControllers;
import entities.Player;
import entities.Board;
import fieldEntities.Field;
import fieldEntities.Ownable;
import fieldEntities.Street;

public class Rule {


	Board b = new Board();
	private int total;

	/**
	 * Calculates and sets the player's total assets; fortune + value of properties and buildings.
	 * @param player
	 */
	public void calcTotalAssets(Player player){

		for (Field field : Board.getFields()){
			if (field instanceof Ownable && ((Ownable) field).getOwner() == player){
				total += (((Ownable) field).getPrice())/2;

				if (field instanceof Street && ((Street)field).getNumOfBuildings()>0){
					total += ((((Street) field).getBuildPrice())/2)*((Street)field).getNumOfBuildings();
				}
			}

		}

		player.setTotalAssets(total+player.getFortune());
	}
}

