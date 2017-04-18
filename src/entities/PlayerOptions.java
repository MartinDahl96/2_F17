package entities;

import java.util.ArrayList;

import desktop_resources.GUI;

public class PlayerOptions {
	
	Cup cup = new Cup();
	Board board = new Board();
	ArrayList <Player> players = new ArrayList <Player>();
	
	
	
	
	
	
	public void createPlayerOptions(Player player){
		
		String options = GUI.getUserSelection("Vælg dit næste træk", "1. Kast med terningerne","2. Sælg hus/hotel","3. Pantsæt","4. Køb pantsat tilbage","5. Afslut spil");
		int choice = Integer.parseInt(options.substring(0,1));
		
		switch(choice){
		case 1:
			throwDice(0);
			
			break;
		case 2:
			
			break;
		case 3:
			
			break;
		case 4:
			
			break;
		case 5:
			
			break;
			}
	}
	
	public void throwDice(int i){
		cup.useCup();
		GUI.setDice(cup.getFaceValue1(), cup.getFaceValue2());
		
		players.get(i).setCurrentPosition(cup.getCupValue());
		GUI.setCar(players.get(i).getCurrentPosition(), players.get(i).getplayerName());
		
		board.landOnField(players.get(i), players.get(i).getCurrentPosition());
		
		
		
		
		
	}

	
	public static void main(String[] args){
		ArrayList <Player> players = new ArrayList <Player>();
		
		p.createPlayerOptions(players.get(0).);
	}
}
