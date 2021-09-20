package binarySearchProblems;

public class RotatedArrayBinarySearch {

	private static int[] rotateArray(int[] inputArray, int rotations) {
		int size = inputArray.length;
		//int mid = size / 2;
		for (int i = 0, j = size - 1; i < j; ++i, --j) {
			int temp = inputArray[i];
			inputArray[i] = inputArray[j];
			inputArray[j] = temp;
		}
		for (int i = 0, j = rotations - 1; i < j; ++i, --j) {
			int temp = inputArray[i];
			inputArray[i] = inputArray[j];
			inputArray[j] = temp;
		}
		for (int i = rotations, j = size - 1; i < j; ++i, --j) {
			int temp = inputArray[i];
			inputArray[i] = inputArray[j];
			inputArray[j] = temp;
		}
		return inputArray;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int indexFound = -1;
		int target = 80;
		int arraySize = 11;
		int rotations = 4;
		int pivot = 0;
		int[] arr = new int[arraySize];
		for (int i = 0; i < arraySize; ++i) {
			arr[i] = (i + 1) * 10;
			System.out.print(arr[i] + " ");
		}
		System.out.println("\nAfter rotating array by " + rotations + ": \n");
		var outPut = rotateArray(arr, rotations);
		for (int i = 0; i < arraySize; ++i) {
			System.out.print(outPut[i] + " ");
		}
		int start = 0, last = arraySize - 1, mid = 0;
		while (start < last) {
			mid = start + ((last - start) / 2);
			if (arr[mid] > arr[mid + 1]) {
				mid++;
				break;
			}
			if (arr[start] > arr[mid]) {
				last = mid;
			}
			if (arr[mid + 1] > arr[last]) {
				start = mid + 1;
			}
		}
		pivot = mid;
		System.out.println("\npivot : " + pivot);
		if(target <= arr[pivot - 1] && target >= arr[0]) {
			start = 0;
			last = pivot - 1;
		}
		else if(target >= arr[pivot]  && target <= arr[arraySize - 1]) {
			start = pivot;
			last = arraySize - 1;
		}
		while(start <= last) {
			mid = start + ((last - start) / 2);
			if(target == arr[mid]) {
				indexFound = mid;
				break;
			}
			else if(target < arr[mid]) {
				last = mid - 1;
			}
			else if(target > arr[mid]) {
				start = mid + 1;
			}
		}
		System.out.println("\nTarget found at Index: " + indexFound);
	}

}
