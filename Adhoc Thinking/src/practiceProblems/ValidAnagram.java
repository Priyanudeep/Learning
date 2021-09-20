package practiceProblems;

import java.util.Arrays;

public class ValidAnagram {

	// Runtime: 2 ms, faster than 94.61% of Java online submissions
	// Memory Usage: 39.1 MB, less than 82.90% of Java online submissions
	public static boolean solution1(String s, String t) {
		char[] a = s.toCharArray();
		char[] b = t.toCharArray();
		if (a.length != b.length)
			return false;
		Arrays.sort(a);
		Arrays.sort(b);
		for (int i = 0; i < a.length; ++i) {
			if (a[i] != b[i]) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(solution1("anagram", "nagaram"));
	}

}
