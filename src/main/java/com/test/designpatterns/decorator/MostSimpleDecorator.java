package com.test.designpatterns.decorator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
/**
 * Most simple example of decorator pattern
 * @author kamoorr
 *
 */
public class MostSimpleDecorator {
	
	
	public static void main(String args[]) throws FileNotFoundException{
		//File got decorated to FileReader, then to BufferedReader.
		BufferedReader reader = new BufferedReader(new FileReader(new File("/tmp/abc.text")));
	}

}
