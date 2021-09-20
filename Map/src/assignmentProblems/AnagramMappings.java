package assignmentProblems;

import java.util.Arrays;
import java.util.HashMap;

public class AnagramMappings {

	private static int[] anagramMapping(int[] A, int[] B) {
		int[] output = new int[A.length];
		HashMap<Integer, Integer> myMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < B.length; ++i) {
			if (!myMap.containsKey(B[i]))
				myMap.put(B[i], i);
		}
		for (int i = 0; i < A.length; ++i) {
			output[i] = myMap.get(A[i]);
		}
		return output;
	}

	public static void main(String[] args) {
		// random number generator to populate the two arrays
		int[] A = new int[] { 12, 28, 46, 32, 50 };
		int[] B = new int[] { 50, 12, 32, 46, 28 };
		System.out.println(Arrays.toString(anagramMapping(A, B)));
	}

}
