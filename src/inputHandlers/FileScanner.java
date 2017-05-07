package inputHandlers;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileScanner {

	//attributes
	private String path;
	private int numOfFields;
	private String[] value;

	/**
	 * Constructor for the FileScanner.
	 * @param path is the location of the file.
	 */
	public FileScanner(String path) {
		this.path = path;
		this.numOfFields = 0;
		this.value = null;

	}

	/**
	 * used to count the lines in a file, with the delimiter ",".
	 * @return numOfFields is the amount of lines in the file.
	 * @throws FileNotFoundException in case the file is not found.
	 */
	public int readLines() throws FileNotFoundException {

		Scanner scan = new Scanner(new File(this.path)).useDelimiter(",");

		while (scan.hasNext()) {

			numOfFields++;
			scan.next();
		}

		return numOfFields;
	}

	/**
	 * used to scan the file and save the information read.
	 * @return value is the read information.
	 * @throws FileNotFoundException in case the file is not found.
	 */
	public String[] openFile() throws FileNotFoundException {

		readLines();
		setValueArray(this.numOfFields);

		Scanner scan = new Scanner(new File(this.path)).useDelimiter(",");

		this.value = new String[numOfFields];

		for (int i = 0; i < numOfFields; i++) {
			value[i] = scan.next();

		}

		return value;

	}

	/**
	 * used to parse a string to an integer.
	 * @param i is the string to parse.
	 * @return is the string parsed to an integer.
	 */
	public int parseInt(String i) {
		return Integer.parseInt(i);
	}

	/**
	 * used to insert a value to an index in the array.
	 * @param i is the index
	 * @return value is the value inserted.
	 */
	public String[] setValueArray(int i) {
		return this.value = new String[i];
	}

	/**
	 * used to get the value at an index in the array.
	 * @param i is the index
	 * @return value is the value stored in the array.
	 */
	public String getValue(int i) {
		return value[i];
	}

}
