package practiceProblems;

import java.util.Arrays;

public class RemoveElement {
	// Runtime: 1 ms, faster than 7.65% of Java online submissions for Remove Element.
	// Memory Usage: 39.4 MB, less than 6.34% of Java online submissions for Remove Element.
	public static int solution1(int[] nums, int val) {
		int count = 0;
		for (int i = 0; i < nums.length; ++i) {
			if (nums[i] == val) {
				nums[i] = 1000;
				++count;
			}
		}
		Arrays.sort(nums);
		return nums.length - count;
	}

	public static void main(String[] args) {
		int[] nums = new int[] { 3, 2, 2, 3 };
		int val = 3;
		System.out.println(solution1(nums, val));
	}
}
