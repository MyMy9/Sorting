package main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ShortestJobFirst {

	public ShortestJobFirst() {
		// TODO Auto-generated constructor stub
	}

	public static void sort(List<Task> inTasks) {
		Task[] tasks = new Task[inTasks.size()];
		inTasks.toArray(tasks);
		int n = tasks.length;

		int total = 0;
		float avg_wt, avg_tat;
		for (int i = 0; i < n - 1; i++) {
			// Find the minimum element in unsorted array
			int min_idx = i;
			for (int j = i + 1; j < n; j++)
				if (tasks[j].getBurst() < tasks[min_idx].getBurst())
					min_idx = j;

			// Swap the found minimum element with the first
			// element
			Task temp = tasks[min_idx];
			tasks[min_idx] = tasks[i];
			tasks[i] = temp;
		}

		List<Task> sortedTasks = Arrays.asList(tasks);
		findWaitingTime(sortedTasks);

		for (Task task : sortedTasks) {
			total += task.getWaitTime();
		}

		avg_wt = (float) total / n;
		total = 0;
		// Calculation of Turn Around Time and printing the
		// data.
		System.out.println("P\tBT\tWT\tTAT");
		for (Task task : sortedTasks) {
			total += getTurnAroundTime(task);

			System.out.println(task.getName() + "\t" + task.getBurst() + "\t" + task.getWaitTime() + "\t"
					+ getTurnAroundTime(task));
		}
		avg_tat = (float) total / n;
		System.out.println("Average Waiting Time= " + avg_wt);
		System.out.println("Average Turnaround Time= " + avg_tat);
	}

	private static void findWaitingTime(List<Task> tasks) {

		for (int i = 1; i < tasks.size(); i++) {
			tasks.get(i).setWaitTime(tasks.get(i - 1).getBurst() + tasks.get(i - 1).getWaitTime());
		}
	}

	private static int getTurnAroundTime(Task task) {
		return task.getBurst() + task.getWaitTime();
	}

}
