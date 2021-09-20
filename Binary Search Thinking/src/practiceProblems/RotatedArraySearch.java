package practiceProblems;

import java.util.Arrays;
import java.util.Random;

public class RotatedArraySearch {

	// Runtime: 0 ms, faster than 100.00% of Java online submissions for Search in
	// Rotated Sorted Array.
	// Memory Usage: 38.7 MB, less than 16.34% of Java online submissions for Search
	// in Rotated Sorted Array.
	private static int solution1(int[] nums, int target) {
		int len = nums.length, left, right, pivot;
		if (len == 1)
			return nums[0] == target ? 0 : -1;
		else if (nums[0] < nums[len - 1]) {
			left = 0;
			right = len - 1;
		} else {
			pivot = findPivot(nums);
			if (target >= nums[0] && target <= nums[pivot]) {
				left = 0;
				right = pivot;
			} else if (target >= nums[pivot + 1] && target <= nums[len - 1]) {
				left = pivot + 1;
				right = len - 1;
			} else {
				return -1;
			}
		}
		while (left <= right) {
			int mid = left + ((right - left) / 2);
			if (nums[mid] == target) {
				return mid;
			} else if (nums[mid] < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return -1;
	}

	private static int findPivot(int[] nums) {
		int left = 0, right = nums.length - 1;
		int mid;
		int result = -100;
		while (left <= right) {
			mid = left + ((right - left) / 2);
			if (left + 1 == right) {
				result = nums[left] < nums[right] ? right : left;
				break;
			} else if ((mid == 0 || mid == nums.length - 1)
					|| (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1])) {
				result = mid;
				break;
			} else if (nums[mid] < nums[0])
				right = mid - 1;
			else if (nums[mid] > nums[nums.length - 1])
				left = mid + 1;
		}
		return result;
	}

	private static void swap(int[] arr, int left, int right) {
		while (left <= right) {
			int temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
			++left;
			--right;
		}
	}

	private static void rotate(int[] nums, int r) {
		int len = nums.length, left = 0, right = len - 1;
		if (r >= len)
			return;
		swap(nums, left, right);
		left = 0;
		right = r - 1;
		swap(nums, left, right);
		left = r;
		right = nums.length - 1;
		swap(nums, left, right);
	}

	public static void main(String[] args) {
		Random random = new Random();
		int length = Integer.parseInt(args[0]);
		int[] nums = new int[length];
		for (int i = 0; i < length; ++i) {
			nums[i] = i + 1;
		}
		int target = random.nextInt(length);
		++target;
		int r = random.nextInt(length);
		++r;
		System.out.print("Original array of length " + length + " : ");
		System.out.println(Arrays.toString(nums));
		System.out.println("Target: " + target);
		rotate(nums, r);
		System.out.println("Array after " + r + " rotations: " + Arrays.toString(nums));
		System.out.println("My Answer: " + solution1(nums, target));
	}

}
