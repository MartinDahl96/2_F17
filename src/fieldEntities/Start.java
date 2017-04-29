 package fieldEntities;

import java.util.Scanner;

//Start class

import entities.Player;
import fieldControllers.StartController;

public class Start extends Field {

	// Attributes

	private int startBonus;
	private StartController s;

	/**
	 * A constructor for the Start field, used to create a Tax object
	 * 
	 * @param fieldName
	 *            Determines the name of the field
	 * @param fieldInfo
	 *            Describes the field
	 * @param startBonus
	 *            Adds 4000 to the players account when landing or passing this
	 *            field
	 */
	public Start(int fieldID, String fieldName, String fieldInfo, int startBonus) {
		super(fieldID, fieldName, fieldInfo);
		this.startBonus = startBonus;
		this.s = new StartController(this);

	}
	
	public int getStartBonus(){
		return this.startBonus;
	}

	@Override
	public String toString() {
		return super.toString() + ", value=" + this.startBonus;
	}
	/**
	 * toString method
	 */

	@Override
	public void landOnField(Player player) {
		s.landOnStart(player);
		
	}

}
