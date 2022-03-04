package assignmentProblems;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

	// https://leetcode.com/problems/two-sum/
	// Runtime: 3 ms, faster than 65.39% of Java online submissions for Two Sum.
	// Memory Usage: 40.4 MB, less than 31.62% of Java online submissions for Two Sum.
	// Interestingly, the best TC solution is O(n^2)
	private static int[] solution1(int[] nums, int target) {
		int i = 0;
		HashMap<Integer, Integer> match = new HashMap<Integer, Integer>();
		for (int num : nums) {
			match.put(target - num, i);
			++i;
		}
		for (i = 0; i < nums.length; ++i) {
			if (match.containsKey(nums[i]) && match.get(nums[i]) != i)
				return new int[] { match.get(nums[i]), i };
		}
		return null;
	}

	public static void main(String[] args) {
		int[] nums = new int[] { 3, 2, 4 };
		int target = 6;
		int[] ans = solution1(nums, target);
		System.out.println(Arrays.toString(ans));
	}

}
