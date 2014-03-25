package com.test.designpatterns.builder;

public class BuilderSample {
	
	int age;
	String name;
	
	private BuilderSample(int age, String name) {
		this.age = age;
		this.name = name;
	}
    /**
	 * This class act as builder class 
	 * @author MIBRLK0
	 *
	 */
	static class Builder{
		
		public static BuilderSample getBuilder(int age){
			return new BuilderSample(age, null);
		}
		
		public static BuilderSample getBuilder(String name){
			return new BuilderSample(0, name);
		}
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BuilderSample builder = BuilderSample.Builder.getBuilder(10);
		BuilderSample builder1 = BuilderSample.Builder.getBuilder("Ratheesh");

	}

}
