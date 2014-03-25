package com.test.array;

import java.util.Arrays;

/**
 * Reverse an array of numbers
 * @author kamoorr
 *
 */
public class ReverseArray {

	private void recurseReverse(int input[], int i, int length) {
		if (i == length) {
			return;
		}
		int temp = input[i];
		recurseReverse(input, i + 1, length);
		input[length - 1 - i] = temp;
		return;

	}

	public void reverse(int input[]) {
		this.recurseReverse(input, 0, input.length);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] input = { 1, 2, 3, 4, 5, 6, 7, 8 };
		System.out.println(Arrays.toString(input));
		new ReverseArray().reverse(input);
		System.out.println(Arrays.toString(input));

	}

}
