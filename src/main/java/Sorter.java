package main.java;

import java.io.FileNotFoundException;
import java.util.List;

public class Sorter {

	public Sorter() {
	}

	public static void main(String[] args) {
		ReadTasks taskReader = new ReadTasks(
				"C:\\Users\\Myles\\eclipse-workspace\\Sorting\\src\\main\\resources\\Tasks.txt");
		try {
			List<Task> tasks = taskReader.getTasks();
			FirstComeFirstServe.fcfsSort(tasks);
			ShortestJobFirst.sort(tasks);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
