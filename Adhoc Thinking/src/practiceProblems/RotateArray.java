package practiceProblems;

import java.util.Arrays;

public class RotateArray {

	// https://leetcode.com/problems/rotate-array/
	// Runtime: 3 ms, faster than 13.13% of Java online submissions for Rotate
	// Array.
	// Memory Usage: 63.2 MB, less than 24.76% of Java online submissions for Rotate
	// Array.
	// NOTE: must check other solutions as it is mentioned in the description that
	// there are atleast 3 ways. Current solution is taking 3ms and is only 16%
	// better than most solutions
	private static void solution1(int[] nums, int k) {
		if (nums.length == 1 || k == 0)
			return;
		if (k > nums.length)
			k = k % nums.length;
		swap(nums);
		swap(nums, 0, k - 1);
		swap(nums, k, nums.length - 1);
		System.out.println(Arrays.toString(nums));
	}

	private static void swap(int[] nums) {
		for (int i = 0, j = nums.length - 1; i <= j; ++i, --j) {
			int temp = nums[i];
			nums[i] = nums[j];
			nums[j] = temp;
		}
	}

	private static void swap(int[] nums, int start, int end) {
		while (start <= end) {
			int temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
			++start;
			--end;
		}
	}

	public static void main(String[] args) {
		int[] nums = new int[] { 1, 2, 3, 4, 5 };
		solution1(nums, 3);
	}

}
