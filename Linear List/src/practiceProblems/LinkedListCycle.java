package practiceProblems;

public class LinkedListCycle {

	// https://leetcode.com/problems/linked-list-cycle/
	// Runtime: 0 ms, faster than 100.00% of Java online submissions for Linked List
	// Cycle.
	// Memory Usage: 40.1 MB, less than 65.51% of Java online submissions for Linked
	// List Cycle.
	private static boolean solution1(ListNode head) {
		if (head == null || head.next == null)
			return false;
		else if (head.next == head)
			return true;
		else {
			ListNode slow = head;
			ListNode fast = slow.next;
			while (fast != null && fast.next != null) {
				if (slow == fast)
					return true;
				slow = slow.next;
				fast = fast.next.next;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 3, 2, 0, -4 };
		// This problem needs creating a looped linked list. This util method is not
		// implemented yet
		// However, the solution is evaluated in leetcode editor.
		ListNode node = new ListNode();
		node.createList(arr);
		solution1(node);
	}

}
