package mainControllers;
import entities.Player;
import desktop_resources.GUI;
import entities.Board;
import fieldEntities.Field;
import fieldEntities.Ownable;
import fieldEntities.Street;

public class Rule {

	//attributes
	Board b = new Board();
	private int total;

	/**
	 * Calculates and sets the player's total assets; fortune + value of properties and buildings.
	 * @param player is the player to be calculated.
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
	
public void removeOwner(Player p){
		
		if(p.isBankRupt()){
			for(Field f: Board.getFields()){
				if( f instanceof Ownable && ((Ownable) f).getOwner() == p){
					((Ownable)f).setOwner(null);
					MUI.removeOwner(f.getFieldID());
					
				}
				
			}
		}
		
		
	}

public void assignOwner(Player p){

	for(Field f: Board.getFields()){
		if(f instanceof Ownable && ((Ownable) f).getOwner() == p){
			MUI.setOwner(f.getFieldID(), p.getplayerName());
			
			}
		}
	}

public void placeHouses(Player p){

	for(Field f: Board.getFields()){
		if(f instanceof Street && ((Street) f).getOwner() == p){
			if(((Street) f).getNumOfBuildings() < 5){
				MUI.SetHouses(f.getFieldID(), ((Street) f).getNumOfBuildings());
			}
			else if(((Street) f).getNumOfBuildings() == 5){
				MUI.setHotel(f.getFieldID(), true);
			}
			
			}
		}
	}

}





