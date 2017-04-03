package entities;

public class Parking extends Field {

	/**
	 * Constructor of the Parking-field.
	 * @param fieldName used as the name of the field.
	 * @param fieldInfo used to give information about the field.
	 */
	public Parking(int fieldID, String fieldName, String fieldInfo) {
		super(fieldID, fieldName, fieldInfo);

	}

	/**
	 * landOnField method for the Parking-field.
	 * The player will become immune to impacts to his fortune.
	 * Grants the player 2000 kr. as well.
	 */
	@Override
	public void landOnField(Player player) {

		while (player.getCurrentPosition() == 21) {
			player.immunity = true;
			player.setFortune(2000);

		}

	}

}
