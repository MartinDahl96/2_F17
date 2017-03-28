package entities;

import desktop_resources.GUI;

public class Chance extends Field {
	

	public Chance(String fieldName, String fieldInfo) {
		super(fieldName, fieldInfo);

	}

	@Override
	public void landOnField(Player player) {
		
		player.setCurrentPosition(20);
		// TODO Auto-generated method stub
		
	}

}
