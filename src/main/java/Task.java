package main.java;

import java.io.Serializable;

public class Task implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1548699434838140013L;
	String name;
	int priority;
	int burst;
	int tId;

	public Task(String inName, int inPriority, int inBurst, int inTid) {

		name = inName;
		priority = inPriority;
		burst = inBurst;
		tId = inTid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public int getBurst() {
		return burst;
	}

	public void setBurst(int burst) {
		this.burst = burst;
	}

	public int gettId() {
		return tId;
	}

	public void settId(int tId) {
		this.tId = tId;
	}

}
