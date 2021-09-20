package practiceProblems;

public class RotateList {

	// https://leetcode.com/problems/rotate-list/description/
	// Runtime: 0 ms, faster than 100.00% of Java online submissions for Rotate
	// List.
	// Memory Usage: 38.2 MB, less than 78.45% of Java online submissions for Rotate
	// List.
	private static ListNode solution1(ListNode head, int k) {
		if (k == 0 || head == null || head.next == null)
			return head;
		ListNode curr = head;
		int length = 0;
		while (curr != null) {
			++length;
			curr = curr.next;
		}
		if (k > length)
			k = k % length;
		if (k == 0 || k == length)
			return head;
		curr = head;
		for (int i = 0; i < length - k - 1; ++i) {
			curr = curr.next;
		}
		ListNode first = head;
		ListNode temp = curr.next;
		curr.next = null;
		curr = temp;
		head = temp;
		while (curr.next != null)
			curr = curr.next;
		curr.next = first;
		return head;
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 1, 2, 3, 4, 5 };
		ListNode node = new ListNode();
		node = node.createList(arr);
		node = solution1(node, 111);
		node.printList(node);
	}
}
