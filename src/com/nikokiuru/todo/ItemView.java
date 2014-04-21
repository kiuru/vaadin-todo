package com.nikokiuru.todo;

import java.util.ArrayList;

import com.vaadin.addon.touchkit.ui.NavigationView;
import com.vaadin.addon.touchkit.ui.VerticalComponentGroup;
import com.vaadin.ui.Label;

@SuppressWarnings("serial")
public class ItemView extends NavigationView {
	
	final VerticalComponentGroup content = new VerticalComponentGroup();
	
    public ItemView(TodoList todoList) {
    	setCaption(todoList.getName() + " items");
    	printItems(todoList.getTodoItems());
    	setContent(content);
    };
    
    private void printItems(ArrayList<TodoItem> todoItems) {
    	for (int i = 0; i < todoItems.size(); i++) {
    		TodoItem todoItem = todoItems.get(i);
    		final Label label = new Label(todoItem.getName());
    		content.addComponent(label);
    	}
    }
    
}
