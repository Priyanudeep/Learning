package assignmentProblems;

public class LastManStanding {
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		SListImpl circle = new SListImpl();
		for(int i = 0; i < n; ++i)
			circle.addLast(i+1);
		circle.display();
		System.out.println();
		circle.myFunction();
		circle.display();
	}
}
