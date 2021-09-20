package practiceProblems;

public class ReverseLinkedListII {

	// https://leetcode.com/problems/reverse-linked-list-ii/description/
	// Runtime: 0 ms, faster than 100.00% of Java online submissions for Reverse
	// Linked List II.
	// Memory Usage: 36.4 MB, less than 82.18% of Java online submissions for
	// Reverse Linked List II.
	private static ListNode solution1(ListNode head, int left, int right) {
		if (head.next == null)
			return head;
		int start = 0;
		ListNode begin = head;
		for (ListNode curr = head; curr.next != null; curr = curr.next) {
			++start;
			if (start == left - 1) {
				begin = curr;
			}
			if (start == left) {
				if (begin == head && begin == curr)
					return reverseList(curr, right - left + 1);
				else
					begin.next = reverseList(curr, right - left + 1);
				return head;
			}
		}
		return head;
	}

	public static ListNode reverseList(ListNode head, int len) {
		ListNode curr = head;
		ListNode prev = null;
		ListNode temp = null;
		while (len > 0) {
			temp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = temp;
			--len;
		}
		head.next = temp;
		return prev;
	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode();
		int[] arr = new int[] { 1, 2 };
		l1 = l1.createList(arr);
		l1 = solution1(l1, 1, 2);
		l1.printList(l1);
	}

}
