package binarySearchProblems;

public class CeilIndex {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 7;
		int[] arr = new int[n];
		for (int i = 0; i < n; ++i) {
			arr[i] = (i + 1) * 10;
			System.out.print(arr[i] + " ");
		}
		int target = 15;
		int indexFound = -1;
		int start = 0, last = n - 1, mid = 0;
		while (start <= last) {
			mid = start + ((last - start) / 2);
			if (target == arr[mid]) {
				indexFound = mid;
				break;
			}
			if (target < arr[mid]) {
				indexFound = mid;
				last = mid - 1;
			}
			if (target > arr[mid]) {
				start = mid + 1;
			}
		}
		System.out.println("\nindex: " + indexFound);
	}
}
