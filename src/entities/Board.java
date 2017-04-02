package entities;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class Board {

	public ArrayList<Field> boardFields = new ArrayList<Field>();
	
	
	
	
	public void createBoard(){
		
		try{
		
			Scanner s = new Scanner(new File("fieldValues.txt"));
			s.useDelimiter(",");
			
			int tempID = 0;
			
			while(s.hasNext()){
				
				boardFields.add(new Start(++tempID,s.next(),s.next(),Integer.parseInt(s.next())));
				
				
				
			}}
			
			
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
		
		System.out.println(b.getFieldsArray());
		
	}
	
}



