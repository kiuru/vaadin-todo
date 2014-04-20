package com.nikokiuru.todo;

import java.util.ArrayList;

public class TodoManager {
	
	static ArrayList<TodoList> todoLists;

	static void Initialize() {
		todoLists = new ArrayList<TodoList>();
		TodoList exampleList = new TodoList("Home work");
		exampleList.addTodoItem(new TodoItem("Do homework"));
		exampleList.addTodoItem(new TodoItem("wash the dishes"));
		exampleList.addTodoItem(new TodoItem("wash the laundry"));
		exampleList.addTodoItem(new TodoItem("change the lamp"));
		todoLists.add(exampleList);
		addTodoList("Todo list");
	}
	
	static public ArrayList<TodoList> getTodoLists() {
		return todoLists;
	}
	
	static public void addTodoList(String name){
		todoLists.add(new TodoList(name));
	}
	
}
