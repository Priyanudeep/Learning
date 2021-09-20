package practiceProblems;

import java.util.Arrays;
import java.util.Random;

public class MinimumInRotatedSortedArray {

	// Runtime: 0 ms, faster than 100.00% of Java online submissions for Find
	// Minimum in Rotated Sorted Array.
	// Memory Usage: 38.5 MB, less than 36.33% of Java online submissions for Find
	// Minimum in Rotated Sorted Array.
	private static int solution1(int[] nums) {
		int left = 0, right = nums.length - 1, mid = left + ((right - left) / 2), pivot = -1;
		if (nums.length == 1)
			return nums[0];
		else if (nums.length == 2)
			return Math.min(nums[0], nums[1]);
		else if (nums[left] < nums[mid] && nums[mid + 1] < nums[right]) {
			return Math.min(nums[0], nums[mid + 1]);
		} else {
			left = 0;
			right = nums.length - 1;
			pivot = -1;
			mid = left + ((right - left) / 2);
			if (nums[left] > nums[mid])
				pivot = findPivot(nums, left, mid);
			else
				pivot = findPivot(nums, mid + 1, right);
			return Math.min(nums[left], nums[Math.min(pivot + 1, nums.length - 1)]);
		}
	}

	private static int findPivot(int[] nums, int start, int end) {
		int mid;
		while (start < end) {
			mid = start + ((end - start) / 2);
			if (nums[mid] > nums[mid + 1])
				return mid;
			if (nums[mid] < nums[start])
				end = mid - 1;
			else
				start = mid + 1;
		}
		return start;
	}

	private static void rotateArray(int[] nums, int k) {
		if (nums.length == k || k == 0)
			return;
		swap(nums, 0, nums.length - 1);
		swap(nums, 0, k - 1);
		swap(nums, k, nums.length - 1);
		System.out.println("Array after " + k + " rotations: " + Arrays.toString(nums));
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
		int len = 2;
		int[] nums = new int[len];
		System.out.println("Original Array: " + Arrays.toString(nums));
		Random r = new Random();
		int k = r.nextInt(len + 1);
		rotateArray(nums, k);
		System.out.println(solution1(nums));
//		for (int i = 0; i <= len; ++i) {
//			for (int j = 0; j < len; ++j)
//				nums[j] = j;
//			rotateArray(nums, i);
//			System.out.println(solution1(nums));
//		}
//		for (int j = 0; j < len; ++j)
//			nums[j] = j;
//		rotateArray(nums, 5);
//		System.out.println(solution1(nums));
	}

}
