package binarySearchProblems;

import java.lang.Math;

public class UnknownLengthArrayBinarySearch {

	public static void main(String args[]) {
		int start = 0, last = 0, mid = 0;
		int target = 10;
		boolean targetFound = false;
		// var obj1 = new UnknownLengthArrayBinarySearch();
		var obj = new InputArray();
		obj.printArray();
		for (int i = 0; i <= 50; ++i) {
			var number = obj.elementAtIndex((int) Math.pow(2, i));
			if (number == target) {
				System.out.println("Target found at index: " + (int) Math.pow(2, i));
				targetFound = true;
				break;
			} else if (number > target) {
				last = (int) Math.pow(2, i);
				start = (int) Math.pow(2, i - 1);
				break;
			}
		}
		while (start <= last && !targetFound) {
			mid = start + ((last - start) / 2);
			if (target == obj.elementAtIndex(mid)) {
				System.out.println("Target found at index: " + mid);
				targetFound = true;
				break;
			} else if (target > obj.elementAtIndex(mid)) {
				start = mid + 1;
			} else {
				last = mid - 1;
			}
		}
		if (!targetFound) {
			System.out.println("Target Not found.");
		}
	}

}
