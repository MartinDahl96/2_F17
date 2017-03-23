package entities;

public class Jail extends Field {

	public Jail(String fieldName, String fieldInfo) {
		super(fieldName, fieldInfo);
		
	}

	@Override
	public void landOnField(Player player) {
		
		Cup cup = new Cup();
		
		if(player.getJailRounds() > 0){		
		}
			
		if(player.getCurrentPosition() == 31){
			player.setCurrentPosition(-20);
			player.setJailRounds(3);
		}
		
		
	}
	
	
	
	
}
