package com.test.designpatterns.plugins;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DynaLoader {
	
	
	 private void startDynaLoader() throws IOException{
		 
		 BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		 String command;
		 while(!(command = reader.readLine()).equals("exit")){
			if(command.equals("say hello")){
				HelloProviders.sayHelloFromAll();
			}
		 }
		 
	 }
	
	
	
	/**
	 * Start this program with a a directory path provided as first argument. Then put a java file to see the magic.
	 * 
	 * Example: start program as java DynaLoader /tmp/myfiles/
	 * 
	 * Then type "say hello"
	 * Answer: You will get "Hello World" from "default"
	 * Then drop CustomInterfaceExampleFromMexico.java in /tmp/myfiles/
	 * Then type say-hello
	 * Answer: You will get 
	 *   "Hello World" from "default"
	 *   "Hola Mundo" from mexico-guy
	 *   
	 * System will detect custom plugins and load them in to memory and execute it 
	 * 
	 * Then put 
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String args[]) throws IOException{
		 System.out.println("Type a command : 1) say hello  2) exit");
		 new Thread(new PluginLoaderTask(args[0])).start();
		 new DynaLoader().startDynaLoader();
	}

}
