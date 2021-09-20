package binarySearchProblems;

import java.util.Arrays;

public class InputArray {
	InputArray() {
		for (int i = 0; i < arraySize; ++i) {
			inputArray[i] = (i + 1) * 10;
		}
	}

	// function to construct a sorted array of n size
	// function to return a value of an element in an array, given the index
	// in case the value is not present, -1 is returned.
	// Note: the array length and the array itself must be private to this class.
	int arraySize = 10000;
	private int[] inputArray = new int[arraySize];

	public int elementAtIndex(int index) {
		if (index > arraySize || index < 0) {
			return 2147483647;
		} else {
			return inputArray[index];
		}
	}

	public void printArray() {
		System.out.println(Arrays.toString(inputArray));
	}
}
