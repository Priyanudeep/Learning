package test;

public class AnagramSubstringMatch {

	private static boolean isAnagram(char[] input1, char[] input2) {
		int[] temp = new int[26];
		for (int i = 0; i < input1.length; ++i) {
			temp[input1[i] - 'a']++;
			temp[input2[i] - 'a']--;
		}
		for (int i = 0; i < temp.length; ++i) {
			if (temp[i] != 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "dcbaebabacd";
		String p = "abc";
		char[] sArr = s.toCharArray();
		char[] pArr = p.toCharArray();
		int[] output = new int[s.length() - 2];
//		System.out.println(sArr[0] - 'a');
		int k = 0;
		int sLength = s.length();
		int pLength = p.length();
		for (int i = 0; i <= sLength - pLength; ++i) {
			char[] temp = new char[pLength];

			for (int j = 0; j < pLength; ++j) {
				temp[j] = sArr[i + j];
			}

			if (isAnagram(temp, pArr)) {
				output[k] = i;
				k++;
			}
		}
		System.out.println(output);

	}

}
