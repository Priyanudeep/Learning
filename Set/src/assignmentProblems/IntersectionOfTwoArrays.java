package assignmentProblems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Stack;

public class IntersectionOfTwoArrays {

	// https://leetcode.com/problems/intersection-of-two-arrays/
		// Runtime: 3 ms, faster than 50.40% of Java online submissions for Intersection
		// of Two Arrays.
		// Memory Usage: 39.5 MB, less than 40.04% of Java online submissions for
		// Intersection of Two Arrays.
		// NOTE: time complexity can be improved by using HashSet instead of Stack.
		// Also, HashSet is iteratable.
		private static int[] solution1(int[] nums1, int[] nums2) {
			if (nums1.length <= nums2.length) {
				return solutionImpl(nums1, nums2);
			} else {
				return solutionImpl(nums2, nums1);
			}
		}

		private static int[] solutionImpl(int[] nums_map, int[] nums_comp) {
			HashSet<Integer> mySet = new HashSet<Integer>();
			int i = 0;
			Stack<Integer> ans = new Stack<Integer>();
			for (int num : nums_map)
				mySet.add(num);
			for (int num : nums_comp) {
				if (mySet.isEmpty())
					break;
				else if (mySet.contains(num)) {
					ans.add(num);
					mySet.remove(num);
				}
			}
			int[] arr = new int[ans.size()];
			while (!ans.isEmpty()) {
				arr[i] = ans.pop();
				++i;
			}
			return arr;
		}

		public static void main(String[] args) {
			int[] nums1 = new int[] { 4, 9, 5 };
			int[] nums2 = new int[] { 9, 4, 9, 8, 4 };
			int[] ans = solution1(nums1, nums2);
			System.out.println(Arrays.toString(ans));
		}

}
