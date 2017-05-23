package inputHandlers;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class FileScannerQueue {

	//attributes
	private String path;
	private Queue<String> q;
	Scanner scan;

	/**
	 * constructor for FileScannerQueue
	 * @param path is the location of the file.
	 */
	public FileScannerQueue(String path) {
		this.path = path;
		this.q = new LinkedList<String>();
		this.scan = null;
		this.fillQueue();

	}

	/**
	 * used to fill the queue
	 * @return q is the queue.
	 */
	public Queue<String> fillQueue() {

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

	/**
	 * used to poll elements in the queue.
	 * @return the polled element.
	 */
	public String poll() {
		return q.poll();

	}

	/**
	 * used to parse a string into an int.
	 * @param i is the string to parse
	 * @return is the parsed int.
	 */
	public int parseInt(String i) {
		return Integer.parseInt(i);
	}

}
