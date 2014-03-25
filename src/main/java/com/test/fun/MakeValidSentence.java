package com.test.fun;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * AMAZON Interview question
 * Given a sentence and a function isValidDictionaryword(String s), 
 * which returns true if the word is present in dictionary. 
 * I/P : thereisastoneontheroad.
 * O/P : there is a stone on the road.
 * @author MIBRLK0
 *
 */
public class MakeValidSentence {
	
	
	private  List<String> dictionary;
	
	public MakeValidSentence(){
		dictionary = new ArrayList<String>();
		String validString[] = "man accused of a killing bus driver".split(" ");
		for(String str:validString){
			dictionary.add(str.trim());
		}
		
		
	}
	private boolean isValidWord(StringBuffer str){
		return dictionary.contains(str.toString());
	}
	
	private String getStringFromStack(Stack stack){
		String str = "";
		while(!stack.isEmpty()){
			str = stack.pop() + " " +str;
		}
		return str;
	}
	
	/*
	 * Check for valid word, push to stack
	 * If next word is not valid, then pop the stack and try and for next combination
	 */
	public String makeSentence(String input){
		
		Stack<String> stack = new Stack<String>();
		StringBuffer currentWord = new StringBuffer();
		int validIndex = 0;
		int length = input.length();
		
		for(int i=0;i<length;i++){
			//get a new word
			currentWord.append(input.charAt(i));
			if(isValidWord(currentWord)){
				//push to stack
				stack.push(currentWord.toString());
				validIndex = i+1;
				currentWord.setLength(0);
			}else{
				//some time a valid word may not intended to be the right one..need to check the next word and see
				//if that is valid
				//for example "a" in man is not a valid word
				if(i == length -1){
					//got some word with invalid 
					currentWord.setLength(0);
					currentWord.append(stack.pop());
					i = validIndex -1;
				}
				
			}
		}
		
		return getStringFromStack(stack);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Valid Sentence : "+ new MakeValidSentence().makeSentence("manaccusedofkillingbusdriver"));

	}

}
