package assignmentProblems;

import java.util.Stack;
import java.util.StringTokenizer;

public class ExpressionEvaluation {

	private static void expressionEvaluator(StringTokenizer input) {
		Stack<Integer> numeralStack = new Stack<Integer>();
		Stack<String> symbolStack = new Stack<String>();
		int finalValue = 0;
		while (input.hasMoreTokens()) {
			var token = input.nextToken();
			var tokenNum = getNumber(token);
			if (tokenNum != Integer.MIN_VALUE)
				numeralStack.push(tokenNum);
			else {
				if (symbolStack.isEmpty())
					symbolStack.push(token);
				else {
					if (token.equals(")")) {
						while (!symbolStack.peek().equals("(")) {
							tokenNum = operate(numeralStack.pop(), numeralStack.pop(), symbolStack.pop());
							numeralStack.push(tokenNum);
						}
						if (symbolStack.peek().equals("("))
							symbolStack.pop();

					} else if (!symbolStack.peek().equalsIgnoreCase("(")
							&& getSymbolPriority(symbolStack.peek()) >= getSymbolPriority(token)) {
						tokenNum = operate(numeralStack.pop(), numeralStack.pop(), symbolStack.pop());
						numeralStack.push(tokenNum);
						symbolStack.push(token);
					} else
						symbolStack.push(token);
					
				}
			}
		}
		if (!symbolStack.isEmpty())
			finalValue = operate(numeralStack.pop(), numeralStack.pop(), symbolStack.pop());

		System.out.println(finalValue);
		System.out.println(numeralStack.toString());
	}

	private static int getNumber(String input) {
		try {
			return Integer.parseInt(input);
		} catch (Exception ex) {
			return Integer.MIN_VALUE;
		}
	}

	private static int getSymbolPriority(String c) {
		if (c.equals("("))
			return 1;
		else if (c.equals("-"))
			return 2;
		else if (c.equals("+"))
			return 3;
		else if (c.equals("/"))
			return 4;
		else if (c.equals("*"))
			return 5;
		else if (c.equals(")"))
			return 6;
		else
			return 0;
	}

	private static int operate(int first, int second, String operator) {
		if (operator.equals("+"))
			return first + second;
		else if (operator.equals("-"))
			return -first + second;
		else if (operator.equals("*"))
			return first * second;
		else if (operator.equals("/"))
			return second / first;
		else
			return Integer.MIN_VALUE;
	}

	public static void main(String[] args) {
		// ((2+3*4)-6/3)*5
		StringTokenizer example = new StringTokenizer(args[0], "#");
//		while (example.hasMoreTokens())
//			System.out.print(example.nextToken());
		expressionEvaluator(example);
	}

}
