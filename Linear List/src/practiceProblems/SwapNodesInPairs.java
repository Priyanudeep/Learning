package practiceProblems;

public class SwapNodesInPairs {

	// https://leetcode.com/problems/swap-nodes-in-pairs/description/
	// Runtime: 0 ms, faster than 100.00% of Java online submissions for Swap Nodes
	// in Pairs.
	// Memory Usage: 38.5 MB, less than 17.25% of Java online submissions for Swap
	// Nodes in Pairs.
	private static ListNode solution1(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode prev = null;
		for (ListNode curr = head; curr != null; curr = curr.next) {
			ListNode second = curr.next;
			if (second != null) {
				curr.next = second.next;
				second.next = curr;
				if (prev != null)
					prev.next = second;
				else
					head = second;
				prev = curr;
			} else
				break;
		}
		return head;
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 1 };
		ListNode node = new ListNode();
		node = node.createList(arr);
		node = solution1(node);
		node.printList(node);
	}
}
