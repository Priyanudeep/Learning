package practiceProblems;

public class ReorderList {

	// https://leetcode.com/problems/reorder-list/description/
	// Runtime: 1 ms, faster than 99.92% of Java online submissions for Reorder List.
	// Memory Usage: 41.6 MB, less than 66.50% of Java online submissions for Reorder List.
	private static void solution1(ListNode head) {
		if(head == null || head.next == null)
			return;
		ListNode fast = head, slow = head;
		while (fast.next != null) {
			slow = slow.next;
			if(fast.next.next == null)
				fast = fast.next;
			else
				fast = fast.next.next;
		}
		System.out.println("Slow: " + slow.val);
		System.out.println("Fast: " + fast.val);
		ListNode curr = slow;
		ListNode prev = null;
		while(curr != null) {
			fast = curr.next;
			curr.next = prev;
			prev = curr;
			curr = fast;
		}
		slow = head;
		fast = prev;
		head.printList(head);
		prev.printList(prev);
		while(slow.next != null && fast.next != null) {
			prev = fast.next;
			curr = slow.next;
			slow.next = fast;
			fast.next = curr;
			slow = curr;
			fast = prev;
		}
		if(slow != fast)
			slow.next = fast;
		head.printList(head);
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 1, 2, 3, 4, 5};
		ListNode node = new ListNode();
		node = node.createList(arr);
		solution1(node);
	}
}
