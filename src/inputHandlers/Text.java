package inputHandlers;
import java.io.*;

//Text reader

import java.util.Scanner;

public class Text {

	//attributes
	private String path;
	
	/**
	 * Constructor for Text
	 * @param filePath is the location of the file.
	 */
	public Text(String filePath)
	{
		path = filePath;
	}
	
	
	/**
	 * Counts the lines in a file and returns the amount of lines contained in that file as an integer.
	 * @return The amount of lines contained in the file as an integer.
	 * @throws IOException in case the file is not found.
	 */
	public int readLines() throws IOException
	{
		FileReader readFile = new FileReader(path);
		BufferedReader buffReader = new BufferedReader(readFile);
		
		int amountOfLines = 0;
		
		while((buffReader.readLine()) != null)
		{
		amountOfLines++;	
		}
		
		buffReader.close();
		
		return amountOfLines;
	}
	
	
	/**
	 * Tries to open a text file and reads it line by line. It will then save each line into a separate index in an array.
	 * @return The array of lines in the file.
	 * @throws IOException in case the file is not found.
	 */
	
	public String[] OpenFile() throws IOException
	{
		FileReader fileReader = new FileReader(path);
		BufferedReader textReader = new BufferedReader(fileReader);
		
		int amountOfLines = readLines();
		
		String [] textList = new String[amountOfLines];
		
		for(int i = 0 ; i < amountOfLines ; i++)
		{
			textList[i] = textReader.readLine();
		}
		textReader.close();
		
		return textList;
	}
	
}

