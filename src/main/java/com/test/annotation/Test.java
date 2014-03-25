package com.test.annotation;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AnnotatedObject obj  = new AnnotatedObject();
		System.out.println(obj.getClass().isAnnotationPresent(MyAnnotation.class));
		System.out.println(obj.getClass().getAnnotation(MyAnnotation.class).name());

	}

}
