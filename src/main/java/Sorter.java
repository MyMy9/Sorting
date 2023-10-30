package main.java;

import java.io.FileNotFoundException;

public class Sorter {

	public Sorter() {
	}

	public static void main(String[] args) {
		ReadTasks taskReader = new ReadTasks(
				"C:\\Users\\Myles\\eclipse-workspace\\Sorting\\src\\main\\resources\\Tasks.txt");
		try {
			taskReader.getTasks();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
