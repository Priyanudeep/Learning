package assignmentProblems;

import java.util.HashMap;

public class IsomorphicStrings {

	private static boolean isIsomorphic(String s, String t) {
		char[] str1 = s.toCharArray();
		char[] str2 = t.toCharArray();
		HashMap<Character, Character> charMap = new HashMap<Character, Character>();

		for (int i = 0; i < s.length(); ++i) {
			if (charMap.containsValue(str2[i])) {
				if (!charMap.containsKey(str1[i]) || charMap.get(str1[i]) != str2[i])
					return false;
			}
			if (charMap.containsKey(str1[i])) {
				if (charMap.get(str1[i]) != str2[i])
					return false;
			} else {
				charMap.put(str1[i], str2[i]);
			}
		}

		return true;
	}

	public static void main(String[] args) {
		String s = "egg";
		String t = "add";
		System.out.println("Result of two Strings Isomorphism: " + isIsomorphic(s, t));
	}

}
