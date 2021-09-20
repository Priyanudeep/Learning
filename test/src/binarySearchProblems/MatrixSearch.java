package binarySearchProblems;

public class MatrixSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 10 20 30 40 50
		// 51 52 53 54 55
		// 62 65 68 71 74
		// 75 80 85 90 95
		// 97 99 101 103 105
		// 106 107 108 109 110
		boolean isFound = false;
		int m = 6, n = 5;
		int target = 95;
		int[][] arr = { { 10, 20, 30, 40, 50 }, { 51, 52, 53, 54, 55 }, { 62, 65, 68, 71, 74 }, { 75, 80, 85, 90, 95 },
				{ 97, 99, 101, 103, 105 }, { 106, 107, 108, 109, 110 } };
		int start = 0, last = (m * n) - 1, mid = 0;
		// int startIndex1 = 0, startIndex2 = 0, lastIndex1 = m - 1, lastIndex2 = n - 1;
		int midIndex1 = 0, midIndex2 = 0;
		while (start <= last) {
			mid = start + ((last - start) / 2);
			midIndex1 = mid / n;
			midIndex2 = mid % n;
//			startIndex1 = start / n;
//			startIndex2 = start % n;
//			lastIndex1 = last / n;
//			lastIndex2 = last % n;

			if (arr[midIndex1][midIndex2] == target) {
				isFound = true;
				break;
			} else if (arr[midIndex1][midIndex2] < target) {
				start = mid + 1;
			} else if (arr[midIndex1][midIndex2] > target) {
				last = mid - 1;
			}
		}
		System.out.println("Is target value found: " + isFound);
		if (isFound) {
			System.out.println("Target found at Index: " + "(" + midIndex1 + ", " + midIndex2 + ")");
		}
	}

}
