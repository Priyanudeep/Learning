package practiceProblems;

public class PartitionList {
	// https://leetcode.com/problems/partition-list/description/
	// Runtime: 1 ms, faster than 17.71% of Java online submissions for Partition List.
	// Memory Usage: 39.4 MB, less than 15.17% of Java online submissions for Partition List.
	private static ListNode solution1(ListNode head, int x) {
		if (head == null || head.next == null)
			return head;
		ListNode less = head.val < x ? head : null;
		ListNode great = less == null ? head : null;
		for (ListNode curr = head.next; curr != null; curr = curr.next) {
			if (curr.val < x) {
				if (less == null) {
					ListNode temp = head;
					head = curr;
					great.next = curr.next;
					curr.next = temp;
					less = curr;
					curr = great;
				} else {
					if (great == null) {
						less = curr;
						continue;
					}						
					ListNode temp = less.next;
					less.next = curr;
					great.next = curr.next;
					less = curr;
					curr.next = temp;
					curr = great;
				}
			} else {
				great = curr;
			}
		}
		return head;
	}
	
	// Approach: create nodes for less and great lists. Keep adding/pointing nodes from given list.
	// Append both the lists and return;
	private static ListNode solution2(ListNode head, int x) {
	
		
		return head;
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 2, 0, 4, 1, 3, 1, 4, 0, 3 };
		int x = 4;
		ListNode node = new ListNode();
		node = node.createList(arr);
		node = solution1(node, x);
		node.printList(node);
	}
}