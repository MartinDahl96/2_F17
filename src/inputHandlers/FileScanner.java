 package inputHandlers;

//Filescanner

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileScanner {

	private String path;
	private int numOfFields;
	private String[] value;

	public FileScanner(String path) {
		this.path = path;
		this.numOfFields = 0;
		this.value = null;

	}

	public int readLines() throws FileNotFoundException {

		Scanner scan = new Scanner(new File(this.path)).useDelimiter(",");

		while (scan.hasNext()) {

			numOfFields++;
			scan.next();
		}

		return numOfFields;
	}

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

	public int parseInt(String i) {
		return Integer.parseInt(i);
	}

	public String[] setValueArray(int i) {
		return this.value = new String[i];
	}

	public String getValue(int i) {
		return value[i];
	}

}
