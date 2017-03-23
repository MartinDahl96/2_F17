package entities;

public class Parking extends Field {

	public Parking(String fieldName, String fieldInfo) {
		super(fieldName, fieldInfo);

	}

	@Override
	public void landOnField(Player player) {

		while (player.getCurrentPosition() == 21) {
			player.immunity = true;
			player.setFortune(2000);

		}

	}

}
