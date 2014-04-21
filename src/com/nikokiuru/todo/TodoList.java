package com.nikokiuru.todo;

import java.util.ArrayList;

public class TodoList {

	String name;
	ArrayList<TodoItem> todoItem;
	
	public TodoList(String name) {
		this.name = name;
		this.todoItem = new ArrayList<TodoItem>();
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public ArrayList<TodoItem> getTodoItems() {
		return todoItem;
	}
	
	public void addTodoItem(String name){
		this.todoItem.add(new TodoItem(name));
	}
	
}
