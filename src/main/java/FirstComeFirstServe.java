package main.java;

import java.util.ArrayList;
import java.util.List;

public class FirstComeFirstServe {

	public FirstComeFirstServe() {

	}

	private static void findavgTime(List<Task> tasks) {
		findWaitingTime(tasks);
		int total_wt = 0, total_tat = 0;
		int n = tasks.size();

		System.out.printf("Process Burst time Waiting" + " time Turn around time Priority\n");
		for (int i = 0; i < n; i++) {
			total_wt = total_wt + tasks.get(i).getWaitTime();
			total_tat = total_tat + getTurnAroundTime(tasks.get(i));
			System.out.printf(" %d ", tasks.get(i).getName());
			System.out.printf("     %d ", tasks.get(i).getBurst());
			System.out.printf("     %d", tasks.get(i).getWaitTime());
			System.out.printf("     %d", getTurnAroundTime(tasks.get(i)));
			System.out.printf("     %d\n", tasks.get(i).getPriority());
		}

		float s = (float) total_wt / (float) n;
		int t = total_tat / n;
		System.out.printf("Average waiting time = %f", s);
		System.out.printf("\n");
		System.out.printf("Average turn around time = %d ", t);

	}

	private static int getTurnAroundTime(Task task) {
		return task.getBurst() + task.getWaitTime();
	}

	private static void findWaitingTime(List<Task> tasks) {

		for (int i = 1; i < tasks.size(); i++) {
			tasks.get(i).setWaitTime(tasks.get(i - 1).getBurst() + tasks.get(i - 1).getWaitTime());
		}
	}

	public static void fcfsSort(List<Task> tasks) {
		findavgTime(tasks);
	}

}
