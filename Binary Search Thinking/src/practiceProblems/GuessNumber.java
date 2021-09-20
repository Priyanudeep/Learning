package practiceProblems;

public class GuessNumber {

	private static int k;

	/**
	 * Forward declaration of guess API.
	 * 
	 * @param num your guess
	 * @return -1 if num is lower than the guess number 1 if num is higher than the
	 *         guess number otherwise return 0 int guess(int num);
	 */
	private static int guess(int n) {
		if (k < n)
			return -1;
		if (k > n)
			return 1;
		return 0;
	}

	// Runtime: 0 ms, faster than 100.00% of Java online submissions for Guess
	// Number Higher or Lower.
	// Memory Usage: 36.2 MB, less than 12.24% of Java online submissions for Guess
	// Number Higher or Lower.
	private static int solution1(int n) {
		if (guess(n) == 0)
			return n;
		int left = 1, right = n;
		int k = n / 2;
		while (k > 0) {
			switch (guess(k)) {
			case -1: {
				right = k - 1;
			}
				break;
			case 0: {
				return k;
			}
			case 1: {
				left = k + 1;
			}
				break;
			}
			k = left + ((right - left) / 2);
		}
		return -1;
	}

	public static void main(String[] args) {
		k = 2;
		System.out.println(solution1(10));
	}
}
