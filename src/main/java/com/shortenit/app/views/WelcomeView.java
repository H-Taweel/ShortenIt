package com.shortenit.app.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route("welcome")
public class WelcomeView extends VerticalLayout {

  public WelcomeView() {
    TextField nameField = new TextField("Your name");
    Button sayHelloButton = new Button("Say hello");
    sayHelloButton.addClickListener(
        e -> {
          Notification.show("Welcome to Shorten It, " + nameField.getValue());
        });

    add(nameField, sayHelloButton);
  }
}
