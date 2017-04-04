package entities;

public class Chance extends Field {
	
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
		
		player.setCurrentPosition(20);
		// TODO Auto-generated method stub
		
	}

}
