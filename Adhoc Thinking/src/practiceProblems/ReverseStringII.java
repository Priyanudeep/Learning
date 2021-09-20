package practiceProblems;

public class ReverseStringII {

	// Runtime: 2 ms, faster than 29.84% of Java online submissions for Reverse
	// String II.
	// Memory Usage: 39.1 MB, less than 48.21% of Java online submissions for
	// Reverse String II.
	public static String solution1(String s, int k) {
		StringBuilder sb = new StringBuilder(s);
		int len = s.length() - 1;
		int i = 0;
		while (i <= len) {
			int b = i + k - 1;
			if (b > len)
				b = len;
			for (int a = i; a <= b; ++a, --b) {
				char t = sb.charAt(a);
				sb.setCharAt(a, sb.charAt(b));
				sb.setCharAt(b, t);
			}
			i = i + 2 * k;
		}
		return sb.toString();
	}

	private static String reverse(StringBuilder c) {
		for (int i = 0, j = c.length() - 1; i != j; ++i, --j) {
			char t = c.charAt(i);
			c.setCharAt(i, c.charAt(j));
			c.setCharAt(j, t);
		}

		// System.out.println(c.toString());
		return c.toString();
	}

	public static void main(String[] args) {
		System.out.println(solution1("abcdefg", 8));
		// StringBuilder s = new StringBuilder("anudeep");
		// System.out.println(reverse(s));
	}

}
