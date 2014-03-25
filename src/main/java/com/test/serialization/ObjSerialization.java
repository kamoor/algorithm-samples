package com.test.serialization;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ObjSerialization {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		try {
			Student s = new Student("Ratheesh",1);
			FileOutputStream fOut = new FileOutputStream(new File("c://abc.txt"));
			ObjectOutputStream objStream = new ObjectOutputStream(fOut);
			objStream.writeObject(s);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	

	}
	
	
	
	

}

 class Student implements Serializable{
	
	private String name;
	private int age;
	
	public Student(String name, int age){
		this.name = name;
		this.age= age;
	}
}
