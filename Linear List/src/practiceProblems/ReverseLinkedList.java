package practiceProblems;

public class ReverseLinkedList {
	// Runtime: 0 ms, faster than 100 % of Java online submissions for Reverse Linked List
	// Memory Usage: 38.7 MB, less than 75.65 % of Java online submissions for Reverse Linked List
	public static ListNode solution1(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode current = head;
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
		ListNode node = new ListNode();
		ListNode l1 = node.createList(l1_array);
		l1 = solution1(l1);
		l1.printList(l1);
	}
}
