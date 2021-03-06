package test;

public class MergeSortedArrays {

	private static int[] rotateArray(int[] input, int start, int end) {
		int temp = 0;
		int k = 1;
		int n = input.length;
		for (int i = start, j = 0; i <= (start + end) / 2; ++i, ++j) {
			temp = input[i];
			input[i] = input[end - j];
			input[end - j] = temp;
		}
		// printArray(input);
		for (int i = start + k, j = 0; i <= (end + 1 + k) / 2; ++i, ++j) {
			temp = input[i];
			input[i] = input[end - j];
			input[end - j] = temp;
		}
		// printArray(input);
		return input;
	}

	private static void printArray(int[] arr) {
		System.out.println();
		for (int i = 0; i < arr.length; ++i) {
			System.out.print(arr[i] + " ");
		}
	}

	private static void rotationLogic() {
		int[] arr = new int[] { 1, 2, 3, 4, 5, 6 };
		int k = 1;
		int n = arr.length;
		int temp = 0;
		printArray(arr);
		for (int i = 0; i < n / 2; ++i) {
			temp = arr[i];
			arr[i] = arr[n - 1 - i];
			arr[n - 1 - i] = temp;
		}
		printArray(arr);

		for (int i = k, j = 0; i < (n + k) / 2; ++i, ++j) {
			temp = arr[i];
			arr[i] = arr[n - 1 - j];
			arr[n - 1 - j] = temp;
		}
		printArray(arr);
		for (int i = 0; i < k / 2; ++i) {
			temp = arr[i];
			arr[i] = arr[k - 1 - i];
			arr[k - 1 - i] = temp;
		}
		printArray(arr);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// rotationLogic();

		int[] nums1 = new int[] { 11, 21, 36, 38, 0, 0, 0 };
		int[] nums2 = new int[] { 14, 25, 30 };
		int m = 4;// nums1.length;
		int n = nums2.length;
		int p = nums1.length;
		int temp = 0;
		for (int i = m, j = 0; i < p; ++i, ++j) {
			nums1[i] = nums2[j];
		}
		printArray(nums1);
		int j = 0;
		for (int i = 0; i < p - 2; ++i) {
			if (nums1[i] > nums1[m + j]) {
				rotateArray(nums1, i, m + j);
				if (m + j + 1 < p) {
					++j;
				}
			}
		}

		for (int i = m; i <= p - 2; ++i) {
			if (nums1[i] > nums1[i + 1]) {
				temp = nums1[i];
				nums1[i] = nums1[i + 1];
				nums1[i + 1] = temp;
			}
		}

		printArray(nums1);

	}

}
