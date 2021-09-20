package assignmentProblems;

import java.util.ArrayList;
import java.util.HashMap;

public class MostCommonWord {

	private static void findMostCommonWord(String paragraph) {
		int[] delimiters = { '.', ',', ' ' };
		ArrayList<Integer> some = new ArrayList<Integer>();
		for (int i : delimiters) {
			some.add(i);
		}
		ArrayList<String> banned = new ArrayList<String>();
		//banned.add("hit");

		HashMap<String, Integer> wordFrequency = new HashMap<String, Integer>();
		var para_char_ary = paragraph.toCharArray();
		String word_bld = "";
		for (char c : para_char_ary) {
			int c_ascii = c;
			if (some.contains(c_ascii)) {
				word_bld = word_bld.toLowerCase();
				if (!banned.contains(word_bld)) {
					if (wordFrequency.containsKey(word_bld))
						wordFrequency.put(word_bld, wordFrequency.get(word_bld) + 1);
					else
						wordFrequency.put(word_bld, 1);
				}
				word_bld = "";
			} else {
				word_bld += c;
			}
		}
		int greatest = 0;
		String output = "";
		for (var item : wordFrequency.keySet()) {
			if (wordFrequency.get(item) > greatest) {
				greatest = wordFrequency.get(item);
				output = item;
			}
		}
		//System.out.println(wordFrequency);
		System.out.println(output);
	}

	public static void main(String[] args) {
		findMostCommonWord(args[0]);
	}
}
