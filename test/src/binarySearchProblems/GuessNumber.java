package binarySearchProblems;

public class GuessNumber {

	private static int pick = 0;

	private static int guessNum(int n) {
		int returnValue = -100;
		if (n < pick) {
			returnValue = -1;
		} else if (n == pick) {
			returnValue = 0;
		} else if (n > pick) {
			returnValue = 1;
		}
		return returnValue;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = Integer.parseInt(args[0]);
		pick = Integer.parseInt(args[1]);

		int arr[] = new int[n];
		for (int i = 0; i < n; ++i) {
			arr[i] = i + 1;
		}
//		for (int i = 0; i < n; ++i) {
//			System.out.print(" " + arr[i] + " ");
//		}
//		System.out.println(pick);
		int start, last, middle;
		start = 0;
		last = n - 1;
		
		while (start <= last) {
			middle = (start + last) / 2;
			int result = guessNum(arr[middle]);
			if (result == -1) {
				start = middle + 1;
			}
			if (result == 0) {
				System.out.println("\nYour guess is : " + arr[middle]);
				break;
			}
			if (result == 1) {
				last = middle - 1;
			}
		}
	}

}
