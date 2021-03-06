package practiceProblems;

public class SplitListToParts {

	// https://leetcode.com/problems/split-linked-list-in-parts/submissions/
	// Runtime: 6 ms, faster than 5.33% of Java online submissions for Split Linked List in Parts.
	// Memory Usage: 40.9 MB, less than 10.65% of Java online submissions for Split Linked List in Parts.
	private static ListNode[] solution1(ListNode head, int k) {
		ListNode[] result = new ListNode[k];
		ListNode curr = head;
		int len = 0;
		while (curr != null) {
			++len;
			curr = curr.next;
		}
		System.out.println("Length: " + len);
		int div = len / k;
		int rem = len % k;
		curr = head;
		int j = 0;
		while (rem > 0) {
			result[j] = curr;
			++j;
			for (int i = div; i > 0; --i) {
				curr = curr.next;
			}
			ListNode temp = curr.next;
			curr.next = null;
			curr = temp;
			--rem;
		}
		while (curr != null) {
			result[j] = curr;
			++j;
			for (int i = div - 1; i > 0; --i) {
				curr = curr.next;
			}
			ListNode temp = curr.next;
			curr.next = null;
			curr = temp;
			--rem;
		}
		return result;
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		ListNode node = new ListNode();
		node = node.createList(arr);
		var result = solution1(node, 50);
	}
}
