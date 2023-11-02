package main.java;

import java.util.Arrays;
import java.util.Comparator;

public class PriorityScheduling {

	public PriorityScheduling() {
	}

	public static void priorityScheduling(Task task[], int n) {

		// Sort processes by priority
		Arrays.sort(task, new Comparator<Task>() {
			@Override
			public int compare(Task a, Task b) {
				return b.getPriority() - a.getPriority();
			}
		});
		System.out.print("Order in which processes gets executed \n");
		for (int i = 0; i < n; i++)
			System.out.print(task[i].getName() + " ");

		findavgTime(task, n);
	}

	public static void main(String[] args) {
		int n = 3;
		Task task[] = new Task[n];
		task[0] = new Task("T1", 10, 2, 1);
		task[1] = new Task("T2", 5, 0, 2);
		task[2] = new Task("T3", 8, 1, 3);
		priorityScheduling(task, n);
	}

	public static void findavgTime(Task task[], int n) {
		int wt[] = new int[n], tat[] = new int[n], total_wt = 0, total_tat = 0;

		findWaitingTime(task, n, wt);

		findTurnAroundTime(task, n, wt, tat);

		System.out.print("\nProcesses   Burst time   Waiting time   Turn around time Priority\n");

		for (int i = 0; i < n; i++) {
			total_wt = total_wt + wt[i];
			total_tat = total_tat + tat[i];
			System.out.print(
					" " + task[i].getName() + "\t\t" + task[i].getBurst() + "\t " + wt[i] + "\t\t " + tat[i] + "\t\t " + task[i].getPriority() + "\n");
		}

		System.out.print("\nAverage waiting time = " + (float) total_wt / (float) n);
		System.out.print("\nAverage turn around time = " + (float) total_tat / (float) n);
	}

	public static void findWaitingTime(Task task[], int n, int wt[]) {
		wt[0] = 0;
		for (int i = 1; i < n; i++)
			wt[i] = task[i - 1].getBurst() + wt[i - 1];
	}

	public static void findTurnAroundTime(Task task[], int n, int wt[], int tat[]) {
		for (int i = 0; i < n; i++)
			tat[i] = task[i].getBurst() + wt[i];
	}
}
