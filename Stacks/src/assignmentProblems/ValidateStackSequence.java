package assignmentProblems;

import java.util.Stack;

public class ValidateStackSequence {

	private static boolean solution1(int[] pushed, int[] popped) {
		if (pushed.length != popped.length)
			return false;
		Stack<Integer> myStack = new Stack<Integer>();
		for (int i = 0; i < pushed.length; ++i) {
			if(popped[i])
		}
		return true;
	}

	public static void main(String[] args) {

	}
}