package practiceProblems;

public class ReverseWordsInString {

	// Runtime: 14 ms, faster than 12.06% of Java online submissions for Reverse
	// Words in a String.
	// Memory Usage: 40 MB, less than 12.44% of Java online submissions for Reverse
	// Words in a String.
	public static String solution1(String s) {
		String result = "";
		String temp = "";
		int len = s.length() - 1;
		for (int i = 0; i <= len; ++i) {
			if (s.charAt(i) == ' ') {
				if (temp.length() == 0)
					continue;
				else {
					if (result.length() > 0) {
						temp += " " + result;
						result = temp;
					} else {
						result = temp;
					}
					temp = "";
					continue;
				}
			}
			temp += s.charAt(i);
		}

		if (result.length() > 0 && temp.length() > 0)
			return temp + " " + result;
		else if (temp.length() == 0)
			return result;
		else
			return temp;
	}

	public static void main(String[] args) {
		String input = "  Bob    Loves  Alice   ";
		System.out.println(solution1(input));
		System.out.println(solution1(input).length());
	}

}
