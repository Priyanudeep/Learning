package practiceProblems;

public class RemoveNthFromEnd {

	// https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
	// Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove Nth Node From End of List.
	// Memory Usage: 39 MB, less than 22.44% of Java online submissions for Remove Nth Node From End of List.
	private static ListNode solution1(ListNode head, int n) {
		ListNode curr = head;
		int len = 0;
		while (curr != null) {
			++len;
			curr = curr.next;
		}
		ListNode prev = null;
		curr = head;
		for (int j = 1; j <= len - n; ++j) {
			prev = curr;
			curr = curr.next;
		}
		if(prev == null)
			head = head.next;
		else {
			prev.next = curr.next;
			curr.next = null;	
		}
		
		return head;
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		ListNode node = new ListNode();
		node = node.createList(arr);
		node = solution1(node, 8);
		node.printList(node);
	}

}
