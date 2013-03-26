package com.asal.projectmanager.web.form;

import com.asal.projectmanager.domain.Color;
import com.asal.projectmanager.domain.Greeting;

public class GreetingForm {
	//The Domain Model persistent date
	private Greeting greeting;
	//The other non-persistent data, used in the user interface only
	private Color color;
	
	public Greeting getGreeting() {
		return greeting;
	}
	public void setGreeting(Greeting greeting) {
		this.greeting = greeting;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
}
