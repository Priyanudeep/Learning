package practiceProblems;

public class ReverseKnodes {

	private static ListNode reverseList(ListNode head) {
		ListNode prev = null;
		ListNode current = head;
		ListNode temp = current.next;

		while (current != null) {
			current.next = prev;
			prev = current;
			current = temp;
			if (temp != null) {
				temp = temp.next;
			}
		}
		return prev;
	}

	private static ListNode reverseKnodes(ListNode head, int k) {
		ListNode prev = null;
		ListNode current = head;
		ListNode temp = current.next;
		boolean setHead = false;
		ListNode dummy = new ListNode();
		dummy.next = head;
		ListNode last;

		while (current != null) {
			ListNode start = current;
			if (!nodesExist(start, k)) {
				return dummy.next;
			}
			last = current;
			start = prev;
			for (int i = 0; i < k; ++i) {
				current.next = prev;
				prev = current;
				current = temp;
				if (temp != null) {
					temp = temp.next;
				}
			}
			last.next = current;
			if (!setHead) {
				setHead = true;
				dummy.next = prev;
			} else {
				start.next = prev;
			}
			prev = last;
		}
		return dummy.next;
	}

	private static boolean nodesExist(ListNode node, int k) {
		if (node == null || node.next == null)
			return false;
		int i = 0;
		while (node != null && i < k) {
			node = node.next;
			++i;
		}
		return i == k ? true : false;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode();
		ListNode current = head;
		ListNode node;
		for (int i = 1; i <= 5; ++i) {
			ListNode temp = new ListNode(i);
			current.next = temp;
			current = temp;
		}
		current = head.next;
		while (current != null) {
			System.out.print(current.value + "->");
			current = current.next;
		}
		System.out.println();
//		ListNode node = reverseList(head.next);
//		for (current = node; current != null; current = current.next) {
//			System.out.print(current.value + "->");
//		}
//		System.out.println();
		node = reverseKnodes(head.next, 2);
		for (current = node; current != null; current = current.next) {
			System.out.print(current.value + "->");
		}
		System.out.println();
	}

}
