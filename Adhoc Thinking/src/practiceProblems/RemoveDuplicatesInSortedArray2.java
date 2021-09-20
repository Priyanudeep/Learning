package practiceProblems;

import java.util.Arrays;

public class RemoveDuplicatesInSortedArray2 {

	public static int solution1(int[] nums) {
		int first = -1;
		// int second = nums[0];
		int count = 1;

		for (int second = 1; second < nums.length; ++second) {

			if (nums[second - 1] == nums[second]) {
				++count;
			} else {
				count = 1;
				if (first != -1) {
					nums[first] = nums[second];
					count = 2;
				}
			}
			if (count == 3) {
				first = second;
			}
		}
		return ++first;
	}

	public static int solution2(int[] nums) {
		if(nums.length < 3)
            return nums.length;
        int count = 1, phi = 10001;
		int temp = phi;
		for (int i = 0; i < nums.length; ++i) {
			if (temp == nums[i]) {
				++count;
			} else {
				count = 1;
				temp = nums[i];
			}
			if (count >= 3) {
				nums[i] = phi;
			}
		}
		Arrays.sort(nums);
		temp = nums.length - 1;
		while(nums[temp] == phi) {
			--temp;
		}
		return temp + 1;
	}

	public static void main(String[] args) {
		int[] nums = new int[] { 1, 1, 1, 2, 2, 3 };
//		System.out.println(solution2(nums));
//		nums = new int[] { 0, 0, 1, 1, 1, 1, 2, 3, 3 };
//		System.out.println(solution2(nums));
		nums = new int[] { 1, 1, 1 };
		System.out.println(solution2(nums));
	}

}
