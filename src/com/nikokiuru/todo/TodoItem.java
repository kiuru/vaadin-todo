package com.nikokiuru.todo;

public class TodoItem {
	
	String name;
	boolean done;
	
	public TodoItem(String name) {
		this.name = name;
		this.done = false;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public boolean isDone() {
		return done;
	}
	
	public void setDone(boolean done) {
		this.done = done;
	}

}
