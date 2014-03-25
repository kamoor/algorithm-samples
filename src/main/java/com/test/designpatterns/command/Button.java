package com.test.designpatterns.command;

public class Button {

	Command click = null;
	public Button(Command click){
		this.click = click;
	}

	
	 public void clickButton(){
		 click.run();
	 }
}
