package practiceProblems;

public class RemoveDuplicatesInSortedArray {

	private static int solution1(int[] nums) {
		int uniqueIndex = 0;
		if (nums.length == 0) {
			return 0;
		} else if (nums.length == 1) {
			return 1;
		} else {
			for (int i = 1; i < nums.length; ++i) {
				if (nums[i] != nums[uniqueIndex]) {
					nums[++uniqueIndex] = nums[i];
				}
			}
		}
		return ++uniqueIndex;
	}

	public static void main(String[] args) {
		int[] nums = new int[] { 1, 1, 2, 3 };
		System.out.println(solution1(nums));
	}

}
