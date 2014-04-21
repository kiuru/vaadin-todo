package com.nikokiuru.todo;

import java.util.ArrayList;

import com.vaadin.addon.touchkit.ui.NavigationView;
import com.vaadin.addon.touchkit.ui.VerticalComponentGroup;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

@SuppressWarnings("serial")
public class ItemView extends NavigationView {
	
	final VerticalComponentGroup content = new VerticalComponentGroup();
	TodoList todoList;
	
    public ItemView(TodoList todoList) {
    	setCaption(todoList.getName() + " items");
    	this.todoList = todoList;
    	updateItems();
    	setContent(content);
    };
    
    private void updateItems() {
		content.removeAllComponents();
		
		ArrayList<TodoItem> todoItems = this.todoList.getTodoItems();
		
		// New task form
        final TextField item = new TextField("New item");
        item.setInputPrompt("Enter new item...");
        content.addComponent(item);
        
        final Button submitButton = new Button("Add");
        submitButton.addClickListener(new ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
                todoList.addTodoItem(item.getValue());
                updateItems();
                Notification.show("New item " + item.getValue() + " added!");
            }
        });
        content.addComponent(submitButton);
    	
    	for (int i = 0; i < todoItems.size(); i++) {
    		TodoItem todoItem = todoItems.get(i);
    		final Label label = new Label(todoItem.getName());
    		content.addComponent(label);
    	}
    }
    
}
