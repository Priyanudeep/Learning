package assignmentProblems;

public class ReverseSingleLinkedList {

	public static void main(String[] args) {
		ListNode myList = new ListNode(1);
		ListNode head = new ListNode();
		head.next = myList;
		for (int i = 2; i <= 5; ++i) {
			ListNode temp = new ListNode(i);
			myList.next = temp;
			myList = myList.next;
		}
		for (ListNode temp = head.next; temp != null; temp = temp.next)
			System.out.print(temp.val + "->");

		ListNode prev = null, temp, current = head.next;
		while (current != null) {
			temp = current.next;
			current.next = prev;
			prev = current;
			current = temp;
		}
		head.next = prev;
		System.out.println();
		for (ListNode curr = head.next; curr != null; curr = curr.next)
			System.out.print(curr.val + "->");
	}

}
