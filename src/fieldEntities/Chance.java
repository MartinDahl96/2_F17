package fieldEntities;

//Chance class

import entities.ChanceDeck;
import entities.Player;
import fieldControllers.ChanceController;
import mainControllers.MUI;

public class Chance extends Field {

	/*
	 * The chancefield constructor.
	 */
	
	ChanceController c;
	
	public Chance(int fieldID, String fieldName, String fieldInfo) {
		super(fieldID, fieldName, fieldInfo);
		this.c = new ChanceController(this);
	}

	@Override
	public void landOnField(Player player) {
		
		c.landOnChance(player);
	}

}