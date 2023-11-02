package main.java;

import java.util.List;

public class RoundRobin {

	public RoundRobin() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String args[]) {
		int i, qt, count = 0, temp, sq = 0, bt[], wt[], rem_bt[];
		float awt = 0, atat = 0;

		int s = 3;
		Task task[] = new Task[s];
		task[0] = new Task("T1", 10, 2, 1);
		task[1] = new Task("T2", 5, 3, 2);
		task[2] = new Task("T3", 8, 1, 3);
		rem_bt = new int[10];

		int tat[] = new int[s];

		for (i = 0; i < s; i++) {
			System.out.print("P" + i + " = ");
			rem_bt[i] = task[i].getBurst();
		}

		System.out.print("Enter the quantum time: ");
		qt = 2;
		while (true) {
			for (i = 0, count = 0; i < s; i++) {
				Task tsk = task[i];
				temp = qt;
				if (rem_bt[i] == 0) {
					count++;
					continue;
				}
				if (rem_bt[i] > qt)
					rem_bt[i] = rem_bt[i] - qt;
				else if (rem_bt[i] >= 0) {
					temp = rem_bt[i];
					rem_bt[i] = 0;
				}

			}
			if (s == count)
				break;
		}
		findWaitingTime(task, s);
		findTurnAroundTime(task, s, tat);
		System.out.print("--------------------------------------------------------------------------------");
		System.out.print("\nProcess\t      Burst Time\t       Turnaround Time\t          Waiting Time\n");
		System.out.print("--------------------------------------------------------------------------------");
		for (i = 0; i < s; i++) {
			Task tsk = task[i];
			awt = awt + tsk.getWaitTime();
			atat = atat + tat[i];
			System.out.print(
					"\n " + (i + 1) + "\t " + tsk.getBurst() + "\t\t " + tat[i] + "\t\t " + tsk.getWaitTime() + "\n");
		}
		awt = awt / s;
		atat = atat / s;
		System.out.println("\nAverage waiting Time = " + awt + "\n");
		System.out.println("Average turnaround time = " + atat);
	}

	private static void findWaitingTime(Task task[], int size) {
		for (int i = 1; i < size; i++) {
			Task tsk = task[i];
			tsk.setWaitTime(task[i - 1].getBurst() + task[i - 1].getWaitTime());
		}
	}

	public static void findTurnAroundTime(Task task[], int n, int tat[]) {
		for (int i = 0; i < n; i++)
			tat[i] = task[i].getBurst() + task[i].getWaitTime();
	}

}
