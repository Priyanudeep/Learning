package test;

public class ReverseWordsInString {

	private static char[] reverseString(char[] input) {
		for (int i = 0; i < input.length / 2; ++i) {
			char temp = input[i];
			input[i] = input[input.length - 1 - i];
			input[input.length - 1 - i] = temp;
		}
		return input;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// take input from command line
		// convert the string input to character array
		// traverse the array and stop at space ' '
		// send the substring to reverse method
		// append the result of the method
		System.out.println(args[0]);
		String finalOutput = "";
		for (int i = 0; i < args.length; ++i) {
			// var temp = args[i].toCharArray();
			var temp = String.valueOf(reverseString(args[i].toCharArray()));
			finalOutput += temp + " ";
		}
		// String example = "HelloWorld";
		// var temp = example.toCharArray();
		System.out.println(finalOutput);
	}

}
