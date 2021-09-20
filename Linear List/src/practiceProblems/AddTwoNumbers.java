package practiceProblems;

public class AddTwoNumbers {

	// Runtime: 4 ms, faster than 16.60% of Java online submissions for Add Two
	// Numbers.
	// Memory Usage: 45 MB, less than 5.38% of Java online submissions for Add Two
	// Numbers.
	// NOTE: 0 ms solution has the same approach. Probably trivial conditions differ
	private static ListNode solution1(ListNode l1, ListNode l2) {
		ListNode result = new ListNode();
		ListNode current = result;
		int carry = 0;
		while (l1 != null || l2 != null) {
			int firstDigit = l1 == null ? 0 : l1.value;
			int secondDigit = l2 == null ? 0 : l2.value;
			int value = firstDigit + secondDigit + carry;
			ListNode temp = new ListNode(value % 10);
			current.next = temp;
			current = current.next;
			carry = value / 10;
			if (l1 != null)
				l1 = l1.next;
			if (l2 != null)
				l2 = l2.next;

		}
		if (carry != 0) {
			ListNode temp = new ListNode(carry);
			current.next = temp;
		}

		return result.next;
	}

	public static void main(String[] args) {
		int[] l1_array = new int[] { 9, 9, 9, 9, 9, 9, 9 };
		int[] l2_array = new int[] { 9, 9, 9, 9 };
		ListNode node = new ListNode();
		ListNode l1 = node.createList(l1_array);
		ListNode l2 = node.createList(l2_array);
		ListNode answer = solution1(l1, l2);
		answer.printList(answer);
	}

}
