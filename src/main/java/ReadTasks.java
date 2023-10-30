package main.java;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadTasks {
	String fileName;

	public ReadTasks(String inFileName) {
		fileName = inFileName;
	}

	public List<Task> getTasks() throws FileNotFoundException {
		ArrayList<Task> tasks = new ArrayList();
		int count = 0;
		File fileNames = new File(fileName);
		Scanner scFilesNames = new Scanner(fileNames);
		while (scFilesNames.hasNext()) {
			String name = scFilesNames.next();
			int priority = scFilesNames.nextInt();
			int burst = scFilesNames.nextInt();
			System.out.println("Name " + name);
			System.out.println("Priority " + priority);
			System.out.println("Burst " + burst);
			Task task = new Task(name, priority, burst, count++);
			count++;
			tasks.add(task);
		}
		return tasks;
	}

}
