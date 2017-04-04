package entities;
import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class Board {

	public ArrayList<Field> boardFields = new ArrayList<Field>();
	
	
	
	
	
	
	
	public void createBoard(){
		
		
		
		try{
			
			
		
			Scanner s = new Scanner(new File("fieldValues.txt")).useDelimiter(",");
	
		
			
			while(s.hasNextLine()){
				
			
				
				boardFields.add(new Start(Integer.parseInt(s.next()),s.next(),s.next(),Integer.parseInt(s.next())));
				s.nextLine();
				boardFields.add(new Start(Integer.parseInt(s.next()),s.next(),s.next(),Integer.parseInt(s.next())));

				
				
	
	
	
	
	
	
	
				
			}s.close();}
			
			
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



