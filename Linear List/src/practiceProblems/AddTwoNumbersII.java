package practiceProblems;

public class AddTwoNumbersII {

	// Runtime: 2 ms, faster than 97.81% of Java online submissions for Add Two
	// Numbers II.
	// Memory Usage: 39.1 MB, less than 89.91% of Java online submissions for Add
	// Two Numbers II.
	private static ListNode solution1(ListNode l1, ListNode l2) {
		ListNode result = new ListNode();
		l1 = reverseList(l1);
		// l1.printList(l1);
		l2 = reverseList(l2);
		// l2.printList(l2);
		int carry = 0;
		ListNode current = result;
		while (l1 != null || l2 != null) {
			int first = l1 != null ? l1.value : 0;
			int second = l2 != null ? l2.value : 0;
			int value = first + second + carry;
			ListNode temp = new ListNode(value % 10);
			current.next = temp;
			carry = value / 10;
			current = current.next;
			if (l1 != null)
				l1 = l1.next;
			if (l2 != null)
				l2 = l2.next;
		}
		if (carry != 0) {
			ListNode temp = new ListNode(carry);
			current.next = temp;
		}
		result = reverseList(result.next);
		return result;
	}

	// Error for test case l1: { 3, 9, 9, 9, 9, 9, 9, 9, 9, 9 } and l2: { 7 }.
	// This is because the sum value is greater than Integer.MaxValue
	private static ListNode solution2(ListNode l1, ListNode l2) {
		ListNode result = new ListNode();
		int l1_len = 0;
		int l2_len = 0;
		ListNode curr = l1;
		while (curr != null) {
			++l1_len;
			curr = curr.next;
		}
		curr = l2;
		while (curr != null) {
			++l2_len;
			curr = curr.next;
		}
		int l1_sum = 0, l2_sum = 0;
		curr = l1;
		while (l1_len > 0) {
			l1_sum += curr.value * Math.pow(10, --l1_len);
			curr = curr.next;
		}
		curr = l2;
		while (l2_len > 0) {
			l2_sum += curr.value * Math.pow(10, --l2_len);
			curr = curr.next;
		}
		l1_sum = l1_sum + l2_sum;
		String sum_str = Integer.toString(l1_sum);
		curr = result;
		for (Character c : sum_str.toCharArray()) {
			ListNode temp = new ListNode(Character.getNumericValue(c));
			curr.next = temp;
			curr = curr.next;
		}
		System.out.println(l1_sum);
		return result.next;
	}

	private static ListNode reverseList(ListNode l1) {
		ListNode current = l1;
		ListNode prev = null;
		ListNode next = current.next;
		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		return prev;
	}

	public static void main(String[] args) {
		int[] l1_array = new int[] { 3, 9, 9, 9, 9, 9, 9, 9, 9, 9 };
		int[] l2_array = new int[] { 7 };
		ListNode node = new ListNode();
		ListNode l1 = node.createList(l1_array);
		ListNode l2 = node.createList(l2_array);
		ListNode answer = solution2(l1, l2);
		answer.printList(answer);
	}

}
