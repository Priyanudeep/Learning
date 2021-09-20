package assignmentProblems;

import java.util.Random;

public class TestSet {

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		ISet set = new SetImpl();
		Random r = new Random();
		for (int i = 0; i < n; ++i) {
			// set.add(r.nextInt(2 * n) + 1);
			set.add(i + 1);
		}
		set.display();
		System.out.println(set.size());
		int x = r.nextInt(n) + 1;
		System.out.println(x);
		System.out.println(set.remove(x));
		// set.display();
	}

}
