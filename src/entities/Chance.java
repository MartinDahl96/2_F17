package entities;

import controllers.MUI;

public class Chance extends Field {
	private ChanceDeck c = new ChanceDeck();
	/*
	 * The chancefield constructor.
	 */
	public Chance(int fieldID,String fieldName, String fieldInfo) {
		super(fieldID,fieldName, fieldInfo);

	}

	/*
	 * The landOnField method for a chancefield.
	 * When a player lands on this field the player will draw a chancecard from the cardstack, 
	 * The player will then be affected by the card.
	 */
	@Override
	public void landOnField(Player player) {

		c.drawCard(player);
		
	}

}
