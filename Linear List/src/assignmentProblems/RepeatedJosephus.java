package assignmentProblems;

import java.util.ArrayList;
import java.util.Arrays;
//import java.util.Random;

public class RepeatedJosephus {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> a = new ArrayList<Integer>();
		var n = Integer.parseInt(args[0]);
		for (int i = 0; i < n; ++i)
			a.add(i + 1);
		System.out.println(Arrays.toString(a.toArray()));
		// int size = a.size();
		int start = 0;
		int k = 5;
		int targetIndex = 0;
		while (a.size() > 1) {
			targetIndex = start + k - 1;
			if (targetIndex >= a.size())
				targetIndex = targetIndex % (a.size());
			a.remove(targetIndex);
			if (targetIndex < a.size())
				start = targetIndex;
			else
				start = a.size() - targetIndex;
//			if (start >= a.size())
//				start = start % (a.size());
			System.out.println(Arrays.toString(a.toArray()));
		}
		// System.out.println(Arrays.toString(a.toArray()));
	}

}
