package entities;

import java.io.FileNotFoundException;
import java.io.File;
import java.util.*;

public class ChanceDeck {
	
	
	//TODO clone the post shuffle array
	//     Make a way to get the  ID:
	//     Assign a value to the ID based on information from the file.

	public static void main(String[] args) throws FileNotFoundException {
		Scanner s = new Scanner(new File("test")); // scanner that reads from a file and saves to an array.
		s.useDelimiter("/"); // sets up a specific notation as a delimiter for determining the next array slot
		ArrayList<String> list = new ArrayList<String>(); // creates an arrayList called list
		
		while (s.hasNext()){ // sets up the read files strings to be placed in a new slot once the line ends
		  list.add(s.next());
		  		
			Collections.shuffle(list); // Shuffles the list randomly
						    
		}
		s.close(); // closes the scanner
		Stack<String> chanceCardStack = new Stack<String>(); // Creates a Stack and names it
		chanceCardStack.addAll(list); // Copies the ArrayList to the Stack
		System.out.println(chanceCardStack); // Prints out text.
		
		}
}