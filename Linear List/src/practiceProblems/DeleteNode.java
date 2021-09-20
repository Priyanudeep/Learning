package practiceProblems;

public class DeleteNode {

	private static void deleteNode(ListNode node) {
		ListNode head = node;
		while (node != null) {
			node.value = node.next.value;
			if(node.next.next == null)
				node.next = null;
			node = node.next;
		}
		node = null;
		head.printList(head);
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 4, 5, 1, 9 };
		ListNode head = new ListNode();
		head = head.createList(arr);
		head.printList(head);
		deleteNode(head.next);
	}

}
