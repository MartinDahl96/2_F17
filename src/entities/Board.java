package entities;
import java.io.*;
import java.util.*;
public class Board {

	public ArrayList<Field> boardFields = new ArrayList<Field>();
	public void createBoard(){
		
		
		
		try{
			Scanner s = new Scanner(new File("fieldValues.txt")).useDelimiter(",");
			while(s.hasNextLine()){	
				//Start-field
				boardFields.add(new Start(Integer.parseInt(s.next()),s.next(),s.next(),Integer.parseInt(s.next())));
				s.nextLine();
				//Rødovrevej
				boardFields.add(new Street(Integer.parseInt(s.next()),s.next(),s.next(),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()), s.next()));
				s.nextLine();
				//Chance-field1
				boardFields.add(new Chance(Integer.parseInt(s.next()),s.next(),s.next()));
				s.nextLine();
				//Hvidovrevej
				boardFields.add(new Street(Integer.parseInt(s.next()),s.next(),s.next(),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()), s.next()));
				s.nextLine();
				//Tax-field1
				boardFields.add(new Tax(Integer.parseInt(s.next()),s.next(),s.next(),Integer.parseInt(s.next()),Double.parseDouble(s.next())));
				s.nextLine();
				//LB Færgerne
				boardFields.add(new Ferry(Integer.parseInt(s.next()),s.next(),s.next(),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next())));
				s.nextLine();
				//Roskildevej
				boardFields.add(new Street(Integer.parseInt(s.next()),s.next(),s.next(),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()), s.next()));
				s.nextLine();
				//Chance-field2
				boardFields.add(new Chance(Integer.parseInt(s.next()),s.next(),s.next()));
				s.nextLine();
				//Valby langgade
				boardFields.add(new Street(Integer.parseInt(s.next()),s.next(),s.next(),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()), s.next()));
				s.nextLine();
				//Allégade
				boardFields.add(new Street(Integer.parseInt(s.next()),s.next(),s.next(),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()), s.next()));
				s.nextLine();
				//Jail-field
				boardFields.add(new Jail(Integer.parseInt(s.next()),s.next(),s.next()));
				s.nextLine();
				//Frederiksberg Allé
				boardFields.add(new Street(Integer.parseInt(s.next()),s.next(),s.next(),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()), s.next()));
				s.nextLine();
				//Carlsberg
				boardFields.add(new Brewery(Integer.parseInt(s.next()),s.next(),s.next(),Integer.parseInt(s.next()),Integer.parseInt(s.next())));
				s.nextLine();
				//Bülowsvej
				boardFields.add(new Street(Integer.parseInt(s.next()),s.next(),s.next(),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()), s.next()));
				s.nextLine();
				//Gl. Kongevej
				boardFields.add(new Street(Integer.parseInt(s.next()),s.next(),s.next(),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()), s.next()));
				s.nextLine();
				//Danmark
				boardFields.add(new Ferry(Integer.parseInt(s.next()),s.next(),s.next(),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next())));
				s.nextLine();
				//Bernstorfsvej
				boardFields.add(new Street(Integer.parseInt(s.next()),s.next(),s.next(),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()), s.next()));
				s.nextLine();
				//Chance-field3
				boardFields.add(new Chance(Integer.parseInt(s.next()),s.next(),s.next()));
				s.nextLine();
				//Hellerupvej
				boardFields.add(new Street(Integer.parseInt(s.next()),s.next(),s.next(),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()), s.next()));
				s.nextLine();
				//Strandvej
				boardFields.add(new Street(Integer.parseInt(s.next()),s.next(),s.next(),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()), s.next()));
				s.nextLine();
				//Parking
				boardFields.add(new Parking(Integer.parseInt(s.next()),s.next(),s.next()));
				s.nextLine();
				//Trianglen
				boardFields.add(new Street(Integer.parseInt(s.next()),s.next(),s.next(),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()), s.next()));
				s.nextLine();
				//Chance-field4
				boardFields.add(new Chance(Integer.parseInt(s.next()),s.next(),s.next()));
				s.nextLine();
				//Østerbrogade
				boardFields.add(new Street(Integer.parseInt(s.next()),s.next(),s.next(),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()), s.next()));
				s.nextLine();
				//Grønningen
				boardFields.add(new Street(Integer.parseInt(s.next()),s.next(),s.next(),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()), s.next()));
				s.nextLine();
				//Mols-Linien
				boardFields.add(new Ferry(Integer.parseInt(s.next()),s.next(),s.next(),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next())));
				s.nextLine();
				//Bredgade
				boardFields.add(new Street(Integer.parseInt(s.next()),s.next(),s.next(),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()), s.next()));
				s.nextLine();
				//Kgs. Nytorv
				boardFields.add(new Street(Integer.parseInt(s.next()),s.next(),s.next(),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()), s.next()));
				s.nextLine();
				//Coca-cola
				boardFields.add(new Brewery(Integer.parseInt(s.next()),s.next(),s.next(),Integer.parseInt(s.next()),Integer.parseInt(s.next())));
				s.nextLine();
				//Østergade
				boardFields.add(new Street(Integer.parseInt(s.next()),s.next(),s.next(),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()), s.next()));
				s.nextLine();
				//Go to jail
				boardFields.add(new Jail(Integer.parseInt(s.next()),s.next(),s.next()));
				s.nextLine();
				//Amagertorv
				boardFields.add(new Street(Integer.parseInt(s.next()),s.next(),s.next(),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()), s.next()));
				s.nextLine();
				//Vimmelskaftet
				boardFields.add(new Street(Integer.parseInt(s.next()),s.next(),s.next(),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()), s.next()));
				s.nextLine();
				//Chance-field5
				boardFields.add(new Chance(Integer.parseInt(s.next()),s.next(),s.next()));
				s.nextLine();
				//Nygade
				boardFields.add(new Street(Integer.parseInt(s.next()),s.next(),s.next(),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()), s.next()));
				s.nextLine();
				//Skandinavisk Linietrafik A/S
				boardFields.add(new Ferry(Integer.parseInt(s.next()),s.next(),s.next(),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next())));
				s.nextLine();
				//Chance-field6
				boardFields.add(new Chance(Integer.parseInt(s.next()),s.next(),s.next()));
				s.nextLine();
				//Frederiksberggade
				boardFields.add(new Street(Integer.parseInt(s.next()),s.next(),s.next(),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()), s.next()));
				s.nextLine();
				//Tax-field2
				boardFields.add(new Tax(Integer.parseInt(s.next()),s.next(),s.next(),Integer.parseInt(s.next()),Integer.parseInt(s.next())));
				s.nextLine();
				//Rådhuspladsen
				boardFields.add(new Street(Integer.parseInt(s.next()),s.next(),s.next(),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()),Integer.parseInt(s.next()), s.next()));
				s.nextLine();
			
			}s.close();
			
		} 
			
			
			catch(FileNotFoundException e){
				e.printStackTrace();
				
			}	
		
	}
	
	public ArrayList<Field> getFieldsArray(){
		return boardFields;
	}
	
	
	public static void main (String[] args){
		
		Board b = new Board();
		b.createBoard();
		
		for (Field field : b.boardFields){
			System.out.println(field);
		}
		
	}
	
}



