package assignmentProblems;

import java.util.HashMap;

public class ContainsDuplicate2 {

	private static boolean containsDuplicate(int[] nums, int k) {
		// implement try-catch blocks everywhere
		HashMap<Integer, Integer> myMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; ++i) {
			if (!myMap.containsKey(nums[i]))
				myMap.put(nums[i], i);
			else {
				var diff = i - myMap.get(nums[i]) < 0 ? (-1 * (i - myMap.get(nums[i]))) : i - myMap.get(nums[i]);
				if(diff <= k)
					return true;
                else
                    myMap.put(nums[i], i);
			}
		}
		return false;
	}

	private static boolean containsDuplicate2(int[] nums, int k) {
		for (int i = 0; i < nums.length; ++i) {
			int index1 = i - k;
			int index2 = i + k;
			if (index1 >= 0 && nums[i] == nums[index1])
				return true;
			if (index2 < nums.length && nums[i] == nums[index2])
				return true;
		}

		return false;
	}

	public static void main(String[] args) {
		// Create Random generated array with duplicates
		int k = 3;
		int[] nums = new int[] { 1, 2, 3, 4 };
		containsDuplicate(nums, k);
		containsDuplicate2(nums, k);
	}

}
