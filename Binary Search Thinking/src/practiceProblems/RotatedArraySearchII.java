package practiceProblems;

import java.util.Arrays;
import java.util.Random;

public class RotatedArraySearchII {

	// Runtime: 1 ms, faster than 19.94% of Java online submissions for Search in
	// Rotated Sorted Array.
	// Memory Usage: 38.4 MB, less than 89.53% of Java online submissions for Search
	// in Rotated Sorted Array.
	private static boolean solution1(int[] nums, int target) {
		int len = nums.length, left = 0, right = len - 1, mid = left + ((right - left) / 2), pivot = -1;
		if ((nums[left] == nums[mid] && nums[mid] == nums[right]) || len <= 2)
			return linearFind(nums, target);
		if (nums[left] < nums[mid] && nums[mid] < nums[right])
			return find(nums, target);
		if (nums[left] > nums[mid])
			pivot = findPivot(nums, left, mid);
		else if (nums[right] < nums[mid])
			pivot = findPivot(nums, mid, right);
		else {
			if (len % 2 == 0)
				pivot = mid;
			else
				pivot = Math.max(0, pivot - 1);
		}
		if (target >= nums[left] && target <= nums[pivot])
			return find(nums, left, pivot, target);
		else if (target >= nums[Math.min(right, pivot + 1)] && target <= nums[right])
			return find(nums, pivot + 1, right, target);
		return false;
	}

	private static int findPivot(int[] nums, int start, int end) {
		int pivot = -1;
		while (start <= end) {
			int mid = start + ((end - start) / 2);
			if (nums[mid] > nums[mid + 1]) {
				pivot = mid;
				break;
			}
			if (nums[mid] < nums[start])
				end = mid;
			else if (nums[mid] > nums[end])
				start = mid;
		}
		return Math.max(pivot, start);
	}

	private static boolean linearFind(int[] nums, int target) {
		if (nums[nums.length / 2] == target)
			return true;
		for (int i = 0, j = nums.length - 1; i <= j; ++i, --j) {
			if (nums[i] == target || nums[j] == target)
				return true;
		}
		return false;
	}

	private static boolean find(int[] nums, int left, int right, int target) {
		int[] n = Arrays.copyOfRange(nums, left, Math.min(right, nums.length - 1) + 1);
		return find(n, target);
	}

	private static boolean find(int[] nums, int target) {
		int len = nums.length;
		if (len <= 2)
			return linearFind(nums, target);
		int left = 0, right = len - 1, mid;
		while (left <= right) {
			mid = left + ((right - left) / 2);
			if (nums[mid] == target)
				return true;
			else if (nums[mid] > target)
				right = mid - 1;
			else
				left = mid + 1;
		}
		return false;
	}

	private static void rotateArray(int[] nums, int k) {
		int len = nums.length;
		swap(nums, 0, len - 1);
		swap(nums, 0, k - 1);
		swap(nums, k, len - 1);
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
		int[] nums = new int[] { 1, 2, 0, 1, 1, 1 };// { 0, 1, 2, 4, 4, 4, 5, 6, 6, 7 };
		Random r = new Random();
		int pivot = r.nextInt(nums.length);
		++pivot;
		int target = r.nextInt(nums.length);
		++target;
		rotateArray(nums, pivot);
		System.out.println("Target " + target + " Found: " + solution1(nums, target));
	}

}
