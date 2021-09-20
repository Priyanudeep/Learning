package test;

public class RemoveDupes {

	private static int[] rotateArray(int[] input, int start, int end, int k) {
		int mid = start + ((end - start) / 2);
		int mid2 = start + ((end - 1 - start) / 2);
		int temp = 0;
		for (int i = start, j = 0; i < mid; ++i, ++j) {
			temp = input[i];
			input[i] = input[end - j];
			input[end - j] = temp;
		}
		for (int i = start, j = end - 1; i <= mid2; ++i, --j) {
			temp = input[j];
			input[j] = input[i];
			input[i] = temp;
		}
		return input;
	}

	private static void printArray(int[] input) {
		// System.out.println();
		for (int i = 0; i < input.length; ++i) {
			System.out.print(input[i]);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[] { 1, 2, 3, 3, 4, 5, 5 };
		System.out.print("Given Input: ");
		printArray(nums);
		int l = nums.length;
		int a = 0;
		for (int i = 0; i <= l - 2; ++i) {
			if (nums[i] == nums[i + 1]) {
				rotateArray(nums, i, l - 1 - a, l - i - a - 1);
				++a;
			}
		}
		System.out.println("\n" + a + "\nOutput: ");
		for (int i = 0; i < l - a; ++i) {
			System.out.print(nums[i]);
		}
	}

}
