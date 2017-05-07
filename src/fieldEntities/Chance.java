package fieldEntities;

//Chance class

import entities.Player;
import fieldControllers.ChanceController;


public class Chance extends Field {

	
	//attributes
	ChanceController c;
	
	/**
	 * Constructor for a Chance field.
	 * @param fieldID is the position on the board.
	 * @param fieldName is the name of the field.
	 * @param fieldInfo is the text displayed on the field.
	 */
	public Chance(int fieldID, String fieldName, String fieldInfo) {
		super(fieldID, fieldName, fieldInfo);
		this.c = new ChanceController(this);
	}

	/**
	 * landOnField-method for a chance-field.
	 * Inherited from Field.
	 */
	@Override
	public void landOnField(Player player) {
		c.landOnChance(player);
		
		}
	}
