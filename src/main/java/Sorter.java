package main.java;

import java.io.FileNotFoundException;
import java.util.List;

public class Sorter {

	public Sorter() {
	}

	public static void main(String[] args) {
		ReadTasks taskReader = new ReadTasks(
				"C:\\Users\\Mya\\eclipse-workspace\\Sorting\\src\\main\\resources\\Tasks.txt");
		try {
			List<Task> tasks = taskReader.getTasks();
			FirstComeFirstServe.fcfsSort(tasks);
			ShortestJobFirst.sort(tasks);
			PriorityScheduling.priorityScheduling(new Task [tasks.size()], tasks.size());

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
