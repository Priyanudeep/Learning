package practiceProblems;

public class PeakElement {

	private static int solution1(int[] nums) {
		int left = 0, right = nums.length - 1, mid;
		if (nums.length == 1)
			return 0;
		if (nums.length == 2)
			return nums[0] < nums[1] ? 1 : 0;
		while (left < right) {
			mid = left + ((right - left) / 2);
			if (nums[mid] > nums[mid + 1])
				right = mid;
			else
				left = mid + 1;
		}
		return left;
	}

	public static void main(String[] args) {
		int[] nums = new int[] { 1, 2, 3, 2, 4 };
		System.out.println(solution1(nums));
	}

}
