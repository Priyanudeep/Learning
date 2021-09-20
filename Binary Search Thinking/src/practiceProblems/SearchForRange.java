package practiceProblems;

import java.util.Arrays;

public class SearchForRange {

	// Failed on few test cases. Besides, TC: n(worst case)
	private static int[] solution1(int[] nums, int target) {
		int len = nums.length, left = 0, right = len - 1, mid;
		if (len == 0)
			return new int[] { -1, -1 };
		int start = -1, end = -1;
		int index = -1;
		while (left <= right) {
			mid = left + ((right - left) / 2);
			if (nums[mid] == target) {
				index = mid;
				break;
			} else if (nums[mid] < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		if (index == -1)
			return new int[] { start, end };
		start = Math.max(0, index - 1);
		end = Math.min(index + 1, len - 1);
		while (start > -1 && end < len) {
			if (nums[start] != target && nums[end] != target)
				break;
			if (start != 0)
				--start;
			if (end != len - 1)
				++end;
		}
		return new int[] { ++start, --end };
	}

	// TC: C * O(log n), where C = 2 in worst case;
	// Runtime: 0 ms, faster than 100.00% of Java online submissions for Find First
	// and Last Position of Element in Sorted Array.
	// Memory Usage: 42.1 MB, less than 81.24% of Java online submissions for Find
	// First and Last Position of Element in Sorted Array.
	private static int[] solution2(int[] nums, int target) {
		int len = nums.length, left = 0, right = len - 1, mid;
		if (len == 0)
			return new int[] { -1, -1 };
		int start = -1, end = -1;
		int index = -1;
		while (left <= right) {
			mid = left + ((right - left) / 2);
			if (nums[mid] == target) {
				index = mid;
				break;
			} else if (nums[mid] < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		if (index == -1)
			return new int[] { start, end };
		left = 0;
		right = index;
		while (left <= right) {
			mid = left + ((right - left) / 2);
			if (nums[mid] == target) {
				index = mid;
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		start = index;
		left = start;
		right = len - 1;
		while (left <= right) {
			mid = left + ((right - left) / 2);
			if (nums[mid] == target) {
				index = mid;
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		end = index;
		return new int[] { start, end };
	}

	public static void main(String[] args) {
		//int len = 0;
		int[] nums = new int[] { 1, 2, 3 };
		int target = 1;
		System.out.println(Arrays.toString(solution1(nums, target)));
		System.out.println(Arrays.toString(solution2(nums, target)));
	}

}
