package com.test.maxcover;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 * Create input file for MaxCover problem
 * @author kamoorr
 *
 */
public class InputGenerator {
	
	public static void main(String[] args) throws IOException{
		long antenna = 1600;
		long stations = 126000;
		String filePath = "/Users/kamoorr/Desktop/hittinset-test-6.txt";
		
		BufferedWriter writer = new BufferedWriter(new FileWriter(new File(filePath)));
		writer.write(antenna + " "+ stations + "\n");
		Random r = new Random();
		for(int i=0;i<antenna;i++){
			int s = (int)(r.nextDouble() * 5000);
			StringBuffer buffer = new StringBuffer(s +" ");
			for(int j=0;j<s;j++){
				buffer.append((int)(r.nextDouble() * stations) + " ");
			}
			buffer.append("\n");
			writer.write(buffer.toString());
		}
		writer.flush();
		writer.close();
		
	}

}
