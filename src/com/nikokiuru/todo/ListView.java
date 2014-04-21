package com.nikokiuru.todo;

import java.util.ArrayList;

import com.vaadin.addon.touchkit.ui.NavigationButton;
import com.vaadin.addon.touchkit.ui.NavigationButton.NavigationButtonClickEvent;
import com.vaadin.addon.touchkit.ui.NavigationButton.NavigationButtonClickListener;
import com.vaadin.addon.touchkit.ui.NavigationView;
import com.vaadin.addon.touchkit.ui.VerticalComponentGroup;
import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

@SuppressWarnings("serial")
public class ListView extends NavigationView {
	
	final VerticalComponentGroup content = new VerticalComponentGroup();
	
    public ListView() {
        setCaption("Todo List");
    	TodoManager.Initialize();
    	updatelist();
    	setContent(content);
    };
    
	private void updatelist() {
		content.removeAllComponents();
		
		// New task form
        final TextField task = new TextField("New task");
        task.setInputPrompt("Enter new task...");
        content.addComponent(task);
        
        final Button submitButton = new Button("Add");
        submitButton.addClickListener(new ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
                TodoManager.addTodoList(task.getValue());
                updatelist();
                Notification.show("New list " + task.getValue() + " added!");
            }
        });
        content.addComponent(submitButton);
        
        // Todo lists
		ArrayList<TodoList> todolists = TodoManager.getTodoLists();
		
		for (int i = 0; i < todolists.size(); i++) {
			final TodoList todoList = todolists.get(i);
			final NavigationButton button = new NavigationButton(todoList.getName());
			button.setData(todoList);
			content.addComponent(button);
			
			button.addClickListener(new NavigationButtonClickListener() {
				@Override
				public void buttonClick(NavigationButtonClickEvent event) {
					getNavigationManager().navigateTo(new ItemView(todoList));
				}
			});
			
		}
		
	}

}
