package com.nikokiuru.todo;

import com.vaadin.addon.touchkit.ui.NavigationView;
import com.vaadin.addon.touchkit.ui.VerticalComponentGroup;
import com.vaadin.ui.Button;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

@SuppressWarnings("serial")
public class ListView extends NavigationView {

    public ListView() {
        setCaption("Todo List");
        
        final VerticalComponentGroup content = new VerticalComponentGroup();
        
        final TextField task = new TextField("New task");
        task.setInputPrompt("Enter new task...");
        content.addComponent(task);
        
        final Button submitButton = new Button("Add");
        submitButton.addClickListener(new ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
                Notification.show("New task added!");
            }
        });
        
        setContent(new CssLayout(content, submitButton));
    };
}
