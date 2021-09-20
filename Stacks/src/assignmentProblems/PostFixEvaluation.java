package assignmentProblems;

import java.util.Stack;

public class PostFixEvaluation {

	private static void evaluator(char[] input) {
		Stack<Integer> temp = new Stack<Integer>();
		int exp = 0;
		for (var c : input) {
			if (!isOperator(c))
				temp.push(Integer.parseInt(Character.toString(c)));
			else {
				if (c == '+')
					exp = temp.pop() + temp.pop();
				else if(c == '-')
					exp = -temp.pop() + temp.pop();
				else if(c == '*')
					exp = temp.pop() * temp.pop();
				else if(c == '/')
					exp = (1/temp.pop()) * temp.pop();
				temp.push(exp);
			}
			System.out.println(temp);
		}
	}

	private static boolean isOperator(char c) {
		if (c == '+' || c == '-' || c == '*' || c == '/')
			return true;
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		var inputArray = args[0].toCharArray();
		evaluator(inputArray);
	}

}
