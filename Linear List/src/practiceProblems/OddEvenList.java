package practiceProblems;

public class OddEvenList {

	// https://leetcode.com/problems/odd-even-linked-list/
	// Runtime: 1 ms, faster than 12.10% of Java online submissions for Odd Even Linked List.
	// Memory Usage: 41.4 MB, less than 17.85% of Java online submissions for Odd Even Linked List.
	private static ListNode solution1(ListNode head) {
		if (head == null || head.next == null || head.next.next == null) {
			return head;
		}
		int i = 1;
		ListNode odd = head;
		ListNode even = head.next;
		for (ListNode curr = even.next; curr != null; curr = curr.next, ++i) {
			if(i % 2 == 1) {
				ListNode temp = odd.next;
				odd.next = curr;
				even.next = curr.next;
				curr.next = temp;
				odd = curr;
				curr = even;				
			}
			else {
				even = curr;
			}
		}
		return head;
	}
	
	// try to use only pointers and avoid the int to keep track of odd, even cases.
	private static ListNode solution2(ListNode head) {
		return head;
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 1,2};
		ListNode node = new ListNode();
		node = node.createList(arr);
		node = solution1(node);
		node.printList(node);
	}
}
