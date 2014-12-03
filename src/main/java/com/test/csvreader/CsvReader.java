package com.test.csvreader;

import java.util.Arrays;

/**
 * http://en.wikipedia.org/wiki/Comma-separated_values
 * 
 * Valid Lines:
 * 1997,Ford,E350
 * "1997","Ford","E350"
 * 1997,Ford,E350,"Super, luxurious truck"
 * 1997,Ford,E350,"Super, ""luxurious"" truck"
 * 1997,Ford,E350,"Go get one now they are going fast"
 * 1997,Ford,E350," Super luxurious truck "
 * 
 * @author kamoorr
 *
 */

public class CsvReader {
	
	public static void main(String args[]){
		CsvParser parser = new CsvParser();
		//System.out.println(Arrays.toString(parser.parseLine("1997,Ford,E350")));
		//System.out.println(Arrays.toString(parser.parseLine("\"1997\",\"Ford\",\"E350\"")));
		System.out.println(Arrays.toString(parser.parseLine("\"1997\",\"Ford\",\"E350,ABC\"")));
		
		
	}

}


class CsvParser{
	
	private static final String QUOTE="\"";
	private static final String ESCAPE_QUOTE = "\"\"";
	
	public static String[] parseLine(String line){
		
		String[] result = new String[100];
		
		String[] tempResult =  line.split(",");
		String combinedString = "";
		boolean isComplete = true;
		int i=0;
		
		for(String word: tempResult){
			if (word.startsWith(QUOTE) && !word.startsWith(ESCAPE_QUOTE)){
				if(word.endsWith(QUOTE)){
					isComplete = true;
					combinedString =  word.replace(QUOTE, "");
				}else{
					isComplete = false;
					combinedString =  combinedString + "," +word.replace(QUOTE, "");
				}
				
				
			}else if(word.endsWith(QUOTE) && !word.endsWith(ESCAPE_QUOTE)){
				if(!isComplete){
					isComplete = true;
				}
				combinedString =  combinedString + "," +word.replace(QUOTE, "");
				
			}
			if(isComplete == true){
					result[i++] = combinedString == null?word:combinedString;
					combinedString = "";
			}
			
		}
		return result;
	}
}
