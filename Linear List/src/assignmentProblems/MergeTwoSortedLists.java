package assignmentProblems;

public class MergeTwoSortedLists {

	private static ListNode mergeTwoSortedArrays(ListNode l1, ListNode l2) {
		ListNode current1 = l1, current2 = l2, start, prev2, current, prev, head;
		if (current1.val >= current2.val) {
			head = current2;
			current2 = current1;
		} else {
			head = current1;
		}
		current = head;
		prev = head;
		prev2 = current2;

		while (current != null && current2 != null) {
			if (current.val >= current2.val) {
				start = current2;
				while (current.val >= current2.val) {
					if (current2.next == null) {
						prev.next = start;
						current2.next = current;
						current2 = null;
						break;
					}
					prev2 = current2;
					current2 = current2.next;
				}
				ListNode temp = prev2.next;
				prev2.next = current;
				prev.next = prev2;
				current = temp;
			} else {
				// start = current;
				while (current.val < current2.val) {
					if (current.next == null) {
						current.next = current2;
						current = null;
						return head;
					}
					prev = current;
					current = current.next;
				}
				ListNode temp = current2.next;
				current2.next = current;
				prev.next = current2;
				current2 = temp;
			}
		}
		if (current == null)
			prev.next = current2;
		else if (current2 == null)
			prev2.next = current;
		return head;
//		for (ListNode temp = head; temp != null; temp = temp.next) {
//			System.out.print(temp.val + "->");
//		}
	}

	private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if(l1 == null)
			return l2;
		if(l2 == null)
			return l1;			
		ListNode head = new ListNode();
		ListNode current1 = l1;
		ListNode current2 = l2;
		ListNode current = head;

		while (current1 != null && current2 != null) {
			ListNode temp;
			if (current1.val >= current2.val) {
				temp = new ListNode(current2.val);
				current.next = temp;
				current = current.next;
				if(current2.next == null) {
					current.next = current1;
				}
				current2 = current2.next;
			} else {
				temp = new ListNode(current1.val);
				current.next = temp;
				current = current.next;
				if(current1.next == null) {
					current.next = current2;
				}
				current1 = current1.next;
			}
		}
		return head.next;
	}

	public static void main(String[] args) {
//		ListNode l1 = new ListNode(1);
//		ListNode head1 = l1;
//		for (int i = 2; i < 5; ++i) {
//			ListNode temp = new ListNode(i);
//			head1.next = temp;
//			head1 = head1.next;
//		}
//		for (ListNode temp = l1; temp != null; temp = temp.next) {
//			System.out.print(temp.val + "->");
//		}
//		System.out.println();
//		ListNode l2 = new ListNode(2);
//		ListNode head2 = l2;
//		for (int i = 3; i < 6; ++i) {
//			ListNode temp = new ListNode(i);
//			head2.next = temp;
//			head2 = head2.next;
//		}
//		for (ListNode temp = l2; temp != null; temp = temp.next) {
//			System.out.print(temp.val + "->");
//		}
//		System.out.println();
		int[] list1 = new int[] { 1, 2, 4 };//{ 7, 25, 41, 56 };
		int[] list2 = new int[] { 1, 3, 4 };//{ 1, 2, 3, 4, 9, 26, 30, 35 }; 
		ListNode l1 = new ListNode();
		ListNode l2 = new ListNode();
		ListNode head1 = l1;
		ListNode head2 = l2;
		for (int i = 0; i < list1.length; ++i) {
			ListNode temp = new ListNode(list1[i]);
			head1.next = temp;
			head1 = head1.next;
		}
		for (int i = 0; i < list2.length; ++i) {
			ListNode temp = new ListNode(list2[i]);
			head2.next = temp;
			head2 = head2.next;
		}
		for (ListNode temp = l1.next; temp != null; temp = temp.next) {
			System.out.print(temp.val + "->");
		}
		System.out.println();
		for (ListNode temp = l2.next; temp != null; temp = temp.next) {
			System.out.print(temp.val + "->");
		}
		System.out.println();
		ListNode head = mergeTwoLists(l1.next, l2.next);
		for (ListNode temp = head; temp != null; temp = temp.next) {
			System.out.print(temp.val + "->");
		}
		System.out.println();
	}
}
