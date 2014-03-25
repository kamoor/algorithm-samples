package com.test.designpatterns.command;

public class TestRun {

	/**
	 * Button actually doesnt know how to click. Only button clicker is doing the work
	 * Button will just pass the command 
	 * @param args
	 */
	public static void main(String[] args) {
		Button button = new Button(new ClickCommand());

		button.clickButton();
	}

}
