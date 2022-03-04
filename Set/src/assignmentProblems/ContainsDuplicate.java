package assignmentProblems;

import java.util.HashSet;

public class ContainsDuplicate {

	// https://leetcode.com/problems/contains-duplicate/
	// Runtime: 5 ms, faster than 80.20% of Java online submissions for Contains Duplicate.
	// Memory Usage: 44.9 MB, less than 67.95% of Java online submissions for Contains Duplicate.
	// NOTE: solution2 could be to sort the array and compare adjacent elements. TC: O(n)
	private static boolean solution1(int[] nums) {
		HashSet<Integer> mySet = new HashSet<Integer>();
		for (int num : nums) {
			if (mySet.contains(num))
				return true;
			else {
				mySet.add(num);
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int[] nums = new int[] { 1, 2, 3, 1 };
		System.out.println(solution1(nums));
	}

}
