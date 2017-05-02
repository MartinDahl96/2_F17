package inputHandlers;

//FileScanner Queue

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class FileScannerQueue {

	private String path;
	private Queue<String> q;
	Scanner scan;

	public FileScannerQueue(String path) {
		this.path = path;
		this.q = new LinkedList<String>();
		this.scan = null;
		this.fillQueue();

	}

	public Queue fillQueue() {

		try {
			scan = new Scanner(new File(this.path)).useDelimiter(",");

			while (scan.hasNext()) {

				q.add(scan.next().trim());

			}

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

		return q;

	}

	public String poll() {
		return q.poll();

	}

	public int parseInt(String i) {
		return Integer.parseInt(i);
	}

}
