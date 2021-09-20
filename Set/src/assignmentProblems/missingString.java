package assignmentProblems;

import java.util.*;

public class missingString {

	public static void main(String[] args) {
		String str1 = "This is a string";
		String str2 = "is string";
		StringTokenizer st1 = new StringTokenizer(str1, " ");
		StringTokenizer st2 = new StringTokenizer(str2, " ");
		HashSet<String> input = new HashSet<String>();
		while (st2.hasMoreTokens()) {
			var temp = st2.nextToken();
			input.add(temp);
			System.out.println(temp);
		}
		ArrayList<String> output = new ArrayList<String>();
		while (st1.hasMoreTokens()) {
			var temp = st1.nextToken();
			if (!input.contains(temp))
				output.add(temp);
		}
		System.out.println(output.toString());
	}
}
