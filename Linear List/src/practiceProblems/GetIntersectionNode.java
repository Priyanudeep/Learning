package practiceProblems;

import java.util.HashSet;

public class GetIntersectionNode {

	// https://leetcode.com/problems/intersection-of-two-linked-lists/
	// Runtime: 15 ms, faster than 9.74% of Java online submissions for Intersection of Two Linked Lists.
	// Memory Usage: 53.5 MB, less than 5.14% of Java online submissions for Intersection of Two Linked Lists.
	// NOTE1: problem requires creating intersection of two lists. This is still un-implemented
	// NOTE2: performance improved solution to try: compare the lists from same length.
	private static ListNode solution1(ListNode headA, ListNode headB) {
		HashSet<ListNode> nodeSet = new HashSet<ListNode>();
		ListNode curr = headA;
		while (curr != null) {
			nodeSet.add(curr);
			curr = curr.next;
		}
		curr = headB;
		while (curr != null) {
			if (nodeSet.contains(curr))
				return curr;
			curr = curr.next;
		}
		return null;
	}

	public static void main(String[] args) {

	}
}
