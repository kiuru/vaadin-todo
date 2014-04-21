package com.nikokiuru.todo;

import com.vaadin.addon.touchkit.ui.NavigationView;

@SuppressWarnings("serial")
public class ItemView extends NavigationView {
	
    public ItemView(TodoList todoList) {
    	setCaption(todoList.getName() + " items");
    };
    
}
