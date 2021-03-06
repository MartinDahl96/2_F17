package entities;
import java.io.*;

import java.util.*;
import fieldEntities.Brewery;
import fieldEntities.Chance;
import fieldEntities.Ferry;
import fieldEntities.Field;
import fieldEntities.Jail;
import fieldEntities.Ownable;
import fieldEntities.Parking;
import fieldEntities.Start;
import fieldEntities.Street;
import fieldEntities.Tax;
import inputHandlers.FileScannerQueue;
//
public class Board {
	private static ArrayList<Field> boardFields;
	FileScannerQueue s;
	
	/**
	 * Constructor for the Board-class.
	 * This constructor creates an ArrayList containing fields, and creates a new FileScannerQueue, and scans the file called "fieldValues" for values.
	 * These values are then used in the method for creating a board, createBoard.
	 */
	public Board(){
		
		boardFields = new ArrayList<Field>();
		this.s = new FileScannerQueue("txtfiles/fieldValues.txt");
		this.createBoard();
	}

	/**
	 * Method for creating a board. The values are gathered from the scanner queue.
	 */
	public void createBoard(){
		
		
				//Empty field for index 0.
				boardFields.add(null);
				
				//Start-field
				boardFields.add(new Start(s.parseInt(s.poll()),s.poll(),s.poll(),s.parseInt(s.poll())));
				 
				//Rřdovrevej
				boardFields.add(new Street(s.parseInt(s.poll()),s.poll(),s.poll(),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()), s.poll()));
				 
				//3Chance-field1
				boardFields.add(new Chance(s.parseInt(s.poll()),s.poll(),s.poll()));
				 
				//Hvidovrevej
				boardFields.add(new Street(s.parseInt(s.poll()),s.poll(),s.poll(),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()), s.poll()));
				 
				//Tax-field1
				boardFields.add(new Tax(s.parseInt(s.poll()),s.poll(),s.poll(),s.parseInt(s.poll()),Double.parseDouble(s.poll())));
				 
				//LB Fćrgerne
				boardFields.add(new Ferry(s.parseInt(s.poll()),s.poll(),s.poll(),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll())));
				 
				//Roskildevej
				boardFields.add(new Street(s.parseInt(s.poll()),s.poll(),s.poll(),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()), s.poll()));
				 
				//Chance-field2
				boardFields.add(new Chance(s.parseInt(s.poll()),s.poll(),s.poll()));
				 
				//Valby langgade
				boardFields.add(new Street(s.parseInt(s.poll()),s.poll(),s.poll(),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()), s.poll()));
				 
				//Allégade
				boardFields.add(new Street(s.parseInt(s.poll()),s.poll(),s.poll(),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()), s.poll()));
				 
				//Jail-field
				boardFields.add(new Jail(s.parseInt(s.poll()),s.poll(),s.poll()));
				 
				//Frederiksberg Allé
				boardFields.add(new Street(s.parseInt(s.poll()),s.poll(),s.poll(),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()), s.poll()));
				 
				//Carlsberg
				boardFields.add(new Brewery(s.parseInt(s.poll()),s.poll(),s.poll(),s.parseInt(s.poll()),s.parseInt(s.poll())));
				 
				//Bülowsvej
				boardFields.add(new Street(s.parseInt(s.poll()),s.poll(),s.poll(),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()), s.poll()));
				 
				//Gl. Kongevej
				boardFields.add(new Street(s.parseInt(s.poll()),s.poll(),s.poll(),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()), s.poll()));
				 
				//Danmark
				boardFields.add(new Ferry(s.parseInt(s.poll()),s.poll(),s.poll(),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll())));
				 
				//Bernstorfsvej
				boardFields.add(new Street(s.parseInt(s.poll()),s.poll(),s.poll(),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()), s.poll()));
				 
				//Chance-field3
				boardFields.add(new Chance(s.parseInt(s.poll()),s.poll(),s.poll()));
				 
				//Hellerupvej
				boardFields.add(new Street(s.parseInt(s.poll()),s.poll(),s.poll(),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()), s.poll()));
				 
				//Strandvej
				boardFields.add(new Street(s.parseInt(s.poll()),s.poll(),s.poll(),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()), s.poll()));
				 
				//Parking
				boardFields.add(new Parking(s.parseInt(s.poll()),s.poll(),s.poll(),s.parseInt(s.poll())));
				 
				//Trianglen
				boardFields.add(new Street(s.parseInt(s.poll()),s.poll(),s.poll(),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()), s.poll()));
				 
				//Chance-field4
				boardFields.add(new Chance(s.parseInt(s.poll()),s.poll(),s.poll()));
				 
				//Řsterbrogade
				boardFields.add(new Street(s.parseInt(s.poll()),s.poll(),s.poll(),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()), s.poll()));
				 
				//Grřnningen
				boardFields.add(new Street(s.parseInt(s.poll()),s.poll(),s.poll(),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()), s.poll()));
				 
				//Mols-Linien
				boardFields.add(new Ferry(s.parseInt(s.poll()),s.poll(),s.poll(),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll())));
				 
				//Bredgade
				boardFields.add(new Street(s.parseInt(s.poll()),s.poll(),s.poll(),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()), s.poll()));
				 
				//Kgs. Nytorv
				boardFields.add(new Street(s.parseInt(s.poll()),s.poll(),s.poll(),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()), s.poll()));
				 
				//Coca-cola
				boardFields.add(new Brewery(s.parseInt(s.poll()),s.poll(),s.poll(),s.parseInt(s.poll()),s.parseInt(s.poll())));
				 
				//Řstergade
				boardFields.add(new Street(s.parseInt(s.poll()),s.poll(),s.poll(),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()), s.poll()));
				 
				//Go to jail
				boardFields.add(new Jail(s.parseInt(s.poll()),s.poll(),s.poll()));
				 
				//Amagertorv
				boardFields.add(new Street(s.parseInt(s.poll()),s.poll(),s.poll(),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()), s.poll()));
				 
				//Vimmelskaftet
				boardFields.add(new Street(s.parseInt(s.poll()),s.poll(),s.poll(),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()), s.poll()));
				 
				//Chance-field5
				boardFields.add(new Chance(s.parseInt(s.poll()),s.poll(),s.poll()));
				 
				//Nygade
				boardFields.add(new Street(s.parseInt(s.poll()),s.poll(),s.poll(),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()), s.poll()));
				 
				//Skandinavisk Linietrafik A/S
				boardFields.add(new Ferry(s.parseInt(s.poll()),s.poll(),s.poll(),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll())));
				 
				//Chance-field6
				boardFields.add(new Chance(s.parseInt(s.poll()),s.poll(),s.poll()));
				 
				//Frederiksberggade
				boardFields.add(new Street(s.parseInt(s.poll()),s.poll(),s.poll(),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()), s.poll()));
				 
				//Tax-field2
				boardFields.add(new Tax(s.parseInt(s.poll()),s.poll(),s.poll(),s.parseInt(s.poll()),s.parseInt(s.poll())));
				 
				//Rĺdhuspladsen
				boardFields.add(new Street(s.parseInt(s.poll()),s.poll(),s.poll(),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()),s.parseInt(s.poll()), s.poll()));
				 
			
			}
	
	/**
	 * Method for returning all the boards.
	 * @return boardFields - all the fields on the board.
	 */
	public static ArrayList<Field> getFields(){
		return boardFields;
	}
	
	/**
	 * landOnField method for the fields.
	 * @param player is the player landing of the field.
	 */
	public void landOnField(Player player) {
		int playerPosition = player.getCurrentPosition();
		
		boardFields.get(playerPosition).landOnField(player);
		
		if(player.getCurrentPosition() != playerPosition){
			landOnField(player);
		}
	
	}

}

